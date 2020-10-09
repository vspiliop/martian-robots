import io.vavr.control.Either;
import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import java.util.function.Function;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.NorthOrientation.northOrientation;

public class RobotsCanFallOfMarsSurface extends TestsCommonSetupOperations {

    private final Function<Either<IllegalArgumentException, Robot>,
            Either<IllegalArgumentException, Robot>> instructionChainFff = instructionChain("FFF");

    @Test
    public void robotFell() {
        // given
        Robot robot = new Robot(Robot.Status.ALIVE, coordinates21, surface, northOrientation());
        // when
        final var result = robot.execute(instructionChainFff);
        // then
        assertThat(result).isRight();
        Assert.assertEquals(northOrientation(), result.get().getOrientation());
        Assert.assertEquals(coordinates23, result.get().getCoordinates());
        Assert.assertEquals(Robot.Status.LOST, result.get().getStatus());
    }

    @Test()
    public void robotStillInMars() {
        Robot robot = new Robot(Robot.Status.ALIVE, coordinate11, surface, northOrientation());
        final var result = robot.execute(instructionChain("FF"));
        assertThat(result).isRight();
        Assert.assertEquals(Robot.Status.ALIVE, result.get().getStatus());
    }

    @Test()
    public void robotDoesNotFallBecauseOfScent() {
        Robot bob = new Robot(Robot.Status.ALIVE, coordinate11, surface, northOrientation());

        final var resultBob = bob.execute(instructionChainFff);
        // the coordinates will be the last valid ones just before it fell
        assertThat(resultBob).isRight();
        Assert.assertEquals(northOrientation(), resultBob.get().getOrientation());
        Assert.assertEquals(coordinate13, resultBob.get().getCoordinates());
        Assert.assertEquals(Robot.Status.LOST, resultBob.get().getStatus());

        // surface is immutable and we should pass the last one to the next robot
        Robot doug = new Robot(Robot.Status.ALIVE, coordinate11, resultBob.get().getSurface(), northOrientation());
        // Bob fell, but Doug should not
        final var resultDoug = doug.execute(instructionChainFff);
        // Doug should remain at the last valid instruction
        assertThat(resultDoug).isRight();
        Assert.assertEquals(northOrientation(), resultDoug.get().getOrientation());
        Assert.assertEquals(coordinate13, resultDoug.get().getCoordinates());
        Assert.assertEquals(Robot.Status.ALIVE, resultDoug.get().getStatus());
    }

}
