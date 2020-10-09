package robot;

import io.vavr.control.Either;
import io.vavr.control.Try;
import mars.CartesianCoordinates;
import mars.MarsSurface;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.OrientationFactory.orientation;

/**
 * Can be improved to write to file via BufferedWriter, so that we can deal with big result files as well.
 */
public class InstructionsProcessor {

    public Try<String> process(InputStream instructions) {
        StringBuilder result = new StringBuilder();
        return Try.withResources(() -> new BufferedReader(new InputStreamReader(instructions)))
                .of(reader -> {
                    String line;
                    int lineNumber = 1;
                    int nextRobotLineNumber = 2;
                    Either<IllegalArgumentException, Robot> robot = Either.left(new IllegalArgumentException("Could not create robot"));
                    Either<IllegalArgumentException, MarsSurface> surface = Either.left(new IllegalArgumentException("Could not create mars surface"));
                    while ((line = reader.readLine()) != null) {
                        if (lineNumber == 1) {
                            surface = createMarsSurface(line);
                            reportErrors(surface);
                        } else if (nextRobotLineNumber == lineNumber) {
                            robot = createRobot(line, surface);
                            reportErrors(robot);
                        } else if (nextRobotLineNumber + 1 == lineNumber) {
                            nextRobotLineNumber+=3;
                            final String finalLine = line;
                            robot = robot.flatMap(r -> r.execute(instructionChain(finalLine)));
                            surface = robot.map(r -> r.getSurface());
                            reportErrors(robot);
                            robot.map(r -> result.append(r).append(System.lineSeparator()));
                        }
                        lineNumber++;
                    }
                    return result.toString();
                });
    }

    private void reportErrors(Either<IllegalArgumentException, ?> ... eithers) {
        Arrays.asList(eithers).stream().forEach(either -> either.left().map(e -> {
            throw e;
        }));
    }

    /**
     * The robot is created only if dependencies have been correctly created first.
     */
    public Either<IllegalArgumentException, Robot> createRobot(String line, Either<IllegalArgumentException, MarsSurface> surface) {
        String[] inputArray = line.split(" ");
        final var x = parseCoordinate("x non parsable", inputArray[0]);
        final var y = parseCoordinate("y non parsable", inputArray[1]);

        return orientation(inputArray[2]).flatMap(or -> x.flatMap(xx -> y.flatMap(
                yy -> CartesianCoordinates.from(xx, yy).flatMap(cc -> surface.map(s -> new Robot(Robot.Status.ALIVE, cc, s, or))))));
    }

    /**
     * The surface will be created only if the dependencies are first created.
     */
    private Either<IllegalArgumentException, MarsSurface> createMarsSurface(String line) {
        String[] inputArray = line.split(" ");
        final var x = parseCoordinate("x non parsable", inputArray[0]);
        final var y = parseCoordinate("y non parsable", inputArray[1]);

        return x.flatMap(xx -> y.flatMap(yy -> CartesianCoordinates.from(xx, yy).map(cc -> new MarsSurface(cc))));
    }

    private Either<IllegalArgumentException, Integer> parseCoordinate(String s, String value) {
        return Try.of(() -> Integer.parseInt(value)).toEither(new IllegalArgumentException(s));
    }
}
