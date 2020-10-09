package robot.actions.turning;

import io.vavr.control.Either;
import robot.Robot;

import java.util.function.Function;

public class TurnLeftInstruction implements Function<Either<IllegalArgumentException, Robot>, Either<IllegalArgumentException, Robot>> {

    private static final TurnLeftInstruction LEFT_INSTRUCTION = new TurnLeftInstruction();

    private TurnLeftInstruction() {}

    public static TurnLeftInstruction leftInstruction() {
        return LEFT_INSTRUCTION;
    }

    @Override
    public Either<IllegalArgumentException, Robot> apply(Either<IllegalArgumentException, Robot> robot) {
        return robot.flatMap(r -> r.turnLeft());
    }
}
