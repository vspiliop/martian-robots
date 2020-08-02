import mars.CartesianCoordinates;
import mars.MarsSurface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import robot.*;
import robot.actions.EastOrientation;
import robot.actions.NorthOrientation;
import robot.actions.SouthOrientation;
import robot.actions.WestOrientation;
import robot.actions.turning.TurnLeftInstruction;

public class TurnLeftTests {

    private final CartesianCoordinates coordinates = new CartesianCoordinates(50, 50);

    private MarsSurface surface;

    @Before
    public void setup() {
        surface = new MarsSurface(coordinates);
    }

    @Test
    public void robotTurnsLeftWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeftWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new WestOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeftWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new SouthOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeftWhileFacingEast() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new EastOrientation());
        robot.execute(new TurnLeftInstruction());
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsLeft360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(new TurnLeftInstruction().andThen(new TurnLeftInstruction()).andThen(new TurnLeftInstruction()).andThen(new TurnLeftInstruction()));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }
}
