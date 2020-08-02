import org.junit.Assert;
import org.junit.Test;

public class RobotsLeaveScentOnMarsSurface extends TestsCommonSetupOperations{

    @Test
    public void shouldHaveScent() {
        surface.leaveScent(coordinates);
        Assert.assertTrue("should have scent", surface.hasScent(coordinates));
    }

    @Test
    public void shouldNotHaveScent() {
        surface.leaveScent(coordinates.decrementAxisX());
        Assert.assertFalse("should not have scent", surface.hasScent(coordinates));
    }
}
