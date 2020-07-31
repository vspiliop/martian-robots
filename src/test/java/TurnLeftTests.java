import org.junit.Assert;
import org.junit.Test;

public class TurnLeftTests {

    @Test
    public void roverTurnsLeftWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new NorthOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsLeftWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new WestOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsLeftWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new SouthOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsLeftWhileFacingEast() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new EastOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void roverTurnsLeft360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), new MarsSurface(), new NorthOrientation());
        robot.execute(new TurnLeftInstruction().andThen(new TurnLeftInstruction()).andThen(new TurnLeftInstruction()).andThen(new TurnLeftInstruction()));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }
}
