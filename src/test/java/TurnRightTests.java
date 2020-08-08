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
import static robot.actions.turning.TurnRightInstruction.rightInstruction;

public class TurnRightTests extends TestsCommonSetupOperations {

    @Test
    public void robotTurnsRightWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacing() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, eastOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, southOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, westOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRight360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(rightInstruction().andThen(rightInstruction()).andThen(rightInstruction()).andThen(rightInstruction()));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }
}
