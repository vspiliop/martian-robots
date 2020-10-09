import org.junit.Assert;
import org.junit.Test;
import robot.Robot;

import java.util.stream.IntStream;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static robot.actions.InstructionsChainFactory.instructionChain;

public class FactoryCanCreateInstructionChains extends TestsCommonSetupOperations {

    @Test()
    public void maxInstructionNullChain() {
        final var underTest = instructionChain(null);
        final var result = underTest.apply(init);
        assertThat(result).isLeft();
        assertThat(result).containsLeftInstanceOf(IllegalArgumentException.class);
        Assert.assertTrue(result.getLeft().getMessage().contains("instructions line required"));
    }

    @Test()
    public void unknownCommandInChain() {
        final var underTest = instructionChain("FFLY");
        final var result = underTest.apply(init);
        assertThat(result).isLeft();
        assertThat(result).containsLeftInstanceOf(IllegalArgumentException.class);
        Assert.assertTrue(result.getLeft().getMessage().contains("Unknown command"));
    }

    @Test()
    public void maxInstructionChainLimitReached() {
        final var underTest = instructionChain(createInstructionsStringOfLength(101));
        final var result = underTest.apply(init);
        assertThat(result).isLeft();
        assertThat(result).containsLeftInstanceOf(IllegalArgumentException.class);
        Assert.assertTrue(result.getLeft().getMessage().contains("Instruction chain cannot be longer than 100"));
    }

    @Test
    public void maxInstructionChainLimitNotReached() {
        final var underTest = instructionChain(createInstructionsStringOfLength(100));
        final var result = underTest.apply(init);
        assertThat(result).isRight();
        assertThat(result).containsRightInstanceOf(Robot.class);
    }

    private String createInstructionsStringOfLength(int length) {
        return IntStream.rangeClosed(1, length).mapToObj(i -> "F").reduce(String::concat).get();
    }

}
