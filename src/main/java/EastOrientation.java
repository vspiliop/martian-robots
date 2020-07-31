public class EastOrientation implements Orientation {

    @Override
    public Orientation left() {
        return new NorthOrientation();
    }

    @Override
    public Orientation right() {
        return new SouthOrientation();
    }

    @Override
    public CartesianCoordinates forward(Robot robot) {
        return robot.getCoordinates().incrementAxisX();
    }
}
