import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class Robot implements ExecutesInstructions {

    @NonNull
    private CartesianCoordinates coordinates;

    private final MarsSurface surface;

    @NonNull
    @Getter
    private Orientation orientation;

    @Override
    public void execute(Consumer<Robot> instructions) {
        instructions.accept(this);
    }

    public void turnLeft() {
        orientation = getOrientation().left();
    }
}
