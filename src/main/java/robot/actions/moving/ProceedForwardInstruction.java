package robot.actions.moving;

import robot.Robot;

import java.util.function.Consumer;

public class ProceedForwardInstruction implements Consumer<Robot> {

    private static final ProceedForwardInstruction FORWARD_INSTRUCTION = new ProceedForwardInstruction();

    private ProceedForwardInstruction() {}

    public static ProceedForwardInstruction forwardInstruction() {
        return FORWARD_INSTRUCTION;
    }

    @Override
    public void accept(Robot robot) {
        robot.forward();
    }
}
