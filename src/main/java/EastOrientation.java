public class EastOrientation implements Orientation {

    @Override
    public Orientation left() {
        return new NorthOrientation();
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
