package robot.actions;

import mars.CartesianCoordinates;
import robot.Robot;

public class WestOrientation implements Orientation {

    @Override
    public Orientation left() {
        return new SouthOrientation();
    }

    @Override
    public Orientation right() {
        return new NorthOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().decrementAxisX();
    }
}
