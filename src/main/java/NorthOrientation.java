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
    public Orientation forward() {
        return null;
    }
}
