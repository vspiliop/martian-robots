package robot.actions;

import mars.CartesianCoordinates;
import robot.Robot;

public class SouthOrientation implements Orientation {

    @Override
    public Orientation left() {
        return new EastOrientation();
    }

    @Override
    public Orientation right() {
        return new WestOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().decrementAxisY();
    }
}
