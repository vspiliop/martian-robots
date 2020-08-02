import org.junit.Assert;
import org.junit.Test;

public class RobotsCanFallOfMarsSurface extends TestsCommonSetupOperations {

    @Test
    public void robotFell() {
        Robot robot = new Robot(new CartesianCoordinates(2,1), surface, new NorthOrientation());
        robot.execute(proceedForwardInstruction.andThen(proceedForwardInstruction).andThen(proceedForwardInstruction));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(2,3));
        Assert.assertEquals(Robot.Status.LOST, robot.getStatus());
    }

    @Test()
    public void robotStillInMars() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(proceedForwardInstruction.andThen(proceedForwardInstruction));
        Assert.assertEquals(Robot.Status.ALIVE, robot.getStatus());
    }

    @Test()
    public void robotDoesNotFallBecauseOfScent() {
        Robot bob = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        Robot doug = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());

        bob.execute(proceedForwardInstruction.andThen(proceedForwardInstruction).andThen(proceedForwardInstruction));
        // the coordinates will be the last valid ones just before it fell
        Assert.assertEquals(NorthOrientation.class, bob.getOrientation().getClass());
        Assert.assertEquals(bob.getCoordinates(), new CartesianCoordinates(1,3));
        Assert.assertEquals(Robot.Status.LOST, bob.getStatus());

        // Bob fell, but Doug should not
        doug.execute(proceedForwardInstruction.andThen(proceedForwardInstruction).andThen(proceedForwardInstruction));
        // Doug should remain at the last valid instruction
        Assert.assertEquals(NorthOrientation.class, doug.getOrientation().getClass());
        Assert.assertEquals(doug.getCoordinates(), new CartesianCoordinates(1,3));
        Assert.assertEquals(Robot.Status.ALIVE, doug.getStatus());
    }

}
