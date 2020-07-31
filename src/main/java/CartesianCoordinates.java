import lombok.Data;
import lombok.NonNull;

@Data
public class CartesianCoordinates {

    @NonNull
    private int x;

    @NonNull
    private int y;

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
}