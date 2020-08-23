package robot.actions.turning;

import robot.Robot;

import java.util.function.Consumer;

public class TurnRightInstruction implements Consumer<Robot> {

    private static final TurnRightInstruction RIGHT_INSTRUCTION = new TurnRightInstruction();

    private TurnRightInstruction() {}

    public static TurnRightInstruction rightInstruction() {
        return RIGHT_INSTRUCTION;
    }

    @Override
    public void accept(Robot robot) {
        robot.turnRight();
    }
}
