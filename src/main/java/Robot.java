import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class Robot implements ExecutesInstructions {

    @NonNull
    @Getter
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

    public void turnRight() {
        orientation = getOrientation().right();
    }

    public void forward() {
        orientation = getOrientation().forward(this);
        // stop the processing of the current robot if it fells
        if(!isValidCoordinate(getCoordinates())) {
            throw new IllegalStateException("Robot fell of the Mars surface!");
        }
    }

    private boolean isValidCoordinate(CartesianCoordinates coordinates) {
        return coordinates.isInMarsSurface(this.surface);
    }

    @Override
    public String toString() {
        return String.format("Robot is at (%s, %s), heading %s", coordinates.getX(), coordinates.getY(), orientation.getClass().getSimpleName().charAt(0));
    }

}
