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
    public Orientation forward(Robot robot) {
        robot.getCoordinates().decrementAxisX();
        return this;
    }
}
