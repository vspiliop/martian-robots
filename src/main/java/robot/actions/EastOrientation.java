package robot.actions;

import io.vavr.control.Either;
import mars.CartesianCoordinates;
import robot.Robot;

import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;

public class EastOrientation implements Orientation {

    private static final Orientation EAST = new EastOrientation();

    private EastOrientation() {}

    public static Orientation eastOrientation() {
        return EAST;
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
    public Either<IllegalArgumentException, CartesianCoordinates> forward(Robot robot) {
        return robot.getCoordinates().incrementAxisX();
    }
}
