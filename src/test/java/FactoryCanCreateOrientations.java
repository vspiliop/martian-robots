import org.junit.Test;

import static org.assertj.vavr.api.VavrAssertions.assertThat;
import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.OrientationFactory.orientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class FactoryCanCreateOrientations {

    @Test
    public void createSouthOrientation() {
        assertThat(orientation("S")).isRight();
        assertThat(orientation("S")).containsOnRight(southOrientation());
    }

    @Test
    public void createNorthOrientation() {
        assertThat(orientation("N")).isRight();
        assertThat(orientation("N")).containsOnRight(northOrientation());
    }

    @Test
    public void createEastOrientation() {
        assertThat(orientation("E")).isRight();
        assertThat(orientation("E")).containsOnRight(eastOrientation());
    }

    @Test
    public void createWestOrientation() {
        assertThat(orientation("W")).isRight();
        assertThat(orientation("W")).containsOnRight(westOrientation());
    }

    @Test()
    public void createNullOrientation() {
        assertThat(orientation(null)).isLeft();
        assertThat(orientation(null)).containsLeftInstanceOf(IllegalArgumentException.class);
    }

    @Test()
    public void createUnknownOrientation() {
        assertThat(orientation("bla")).isLeft();
        assertThat(orientation("bla")).containsLeftInstanceOf(IllegalArgumentException.class);
    }

}
