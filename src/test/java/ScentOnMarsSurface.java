import org.junit.Assert;
import org.junit.Test;

public class ScentOnMarsSurface extends TestsCommonSetupOperations{

    @Test
    public void shouldHaveScent() {
        surface.leaveScent(coordinates33);
        Assert.assertTrue("should have scent", surface.hasScent(coordinates33));
    }

    @Test
    public void shouldNotHaveScent() {
        surface.leaveScent(coordinates33.decrementAxisX());
        Assert.assertFalse("should not have scent", surface.hasScent(coordinates33));
    }
}
