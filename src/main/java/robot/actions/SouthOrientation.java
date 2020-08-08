package robot.actions;

import mars.CartesianCoordinates;
import robot.Robot;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class SouthOrientation implements Orientation {

    private static final Orientation SOUTH = new SouthOrientation();

    private SouthOrientation() {}

    public static Orientation southOrientation() {
        return SOUTH;
    }

    @Override
    public Orientation left() {
        return eastOrientation();
    }

    @Override
    public Orientation right() {
        return westOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().decrementAxisY();
    }
}
