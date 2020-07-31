import lombok.Getter;

import java.util.Optional;

/**
 * Represents the surface of Mars as a rectangular.
 */
public class MarsSurface {

    @Getter
    private final CartesianCoordinates lowerBound = new CartesianCoordinates(0, 0);

    @Getter
    private CartesianCoordinates upperBound;

    public MarsSurface(CartesianCoordinates upperBound) {
        this.upperBound = Optional.ofNullable(upperBound).orElseThrow(() -> new IllegalArgumentException("Mars Surface must have an upper bound"));
    }
}
