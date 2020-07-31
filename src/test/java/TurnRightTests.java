import org.junit.Assert;
import org.junit.Test;

public class TurnRightTests {

    private final TurnRightInstruction turnRightInstruction = new TurnRightInstruction();

    @Test
    public void roverTurnsRightWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new NorthOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsRightWhileFacing() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new EastOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsRightWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new SouthOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsRightWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new WestOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsRight360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new NorthOrientation());
        robot.execute(turnRightInstruction.andThen(turnRightInstruction).andThen(turnRightInstruction).andThen(turnRightInstruction));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }
}
