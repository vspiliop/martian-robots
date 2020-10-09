import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;
import static robot.actions.turning.TurnLeftInstruction.leftInstruction;

public class TurnLeftTests extends TestsCommonSetupOperations {

    @Test
    public void robotTurnsLeftWhileFacingNorth() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, northOrientation());
        // when
        final var result = robot.execute(leftInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(westOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsLeftWhileFacingWest() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, westOrientation());
        // when
        final var result = robot.execute(leftInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(southOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsLeftWhileFacingSouth() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, southOrientation());
        // when
        final var result = robot.execute(leftInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(eastOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsLeftWhileFacingEast() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, eastOrientation());
        // when
        final var result = robot.execute(leftInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(northOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsLeft360Degrees() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, northOrientation());
        // when
        final var result = robot.execute(instructionChain("LLLL"));
        // then
        assertThat(result).isRight();
        Assert.assertEquals(northOrientation(), result.get().getOrientation());
    }
}
