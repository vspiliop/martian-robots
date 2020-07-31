import java.util.function.Consumer;

public class ProceedForwardInstruction implements Consumer<Robot> {

    @Override
    public void accept(Robot robot) {
        robot.forward();
    }
}
