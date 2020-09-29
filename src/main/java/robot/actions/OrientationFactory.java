package robot.actions;

import io.vavr.control.Either;
import io.vavr.control.Option;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;
import static robot.actions.EastOrientation.eastOrientation;
import static robot.actions.NorthOrientation.northOrientation;
import static robot.actions.SouthOrientation.southOrientation;
import static robot.actions.WestOrientation.westOrientation;

public class OrientationFactory {
    public static Either<IllegalArgumentException, Orientation> orientation(String orientation) {
        return Match(Option.of(orientation)).of(
                Case($Some($("N")), Either.right(northOrientation())),
                Case($Some($("W")), Either.right(westOrientation())),
                Case($Some($("S")), Either.right(southOrientation())),
                Case($Some($("E")), Either.right(eastOrientation())),
                Case($None(), Either.left(new IllegalArgumentException("orientation letter required"))),
                Case($(), Either.left(new IllegalArgumentException("unknown orientation")))
        );
    }
}
