import mars.MarsSurface;
import org.junit.Assert;
import org.junit.Test;

public class ScentOnMarsSurface extends TestsCommonSetupOperations{

    @Test
    public void shouldHaveScent() {
        final var result = surface.leaveScent(coordinates33);
        Assert.assertTrue("should have scent", result.hasScent(coordinates33));
    }

    @Test
    public void shouldNotHaveScent() {
        final var result = surface.leaveScent(coordinates33.decrementAxisX().get());
        Assert.assertFalse("should not have scent", result.hasScent(coordinates33));
    }
}
