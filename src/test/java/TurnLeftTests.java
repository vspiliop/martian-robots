import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;
import static robot.actions.turning.TurnLeftInstruction.leftInstruction;

public class TurnLeftTests extends TestsCommonSetupOperations {

    @Test
    public void robotTurnsLeftWhileFacingNorth() {
        Robot robot = new Robot(coordinate11, surface, northOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(westOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsLeftWhileFacingWest() {
        Robot robot = new Robot(coordinate11, surface, westOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(southOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsLeftWhileFacingSouth() {
        Robot robot = new Robot(coordinate11, surface, southOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(eastOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsLeftWhileFacingEast() {
        Robot robot = new Robot(coordinate11, surface, eastOrientation());
        robot.execute(leftInstruction());
        Assert.assertEquals(northOrientation(), robot.getOrientation());
    }

    @Test
    public void robotTurnsLeft360Degrees() {
        Robot robot = new Robot(coordinate11, surface, northOrientation());
        robot.execute(instructionChain("LLLL").getOrElseThrow(t -> t));
        Assert.assertEquals(northOrientation(), robot.getOrientation());
    }
}
