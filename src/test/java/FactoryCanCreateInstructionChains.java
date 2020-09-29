import org.junit.Test;

import java.util.function.Consumer;
import java.util.stream.IntStream;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static robot.actions.InstructionsChainFactory.instructionChain;

public class FactoryCanCreateInstructionChains {

    @Test()
    public void maxInstructionNullChain() {
        final var underTest = instructionChain(null);
        assertThat(underTest).isLeft();
        assertThat(underTest).containsLeftInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    public void unknownCommandInChain() {
        final var underTest = instructionChain("FFLY");
        assertThat(underTest).isLeft();
        assertThat(underTest).containsLeftInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    public void maxInstructionChainLimitReached() {
        final var underTest = instructionChain(createInstructionsStringOfLength(101));
        assertThat(underTest).isLeft();
        assertThat(underTest).containsLeftInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void maxInstructionChainLimitNotReached() {
        final var underTest = instructionChain(createInstructionsStringOfLength(100));
        assertThat(underTest).isRight();
        assertThat(underTest).containsRightInstanceOf(Consumer.class);
    }

    private String createInstructionsStringOfLength(int length) {
        return IntStream.rangeClosed(1, length).mapToObj(i -> "F").reduce(String::concat).get();
    }

}
