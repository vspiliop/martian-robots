import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import java.util.function.Consumer;

import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.NorthOrientation.northOrientation;

public class RobotsCanFallOfMarsSurface extends TestsCommonSetupOperations {

    private final Consumer<Robot> instructionChainFff = instructionChain("FFF").getOrElseThrow(t -> t);

    @Test
    public void robotFell() {
        Robot robot = new Robot(coordinates21, surface, northOrientation());
        robot.execute(instructionChainFff);
        Assert.assertEquals(northOrientation(), robot.getOrientation());
        Assert.assertEquals(robot.getCoordinates(), coordinates23);
        Assert.assertEquals(Robot.Status.LOST, robot.getStatus());
    }

    @Test()
    public void robotStillInMars() {
        Robot robot = new Robot(coordinate11, surface, northOrientation());
        robot.execute(instructionChain("FF").getOrElseThrow(t -> t));
        Assert.assertEquals(Robot.Status.ALIVE, robot.getStatus());
    }

    @Test()
    public void robotDoesNotFallBecauseOfScent() {
        Robot bob = new Robot(coordinate11, surface, northOrientation());
        Robot doug = new Robot(coordinate11, surface, northOrientation());

        bob.execute(instructionChainFff);
        // the coordinates will be the last valid ones just before it fell
        Assert.assertEquals(northOrientation(), bob.getOrientation());
        Assert.assertEquals(bob.getCoordinates(), coordinate13);
        Assert.assertEquals(Robot.Status.LOST, bob.getStatus());

        // Bob fell, but Doug should not
        doug.execute(instructionChainFff);
        // Doug should remain at the last valid instruction
        Assert.assertEquals(northOrientation(), doug.getOrientation());
        Assert.assertEquals(doug.getCoordinates(), coordinate13);
        Assert.assertEquals(Robot.Status.ALIVE, doug.getStatus());
    }

}
