import org.junit.Assert;
import org.junit.Test;

public class ProceedForwardTests {

    private final ProceedForwardInstruction proceedForwardInstruction = new ProceedForwardInstruction();

    private final CartesianCoordinates coordinates = new CartesianCoordinates(50, 50);

    @Test
    public void robotProceedForwardWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(coordinates), new NorthOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(1,2));
    }

    @Test
    public void robotProceedForwardWhileFacingEast() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(coordinates), new EastOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(2,1));
    }

    @Test
    public void robotProceedForwardWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(coordinates), new SouthOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(1,0));
    }

    @Test
    public void robotProceedForwardWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(coordinates), new WestOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(0,1));
    }
}
