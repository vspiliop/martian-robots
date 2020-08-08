package robot.actions;

import mars.CartesianCoordinates;
import robot.Robot;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class NorthOrientation implements Orientation {

    private NorthOrientation() {}

    public static Orientation northOrientation() {
        return new NorthOrientation();
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
