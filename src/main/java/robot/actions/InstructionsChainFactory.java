package robot.actions;

import io.vavr.control.Either;
import io.vavr.control.Option;
import robot.Robot;

import java.util.function.Function;
import java.util.function.IntFunction;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;
import static robot.actions.moving.ProceedForwardInstruction.forwardInstruction;
import static robot.actions.turning.TurnLeftInstruction.leftInstruction;
import static robot.actions.turning.TurnRightInstruction.rightInstruction;

/**
 * Creates a chain of Function<Either<IllegalArgumentException, Robot>, Either<IllegalArgumentException, Robot>>(s) chained via Function::andThen.
 */
public class InstructionsChainFactory {
    public static Function<Either<IllegalArgumentException, Robot>, Either<IllegalArgumentException, Robot>> instructionChain(String line) {

        final Function<Character, Function<Either<IllegalArgumentException, Robot>, Either<IllegalArgumentException, Robot>>> generateInstruction =
                (Character instruction) ->
                        Match(Option.of(instruction)).of(
                          Case($Some($('F')), forwardInstruction()),
                          Case($Some($('R')), rightInstruction()),
                          Case($Some($('L')), leftInstruction()),
                          Case($(), () -> leftEither -> Either.left(new IllegalArgumentException("Unknown command")))
                        );

        return Match(Option.of(line)).of(
                Case($Some($(l -> l.length() > 100)), () -> leftEither -> Either.left(new IllegalArgumentException("Instruction chain cannot be longer than 100"))),
                Case($Some($(l -> l.length() <= 100)),
                        () -> line.chars().mapToObj(c -> (char)c).map(generateInstruction).reduce(e -> e.map(r -> r), Function::andThen)),
                Case($None(), () -> leftEither -> Either.left(new IllegalArgumentException("instructions line required"))),
                Case($(), () -> leftEither -> Either.left(new IllegalArgumentException("unknown line")))
        );
    }
}
