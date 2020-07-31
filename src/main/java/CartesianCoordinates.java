import lombok.Data;
import lombok.NonNull;

@Data
public class CartesianCoordinates {

    @NonNull
    private int y;

    @NonNull
    private int x;
}