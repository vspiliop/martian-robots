import mars.CartesianCoordinates;
import mars.MarsSurface;
import org.junit.Before;

public class TestsCommonSetupOperations {

    final CartesianCoordinates coordinates = new CartesianCoordinates(3, 3);

    MarsSurface surface;

    @Before
    public void setup() {
        surface = new MarsSurface(coordinates);
    }
    
}
