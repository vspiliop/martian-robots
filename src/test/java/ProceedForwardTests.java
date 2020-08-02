import org.junit.Assert;
import org.junit.Test;

public class ProceedForwardTests extends TestsCommonSetupOperations {

    @Test
    public void robotProceedForwardWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(1,2));
    }

    @Test
    public void robotProceedForwardWhileFacingEast() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new EastOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(2,1));
    }

    @Test
    public void robotProceedForwardWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new SouthOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(1,0));
    }

    @Test
    public void robotProceedForwardWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new WestOrientation());
        robot.execute(proceedForwardInstruction);
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(0,1));
    }
}
