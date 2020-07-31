import java.util.function.Consumer;

public interface ExecutesInstructions {
    void execute(Consumer<Robot> instructions);
}
