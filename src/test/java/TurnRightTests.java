import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;
import static robot.actions.turning.TurnRightInstruction.rightInstruction;

public class TurnRightTests extends TestsCommonSetupOperations {

    @Test
    public void robotTurnsRightWhileFacingNorth() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, northOrientation());
        // when
        final var result = robot.execute(rightInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(eastOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsRightWhileFacing() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, eastOrientation());
        // when
        final var result = robot.execute(rightInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(southOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsRightWhileFacingSouth() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, southOrientation());
        // when
        final var result = robot.execute(rightInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(westOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsRightWhileFacingWest() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, westOrientation());
        // when
        final var result = robot.execute(rightInstruction());
        // then
        assertThat(result).isRight();
        Assert.assertEquals(northOrientation(), result.get().getOrientation());
    }

    @Test
    public void robotTurnsRight360Degrees() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, northOrientation());
        // when
        final var result = robot.execute(instructionChain("RRRR"));
        // then
        assertThat(result).isRight();
        Assert.assertEquals(northOrientation(), result.get().getOrientation());
    }
}
