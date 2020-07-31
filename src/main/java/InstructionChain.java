import java.util.function.Consumer;

/**
 * Represents an ordered chain of Instructions.
 */
public interface InstructionChain extends Consumer<Robot> {
    default void chainNextInstruction(InstructionChain instruction) {
        andThen(instruction);
    }
}
