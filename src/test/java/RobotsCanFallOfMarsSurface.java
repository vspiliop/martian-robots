import org.junit.Assert;
import org.junit.Test;

public class RobotsCanFallOfMarsSurface {

    private final ProceedForwardInstruction proceedForwardInstruction = new ProceedForwardInstruction();

    private final CartesianCoordinates coordinates = new CartesianCoordinates(3, 3);

    @Test(expected = IllegalStateException.class)
    public void robotFell() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(coordinates), new NorthOrientation());
        robot.execute(proceedForwardInstruction.andThen(proceedForwardInstruction).andThen(proceedForwardInstruction));
    }

    @Test()
    public void robotStillInMars() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(coordinates), new NorthOrientation());
        robot.execute(proceedForwardInstruction.andThen(proceedForwardInstruction));
    }

}
