import lombok.Getter;

import java.util.Optional;

/**
 * Represents the surface of Mars as a rectangular.
 */
public class MarsSurface {

    public static final int MAX_COORDINATE_VALUE = 50;

    @Getter
    private final CartesianCoordinates lowerBound = new CartesianCoordinates(0, 0);

    @Getter
    private CartesianCoordinates upperBound;

    public MarsSurface(CartesianCoordinates upperBound) {
        this.upperBound = Optional.ofNullable(upperBound).orElseThrow(() -> new IllegalArgumentException("Mars Surface must have an upper bound"));

        if(this.upperBound.getX() > MAX_COORDINATE_VALUE || this.upperBound.getY() > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("No coordinate can be more than 50");
        }
    }
}
