import org.junit.Test;

import java.util.stream.IntStream;

import static robot.actions.InstructionsChainFactory.instructionChain;

public class FactoryCanCreateInstructionChains {

    @Test(expected = IllegalArgumentException.class)
    public void maxInstructionNullChain() {
        instructionChain(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxInstructionChainLimitReached() {
        instructionChain(createInstructionsStringOfLength(101));
    }

    @Test
    public void maxInstructionChainLimitNitReached() {
        instructionChain(createInstructionsStringOfLength(100));
    }

    private String createInstructionsStringOfLength(int length) {
        return IntStream.rangeClosed(1, length).mapToObj(i -> "F").reduce(String::concat).get();
    }

}
