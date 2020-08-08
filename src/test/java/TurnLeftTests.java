import mars.CartesianCoordinates;
import org.junit.Assert;
import org.junit.Test;
import robot.Robot;
import robot.actions.EastOrientation;
import robot.actions.NorthOrientation;
import robot.actions.SouthOrientation;
import robot.actions.WestOrientation;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;
import static robot.actions.turning.TurnLeftInstruction.leftInstruction;

public class TurnLeftTests extends TestsCommonSetupOperations {

    @Test
    public void robotTurnsLeftWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeftWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, westOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeftWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, southOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeftWhileFacingEast() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, eastOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeft360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(leftInstruction().andThen(leftInstruction()).andThen(leftInstruction()).andThen(leftInstruction()));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }
}
