package mars;

import lombok.Getter;

import java.util.HashMap;
import java.util.Optional;

/**
 * Represents the surface of Mars as a rectangular and is shared by all Robots.
 *
 * All robot commands are executed in sequence and there is no concurrency based on the problem definition,
 * and as a result there are no race conditions to guard against.
 */
public class MarsSurface {

    final private HashMap<CartesianCoordinates, Object> scent = new HashMap<>();

    @Getter
    private final CartesianCoordinates lowerBound = CartesianCoordinates.from(0, 0).getOrElseThrow(t -> t);

    @Getter
    private CartesianCoordinates upperBound;

    public MarsSurface(CartesianCoordinates upperBound) {
        this.upperBound = Optional.ofNullable(upperBound).orElseThrow(() -> new IllegalArgumentException("Mars Surface must have an upper bound"));
    }

    public boolean hasScent(CartesianCoordinates coordinates) {
        return scent.containsKey(coordinates);
    }

    public void leaveScent(CartesianCoordinates coordinates) {
        scent.put(coordinates, null);
    }
}
