public class WestOrientation implements Orientation {

    @Override
    public Orientation left() {
        return new SouthOrientation();
    }

    @Override
    public Orientation right() {
        return null;
    }

    @Override
    public Orientation forward() {
        return null;
    }
}
