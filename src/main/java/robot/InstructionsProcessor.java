package robot;

import mars.CartesianCoordinates;
import mars.MarsSurface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static robot.actions.InstructionsChainFactory.instructionChain;
import static robot.actions.OrientationFactory.orientation;

/**
 * Can be improved to write to file via BufferedWritter, so that we can deal with big result files as well.
 */
public class InstructionsProcessor {

    MarsSurface surface;

    public String process(InputStream instructions) throws IOException {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(instructions))) {
            String line;
            int lineNumber = 1;
            int nextRobotLineNumber = 2;
            Robot robot = null;
            while ((line = reader.readLine()) != null) {
                if (lineNumber == 1) {
                    surface = createMarsSurface(line);
                } else if (nextRobotLineNumber == lineNumber) {
                    robot = createRobot(line);
                } else if (nextRobotLineNumber + 1 == lineNumber) {
                    nextRobotLineNumber+=3;
                    robot.execute(instructionChain(line));
                    result.append(robot);
                    result.append(System.lineSeparator());
                }
                lineNumber++;
            }
            return result.toString();
        }
    }

    /**
     * This could be moved to a robot.Robot factory class..
     */
    public Robot createRobot(String line) {
        String[] inputArray = line.split(" ");
        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);
        return new Robot(new CartesianCoordinates(x, y), surface, orientation(inputArray[2]));
    }

    /**
     * This could be moved to a mars.MarsSurface factory class..
     */
    private MarsSurface createMarsSurface(String line) {
        String[] inputArray = line.split(" ");
        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);
        return new MarsSurface(new CartesianCoordinates(x, y));
    }
}
