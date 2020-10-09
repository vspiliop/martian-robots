package robot.actions.moving;

import io.vavr.control.Either;
import robot.Robot;

import java.util.function.Function;

public class ProceedForwardInstruction implements Function<Either<IllegalArgumentException, Robot>, Either<IllegalArgumentException, Robot>> {

    private static final ProceedForwardInstruction FORWARD_INSTRUCTION = new ProceedForwardInstruction();

    private ProceedForwardInstruction() {}

    public static ProceedForwardInstruction forwardInstruction() {
        return FORWARD_INSTRUCTION;
    }

    @Override
    public Either<IllegalArgumentException, Robot> apply(Either<IllegalArgumentException, Robot> robot) {
        return robot.flatMap(r -> r.forward());
    }
}
