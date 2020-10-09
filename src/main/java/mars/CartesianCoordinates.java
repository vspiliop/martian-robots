package mars;

import io.vavr.control.Either;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * An immutable CartesianCoordinates implementation.
 */
@EqualsAndHashCode
final public class CartesianCoordinates {

    public static final int MAX_COORDINATE_VALUE = 50;

    @Getter
    private final int x;

    @Getter
    private final int y;

    private CartesianCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Either<IllegalArgumentException, CartesianCoordinates> from(int x, int y) {
        if(x > MAX_COORDINATE_VALUE || y > MAX_COORDINATE_VALUE) {
            return Either.left(new IllegalArgumentException("No coordinate can be more than 50"));
        }
        return Either.right(new CartesianCoordinates(x, y));
    }

    public Either<IllegalArgumentException, CartesianCoordinates> incrementAxisX() {
        return CartesianCoordinates.from(x + 1, y);
    }

    public Either<IllegalArgumentException, CartesianCoordinates> incrementAxisY() {
        return CartesianCoordinates.from(x, y + 1);
    }

    public Either<IllegalArgumentException, CartesianCoordinates> decrementAxisX() {
        return CartesianCoordinates.from(x - 1, y);
    }

    public Either<IllegalArgumentException, CartesianCoordinates> decrementAxisY() {
        return CartesianCoordinates.from(x, y - 1);
    }

    public boolean isOnMarsSurface(MarsSurface surface) {
        if (x < surface.getLowerBound().getX() || x > surface.getUpperBound().getX()
                || y < surface.getLowerBound().getY() || y > surface.getUpperBound().getY()) {
            return false;
        }

        return true;
    }
}