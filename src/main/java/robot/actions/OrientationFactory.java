package robot.actions;

import java.util.Optional;

import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class OrientationFactory {

    public static Orientation orientation(String orientation) {

        Optional.ofNullable(orientation).orElseThrow(() -> new IllegalArgumentException("orientation letter required"));

        if(orientation.equals("N"))
            return northOrientation();
        if(orientation.equals("W"))
            return westOrientation();
        if(orientation.equals("S"))
            return southOrientation();
        if(orientation.equals("E"))
            return eastOrientation();

        throw new IllegalArgumentException("Unknown orientation");
    }
}
