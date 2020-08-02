package robot;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mars.CartesianCoordinates;
import mars.MarsSurface;
import robot.actions.Orientation;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class Robot {

    public enum Status {
        LOST, ALIVE
    }

    Status status = Status.ALIVE;

    @NonNull
    @Getter
    private CartesianCoordinates coordinates;

    private final MarsSurface surface;

    @NonNull
    @Getter
    private Orientation orientation;

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
        if (status == Status.LOST)
            return;

        CartesianCoordinates newCoordinates = getOrientation().forward(this);

        boolean isNextCoordinateValid = isValidCoordinate(newCoordinates);
        boolean scentOnTheSurface = isScentOnTheSurface();

        if(!isNextCoordinateValid && scentOnTheSurface) {
            return;
        }

        if(!isNextCoordinateValid) {
            leaveScentOnSurface();
            status = Status.LOST;
            return;
        }

        coordinates = newCoordinates;
    }

    private void leaveScentOnSurface() {
        surface.leaveScent(getCoordinates());
    }

    private boolean isScentOnTheSurface() {
        return surface.hasScent(getCoordinates());
    }

    private boolean isValidCoordinate(CartesianCoordinates coordinates) {
        return coordinates.isOnMarsSurface(this.surface);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s%s", coordinates.getX(), coordinates.getY(),
                orientation.getClass().getSimpleName().charAt(0), status == Status.LOST ? " LOST": "");
    }

    public Status getStatus() {
        return status;
    }

}
