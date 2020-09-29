import mars.CartesianCoordinates;
import mars.MarsSurface;
import org.junit.Assert;
import org.junit.Test;

public class CoordinatesKnowIfInMarsSurface {

    public static final MarsSurface MARS_SURFACE = new MarsSurface(CartesianCoordinates.from(41, 41).get());
    public static final CartesianCoordinates coordinates4040 = CartesianCoordinates.from(40, 40).get();
    public static final CartesianCoordinates coordinates4241 = CartesianCoordinates.from(42, 41).get();
    public static final CartesianCoordinates coordinates4142 = CartesianCoordinates.from(41, 42).get();
    public static final CartesianCoordinates coordinates4141 = CartesianCoordinates.from(41, 41).get();
    public static final CartesianCoordinates coordinates4242 = CartesianCoordinates.from(42, 42).get();

    @Test
    public void inside() {
        Assert.assertTrue(coordinates4040.isOnMarsSurface(MARS_SURFACE));
    }

    @Test
    public void insideExactMatch() {
        Assert.assertTrue(coordinates4141.isOnMarsSurface(MARS_SURFACE));
    }

    @Test
    public void outsideBothXandY() {
        Assert.assertFalse(coordinates4242.isOnMarsSurface(MARS_SURFACE));
    }

    @Test
    public void outsideOnlyX() {
        Assert.assertFalse(coordinates4241.isOnMarsSurface(MARS_SURFACE));
    }

    @Test
    public void outsideOnlyY() {
        Assert.assertFalse(coordinates4142.isOnMarsSurface(MARS_SURFACE));
    }
}
