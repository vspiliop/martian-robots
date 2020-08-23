import mars.CartesianCoordinates;
import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;
import static robot.actions.turning.TurnRightInstruction.rightInstruction;

public class TurnRightTests extends TestsCommonSetupOperations {

    @Test
    public void robotTurnsRightWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(eastOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsRightWhileFacing() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, eastOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(southOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsRightWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, southOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(westOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsRightWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, westOrientation());
        robot.execute(rightInstruction());
        Assert.assertEquals(northOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsRight360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(instructionChain("RRRR"));
        Assert.assertEquals(northOrientation(), robot.getOrientation());
    }
}
