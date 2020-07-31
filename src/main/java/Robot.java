import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Robot implements ExecutesInstructions {

    @NonNull
    private CartesianCoordinates coordinates;

    private final MarsSurface surface;

    @NonNull
    private Orientation orientation;

    @Override
    public void execute(InstructionChain instructions) {
        instructions.accept(this);
    }
}
