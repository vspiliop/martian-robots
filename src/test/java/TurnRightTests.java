import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnRightTests {

    private final TurnRightInstruction turnRightInstruction = new TurnRightInstruction();

    private final CartesianCoordinates coordinates = new CartesianCoordinates(50, 50);

    private MarsSurface surface;

    @Before
    public void setup() {
        surface = new MarsSurface(coordinates);
    }

    @Test
    public void robotTurnsRightWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacing() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new EastOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new SouthOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRightWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new WestOrientation());
        robot.execute(turnRightInstruction);
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }

    @Test
    public void robotTurnsRight360Degrees() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, new NorthOrientation());
        robot.execute(turnRightInstruction.andThen(turnRightInstruction).andThen(turnRightInstruction).andThen(turnRightInstruction));
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
    }
}
