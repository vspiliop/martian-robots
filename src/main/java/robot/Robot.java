package robot;

import io.vavr.control.Either;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mars.CartesianCoordinates;
import mars.MarsSurface;
import robot.actions.Orientation;

import java.util.function.Function;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Left;
import static io.vavr.Patterns.$Right;

/**
 * An immutable implementation of Robot.
 */
@RequiredArgsConstructor
final public class Robot {

    public enum Status {
        LOST, ALIVE
    }

    @Getter
    private final Status status;

    @Getter
    private final CartesianCoordinates coordinates;

    @Getter
    private final MarsSurface surface;

    @Getter
    private final Orientation orientation;

    public Either<IllegalArgumentException, Robot> execute(
            Function<Either<IllegalArgumentException, Robot>, Either<IllegalArgumentException, Robot>> instructions) {
        return instructions.apply(Either.right(this));
    }

    public Either<IllegalArgumentException, Robot> turnLeft() {
        return Either.right(new Robot(status, coordinates, surface, getOrientation().left()));
    }

    public Either<IllegalArgumentException, Robot> turnRight() {
        return Either.right(new Robot(status, coordinates, surface, getOrientation().right()));
    }

    public Either<IllegalArgumentException, Robot> forward() {

        if (status == Status.LOST)
            return Either.right(this);

        final var newCoordinates = getOrientation().forward(this);

        return Match(newCoordinates).of(
                Case($Left($()), e -> Either.left(e)),
                Case($Right($(c -> !isValidCoordinate(c) && isScentOnTheSurface())), () -> Either.right(this)),
                Case($Right($(c -> !isValidCoordinate(c))),  () -> Either.right(new Robot(Status.LOST, coordinates, leaveScentOnSurface(), getOrientation()))),
                Case($Right($()), nc -> Either.right(new Robot(Status.ALIVE, nc, surface, getOrientation())))
        );
    }

    private MarsSurface leaveScentOnSurface() {
        return surface.leaveScent(getCoordinates());
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
}
