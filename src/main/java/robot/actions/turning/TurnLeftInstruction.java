package robot.actions.turning;

import robot.Robot;

import java.util.function.Consumer;

public class TurnLeftInstruction implements Consumer<Robot> {

    public static final TurnLeftInstruction LEFT_INSTRUCTION = new TurnLeftInstruction();

    private TurnLeftInstruction() {}

    public static TurnLeftInstruction leftInstruction() {
        return LEFT_INSTRUCTION;
    }

    @Override
    public void accept(Robot robot) {
        robot.turnLeft();
    }
}
