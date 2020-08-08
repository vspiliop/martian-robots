import mars.CartesianCoordinates;
import org.junit.Assert;
import org.junit.Test;
import robot.Robot;
import robot.actions.NorthOrientation;

import java.util.function.Consumer;

import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.NorthOrientation.northOrientation;

public class RobotsCanFallOfMarsSurface extends TestsCommonSetupOperations {

    private final Consumer<Robot> instructionChainFff = instructionChain("FFF");

    @Test
    public void robotFell() {
        Robot robot = new Robot(new CartesianCoordinates(2,1), surface, northOrientation());
        robot.execute(instructionChainFff);
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(2,3));
        Assert.assertEquals(Robot.Status.LOST, robot.getStatus());
    }

    @Test()
    public void robotStillInMars() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(instructionChain("FF"));
        Assert.assertEquals(Robot.Status.ALIVE, robot.getStatus());
    }

    @Test()
    public void robotDoesNotFallBecauseOfScent() {
        Robot bob = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        Robot doug = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());

        bob.execute(instructionChainFff);
        // the coordinates will be the last valid ones just before it fell
        Assert.assertEquals(NorthOrientation.class, bob.getOrientation().getClass());
        Assert.assertEquals(bob.getCoordinates(), new CartesianCoordinates(1,3));
        Assert.assertEquals(Robot.Status.LOST, bob.getStatus());

        // Bob fell, but Doug should not
        doug.execute(instructionChainFff);
        // Doug should remain at the last valid instruction
        Assert.assertEquals(NorthOrientation.class, doug.getOrientation().getClass());
        Assert.assertEquals(doug.getCoordinates(), new CartesianCoordinates(1,3));
        Assert.assertEquals(Robot.Status.ALIVE, doug.getStatus());
    }

}
