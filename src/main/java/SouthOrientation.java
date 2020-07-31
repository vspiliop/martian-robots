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
    public Orientation forward() {
        return null;
    }
}
