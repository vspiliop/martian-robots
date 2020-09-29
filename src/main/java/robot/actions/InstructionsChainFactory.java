package robot.actions;

import io.vavr.control.Either;
import io.vavr.control.Option;
import robot.Robot;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;
import static robot.actions.moving.ProceedForwardInstruction.forwardInstruction;
import static robot.actions.turning.TurnLeftInstruction.leftInstruction;
import static robot.actions.turning.TurnRightInstruction.rightInstruction;

public class InstructionsChainFactory {
    public static Either<IllegalArgumentException, Consumer<Robot>> instructionChain(String line) {

        final IntFunction<Either<IllegalArgumentException, Consumer<Robot>>> generateInstruction = (int instruction) -> Match(instruction).of(
              Case($(i -> i == 'F'), Either.right(forwardInstruction())),
              Case($(i -> i == 'R'), Either.right(rightInstruction())),
              Case($(i -> i == 'L'), Either.right(leftInstruction())),
              Case($(), Either.left(new IllegalArgumentException("Unknown command"))));

        BinaryOperator<Either<IllegalArgumentException, Consumer<Robot>>> reductionFunction =
            (a, b) -> a.flatMap(ar -> b.map(br -> ar.andThen(br)));

        Either<IllegalArgumentException, Consumer<Robot>> identity = Either.right((Robot r) -> {});

        return Match(Option.of(line)).of(
                Case($Some($(l -> l.length() > 100)), Either.left(new IllegalArgumentException("Instruction chain cannot be longer than 100"))),
                Case($Some($(l -> l.length() <= 100)),
                        () -> line.chars().mapToObj(generateInstruction).reduce(identity, reductionFunction)),
                Case($None(), Either.left(new IllegalArgumentException("instructions line required"))),
                Case($(), Either.left(new IllegalArgumentException("unknown line")))
        );
    }
}
