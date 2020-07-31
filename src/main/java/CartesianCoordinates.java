import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class CartesianCoordinates {

    public static final int MAX_COORDINATE_VALUE = 50;

    @Getter
    private int x;

    @Getter
    private int y;

    public CartesianCoordinates(int x, int y) {

        if(x > MAX_COORDINATE_VALUE || y > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("No coordinate can be more than 50");
        }

        this.x = x;
        this.y = y;
    }

    public void incrementAxisX() {
        x++;
    }

    public void incrementAxisY() {
        y++;
    }

    public void decrementAxisX() {
        x--;
    }

    public void decrementAxisY() {
        y--;
    }

    public boolean isInMarsSurface(MarsSurface surface) {
        if (x < surface.getLowerBound().getX() || x > surface.getUpperBound().getX()) {
            return false;
        }

        if (y < surface.getLowerBound().getY() || y > surface.getUpperBound().getY()) {
            return false;
        }

        return true;
    }
}