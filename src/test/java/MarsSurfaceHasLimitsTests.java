import org.junit.Test;

public class MarsSurfaceHasLimitsTests {

    @Test(expected = IllegalArgumentException.class)
    public void marSurfaceMaxUpperBoundAxisYExceeded() {
        new MarsSurface(new CartesianCoordinates(50,51));
    }

    @Test(expected = IllegalArgumentException.class)
    public void marSurfaceMaxUpperBoundAxisXExceeded() {
        new MarsSurface(new CartesianCoordinates(51,50));
    }

    @Test
    public void marSurfaceMaxUpperBoundAxisX() {
        new MarsSurface(new CartesianCoordinates(50,50));
    }

}
