import org.junit.Assert;
import org.junit.Test;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.OrientationFactory.orientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class FactoryCanCreateOrientations {

    @Test
    public void createSouthOrientatation() {
        Assert.assertEquals(southOrientation().getClass(), orientation("S").getClass());
    }

    @Test
    public void createNorthOrientatation() {
        Assert.assertEquals(northOrientation().getClass(), orientation("N").getClass());
    }

    @Test
    public void createEastOrientatation() {
        Assert.assertEquals(eastOrientation().getClass(), orientation("E").getClass());
    }

    @Test
    public void createWestOrientatation() {
        Assert.assertEquals(westOrientation().getClass(), orientation("W").getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNullOrientatation() {
        orientation(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createUnknownOrientatation() {
        orientation("bla");
    }

}
