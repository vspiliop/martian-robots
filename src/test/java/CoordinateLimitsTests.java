import mars.CartesianCoordinates;
import org.junit.Test;

import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class CoordinateLimitsTests {

    @Test()
    public void maxAxisYExceeded() {
        assertThat(CartesianCoordinates.from(50,51)).isLeft();
        assertThat(CartesianCoordinates.from(50,51)).containsLeftInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    public void maxAxisXExceeded() {
        assertThat(CartesianCoordinates.from(51,50)).isLeft();
        assertThat(CartesianCoordinates.from(51,50)).containsLeftInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void happyPath() {
        assertThat(CartesianCoordinates.from(50,50)).isRight();
        assertThat(CartesianCoordinates.from(50,50)).containsRightInstanceOf(CartesianCoordinates.class);
    }

}
