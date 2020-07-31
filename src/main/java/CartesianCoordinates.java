import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode
@AllArgsConstructor
public class CartesianCoordinates {

    @Getter
    @NonNull
    private int x;

    @Getter
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