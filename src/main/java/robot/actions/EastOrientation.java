package robot.actions;

import mars.CartesianCoordinates;
import robot.Robot;

import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;

public class EastOrientation implements Orientation {

    private EastOrientation() {}

    public static Orientation eastOrientation() {
        return new EastOrientation();
    }

    @Override
    public Orientation left() {
        return northOrientation();
    }

    @Override
    public Orientation right() {
        return southOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().incrementAxisX();
    }
}
