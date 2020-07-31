import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Robot implements ExecutesInstructions {

    /**
     * This represents the internal comms between robots, when they are constructed.
     */
    static final private HashMap<CartesianCoordinates, Object> scent = new HashMap<>();

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
        CartesianCoordinates newCoordinates = getOrientation().forward(this);

        boolean isNextCoordinateValid = isValidCoordinate(newCoordinates);

        // if next coord is not valid and a robot has fell from the same current coord, skip the current instruction
        if(!isNextCoordinateValid && scent.containsKey(getCoordinates())) {
            return;
        }

        if(!isNextCoordinateValid && !scent.containsKey(getCoordinates())) {
            scent.put(getCoordinates(), null);
            // stop the processing of the current robot if it falls
            throw new IllegalStateException("Robot fell of the Mars surface!");
        }

        coordinates = newCoordinates;
    }

    private boolean isValidCoordinate(CartesianCoordinates coordinates) {
        return coordinates.isInMarsSurface(this.surface);
    }

    @Override
    public String toString() {
        return String.format("Robot is at (%s, %s), heading %s", coordinates.getX(), coordinates.getY(), orientation.getClass().getSimpleName().charAt(0));
    }

}
