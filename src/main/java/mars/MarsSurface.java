package mars;

import io.vavr.collection.HashSet;
import lombok.Getter;

import java.util.Optional;

/**
 * An immutable implementation of the mars surface.
 */
final public class MarsSurface {

    private HashSet scents = HashSet.empty();

    /**
     * We are leaking this reference but it is final and the CartesianCoordinates obj is immutable.
     */
    @Getter
    private final CartesianCoordinates lowerBound = CartesianCoordinates.from(0, 0).getOrElseThrow(t -> t);

    /**
     * We are leaking this reference but it is final and the CartesianCoordinates obj is immutable.
     */
    @Getter
    private final CartesianCoordinates upperBound;

    public MarsSurface(CartesianCoordinates upperBound, HashSet scents) {
        this.upperBound = Optional.ofNullable(upperBound).orElseThrow(() -> new IllegalArgumentException("Mars Surface must have an upper bound"));
        this.scents = Optional.ofNullable(scents).orElseThrow(() -> new IllegalArgumentException("Mars Surface must has scents"));
    }

    public MarsSurface(CartesianCoordinates upperBound) {
        this.upperBound = Optional.ofNullable(upperBound).orElseThrow(() -> new IllegalArgumentException("Mars Surface must have an upper bound"));
    }

    public boolean hasScent(CartesianCoordinates coordinates) {
        return scents.contains(coordinates);
    }

    /**
     * Whenever a MarsSurface is mutated via calling leaveScent(), a new instance is created.
     * leaveScent() is the only way MarsSurface can be mutated.
     * As a result MarsSurface is immutable.
     */
    public MarsSurface leaveScent(CartesianCoordinates coordinates) {
        return new MarsSurface(upperBound, scents.add(coordinates));
    }
}
