import mars.CartesianCoordinates;
import mars.MarsSurface;
import org.junit.Before;

public class TestsCommonSetupOperations {

    protected final CartesianCoordinates coordinates12 = CartesianCoordinates.from(1, 2).getOrElseThrow(t -> t);

    protected final CartesianCoordinates coordinates23 = CartesianCoordinates.from(2, 3).getOrElseThrow(t -> t);

    protected final CartesianCoordinates coordinates21 = CartesianCoordinates.from(2, 1).getOrElseThrow(t -> t);

    protected final CartesianCoordinates coordinates33 = CartesianCoordinates.from(3, 3).getOrElseThrow(t -> t);

    protected final CartesianCoordinates coordinate11 = CartesianCoordinates.from(1, 1).getOrElseThrow(t -> t);

    protected final CartesianCoordinates coordinate13 = CartesianCoordinates.from(1, 3).getOrElseThrow(t -> t);

    protected final CartesianCoordinates coordinates01 = CartesianCoordinates.from(0, 1).getOrElseThrow(t -> t);

    protected final CartesianCoordinates coordinates10 = CartesianCoordinates.from(1, 0).getOrElseThrow(t -> t);

    MarsSurface surface;

    @Before
    public void setup() {
        surface = new MarsSurface(coordinates33);
    }
    
}
