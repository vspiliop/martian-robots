import mars.CartesianCoordinates;
import org.junit.Assert;
import org.junit.Test;
import robot.*;
import robot.actions.EastOrientation;
import robot.actions.NorthOrientation;
import robot.actions.SouthOrientation;
import robot.actions.WestOrientation;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;
import static robot.actions.moving.ProceedForwardInstruction.forwardInstruction;

public class ProceedForwardTests extends TestsCommonSetupOperations {

    @Test
    public void robotProceedForwardWhileFacingNorth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, northOrientation());
        robot.execute(forwardInstruction());
        Assert.assertEquals(NorthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(1,2));
    }

    @Test
    public void robotProceedForwardWhileFacingEast() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, eastOrientation());
        robot.execute(forwardInstruction());
        Assert.assertEquals(EastOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(2,1));
    }

    @Test
    public void robotProceedForwardWhileFacingSouth() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, southOrientation());
        robot.execute(forwardInstruction());
        Assert.assertEquals(SouthOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(1,0));
    }

    @Test
    public void robotProceedForwardWhileFacingWest() {
        Robot robot = new Robot(new CartesianCoordinates(1,1), surface, westOrientation());
        robot.execute(forwardInstruction());
        Assert.assertEquals(WestOrientation.class, robot.getOrientation().getClass());
        Assert.assertEquals(robot.getCoordinates(), new CartesianCoordinates(0,1));
    }
}
