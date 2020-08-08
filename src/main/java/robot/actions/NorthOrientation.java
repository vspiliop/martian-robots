package robot.actions;

import mars.CartesianCoordinates;
import robot.Robot;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class NorthOrientation implements Orientation {

    private static final Orientation NORTH = new NorthOrientation();

    private NorthOrientation() {}

    public static Orientation northOrientation() {
        return NORTH;
    }

    @Override
    public Orientation left() {
        return westOrientation();
    }

    @Override
    public Orientation right() {
        return eastOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().incrementAxisY();
    }
}
