package robot.actions.turning;

import robot.Robot;

import java.util.function.Consumer;

public class TurnLeftInstruction implements Consumer<Robot> {

    @Override
    public void accept(Robot robot) {
        robot.turnLeft();
    }
}
