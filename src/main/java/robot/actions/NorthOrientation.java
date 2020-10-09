package robot.actions;

import io.vavr.control.Either;
import mars.CartesianCoordinates;
import robot.Robot;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.WestOrientation.westOrientation;

final public class NorthOrientation implements Orientation {

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
    public Either<IllegalArgumentException, CartesianCoordinates> forward(Robot robot) {
        return robot.getCoordinates().incrementAxisY();
    }
}
