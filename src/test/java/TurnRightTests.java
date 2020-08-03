import mars.CartesianCoordinates;
import org.junit.Assert;
import org.junit.Test;
import robot.Robot;
import robot.actions.EastOrientation;
import robot.actions.NorthOrientation;
import robot.actions.SouthOrientation;
import robot.actions.WestOrientation;

public class TurnRightTests extends TestsCommonSetupOperations {

    @Test
    public void robotTurnsRightWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacing() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new EastOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new SouthOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new WestOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRight360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(turnRightInstruction.andThen(turnRightInstruction).andThen(turnRightInstruction).andThen(turnRightInstruction));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }
}
