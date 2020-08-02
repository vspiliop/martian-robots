import mars.CartesianCoordinates;
import mars.MarsSurface;
import robot.actions.moving.ProceedForwardInstruction;
import org.junit.Before;

public class TestsCommonSetupOperations {

    public static final ProceedForwardInstruction proceedForwardInstruction = new ProceedForwardInstruction();

    public static final CartesianCoordinates coordinates = new CartesianCoordinates(3, 3);

    MarsSurface surface;

    @Before
    public void setup() {
        surface = new MarsSurface(coordinates);
    }
    
}
