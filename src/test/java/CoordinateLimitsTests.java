import org.junit.Test;

public class CoordinateLimitsTests {

    @Test(expected = IllegalArgumentException.class)
    public void maxAxisYExceeded() {
        new CartesianCoordinates(50,51);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxAxisXExceeded() {
        new CartesianCoordinates(51,50);
    }

    @Test
    public void happyPath() {
        new CartesianCoordinates(50,50);
    }

}
