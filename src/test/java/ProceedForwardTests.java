import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;
import static robot.actions.moving.ProceedForwardInstruction.forwardInstruction;

public class ProceedForwardTests extends TestsCommonSetupOperations {

    @Test
    public void robotProceedForwardWhileFacingNorth() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, northOrientation());
        // when
        final var result = robot.execute(forwardInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(northOrientation(), result.get().getOrientation());
        Assert.assertEquals(coordinates12, result.get().getCoordinates());
    }

    @Test
    public void robotProceedForwardWhileFacingEast() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, eastOrientation());
        // when
        final var result = robot.execute(forwardInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(eastOrientation(), result.get().getOrientation());
        Assert.assertEquals(coordinates21, result.get().getCoordinates());
    }

    @Test
    public void robotProceedForwardWhileFacingSouth() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, southOrientation());
        // when
        final var result = robot.execute(forwardInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(southOrientation(), result.get().getOrientation());
        Assert.assertEquals(coordinates10, result.get().getCoordinates());
    }

    @Test
    public void robotProceedForwardWhileFacingWest() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, westOrientation());
        // when
        final var result = robot.execute(forwardInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(westOrientation(), result.get().getOrientation());
        Assert.assertEquals(coordinates01, result.get().getCoordinates());
    }
}
