package robot.actions;

import io.vavr.control.Either;
import mars.CartesianCoordinates;
import robot.Robot;

/**
 * Represents where the robot is heading to and how to move around based on where it is heading.
 */
public interface Orientation {

    Orientation left();

    Orientation right();

    Either<IllegalArgumentException, CartesianCoordinates> forward(Robot robot);
}
