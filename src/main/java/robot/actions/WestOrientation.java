package robot.actions;

import mars.CartesianCoordinates;
import robot.Robot;

import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;

public class WestOrientation implements Orientation {

    private static final Orientation WEST = new WestOrientation();

    private WestOrientation() {}

    public static Orientation westOrientation() {
        return WEST;
    }

    @Override
    public Orientation left() {
        return southOrientation();
    }

    @Override
    public Orientation right() {
        return northOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().decrementAxisX();
    }
}
