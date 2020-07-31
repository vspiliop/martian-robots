/**
 * Represents where the robot is heading to and how to move around based on where it is heading.
 */
public interface Orientation {

    Orientation left();

    Orientation right();

    CartesianCoordinates forward(Robot robot);
}
