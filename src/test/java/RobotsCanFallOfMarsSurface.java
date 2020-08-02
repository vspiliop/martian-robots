import org.junit.Assert;
import org.junit.Test;

public class RobotsCanFallOfMarsSurface extends TestsCommonSetupOperations {

    @Test(expected = IllegalStateException.class)
    public void robotFell() {
        Robot robot = new Robot(new CartesianCoordinates(2,1), surface, new NorthOrientation());
        robot.execute(proceedForwardInstruction.andThen(proceedForwardInstruction).andThen(proceedForwardInstruction));
    }

    @Test()
    public void robotStillInMars() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(proceedForwardInstruction.andThen(proceedForwardInstruction));
    }

    @Test()
    public void robotDoesNotFallBecauseOfScent() {
        Robot bob = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        Robot doug = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());

        try {
            bob.execute(proceedForwardInstruction.andThen(proceedForwardInstruction).andThen(proceedForwardInstruction));
        } catch (IllegalStateException ex) {
            // the coordinates will be the last valid ones just before it fell
            Assert.assertEquals(NorthOrientation.class, bob.getOrientation().getClass());
            Assert.assertEquals(bob.getCoordinates(), new CartesianCoordinates(1,3));
        }
        // Bob fell, but Doug should not
        doug.execute(proceedForwardInstruction.andThen(proceedForwardInstruction).andThen(proceedForwardInstruction));
        System.out.println("Doug didn't..");
        // Doug should remain at the last valid instruction
        Assert.assertEquals(NorthOrientation.class, doug.getOrientation().getClass());
        Assert.assertEquals(doug.getCoordinates(), new CartesianCoordinates(1,3));
    }

}
