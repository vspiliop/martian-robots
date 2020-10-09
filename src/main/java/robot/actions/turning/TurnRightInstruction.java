package robot.actions.turning;

import io.vavr.control.Either;
import robot.Robot;

import java.util.function.Function;

public class TurnRightInstruction implements Function<Either<IllegalArgumentException, Robot>, Either<IllegalArgumentException, Robot>> {

    private static final TurnRightInstruction RIGHT_INSTRUCTION = new TurnRightInstruction();

    private TurnRightInstruction() {}

    public static TurnRightInstruction rightInstruction() {
        return RIGHT_INSTRUCTION;
    }

    @Override
    public Either<IllegalArgumentException, Robot> apply(Either<IllegalArgumentException, Robot> robot) {
        return robot.flatMap(r -> r.turnRight());
    }
}
