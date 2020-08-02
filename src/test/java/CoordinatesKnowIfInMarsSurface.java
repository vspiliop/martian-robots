import mars.CartesianCoordinates;
import mars.MarsSurface;
import org.junit.Assert;
import org.junit.Test;

public class CoordinatesKnowIfInMarsSurface {

    @Test
    public void inside() {
        Assert.assertTrue(new CartesianCoordinates(40,40)
                .isOnMarsSurface(new MarsSurface(new CartesianCoordinates(41, 41))));
    }

    @Test
    public void insideExactMatch() {
        Assert.assertTrue(new CartesianCoordinates(41,41)
                .isOnMarsSurface(new MarsSurface(new CartesianCoordinates(41, 41))));
    }

    @Test
    public void outsideBothXandY() {
        Assert.assertFalse(new CartesianCoordinates(42,42)
                .isOnMarsSurface(new MarsSurface(new CartesianCoordinates(41, 41))));
    }

    @Test
    public void outsideOnlyX() {
        Assert.assertFalse(new CartesianCoordinates(42,41)
                .isOnMarsSurface(new MarsSurface(new CartesianCoordinates(41, 41))));
    }

    @Test
    public void outsideOnlyY() {
        Assert.assertFalse(new CartesianCoordinates(41,42)
                .isOnMarsSurface(new MarsSurface(new CartesianCoordinates(41, 41))));
    }
}
