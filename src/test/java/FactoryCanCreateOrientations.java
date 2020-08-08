import org.junit.Assert;
import org.junit.Test;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.OrientationFactory.orientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class FactoryCanCreateOrientations {

    @Test
    public void createSouthOrientation() {
        Assert.assertEquals(southOrientation(), orientation("S"));
    }

    @Test
    public void createNorthOrientation() {
        Assert.assertEquals(northOrientation(), orientation("N"));
    }

    @Test
    public void createEastOrientation() {
        Assert.assertEquals(eastOrientation(), orientation("E"));
    }

    @Test
    public void createWestOrientation() {
        Assert.assertEquals(westOrientation(), orientation("W"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNullOrientation() {
        orientation(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createUnknownOrientation() {
        orientation("bla");
    }

}
