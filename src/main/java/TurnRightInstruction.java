import java.util.function.Consumer;

public class TurnRightInstruction implements Consumer<Robot> {

    @Override
    public void accept(Robot robot) {
        robot.turnRight();
    }
}
