public class NorthOrientation implements Orientation {

    @Override
    public Orientation left() {
        return new WestOrientation();
    }

    @Override
    public Orientation right() {
        return new EastOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().incrementAxisY();
    }
}
