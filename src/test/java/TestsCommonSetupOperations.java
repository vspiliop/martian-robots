import mars.CartesianCoordinates;
import mars.MarsSurface;
import robot.actions.moving.ProceedForwardInstruction;
import org.junit.Before;
import robot.actions.turning.TurnRightInstruction;

public class TestsCommonSetupOperations {

    final ProceedForwardInstruction proceedForwardInstruction = new ProceedForwardInstruction();

    final TurnRightInstruction turnRightInstruction = new TurnRightInstruction();

    final CartesianCoordinates coordinates = new CartesianCoordinates(3, 3);

    MarsSurface surface;

    @Before
    public void setup() {
        surface = new MarsSurface(coordinates);
    }
    
}
