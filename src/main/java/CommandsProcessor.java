import java.io.*;
import java.util.function.Consumer;

/**
 * Can be improved to write to file via BufferedWritter, so that we can deal with big result files as well.
 */
public class CommandsProcessor {

    MarsSurface surface;

    public String process(InputStream instructions) throws IOException {
        StringBuilder result = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(instructions))) {
            String line;
            int lineNumber = 1;
            int nextRobotLineNumber = 2;
            Robot robot = null;
            while ((line = reader.readLine()) != null) {
                if(lineNumber == 1) {
                    surface = createMarsSurface(line);
                } else if(nextRobotLineNumber == lineNumber) {
                    robot = createRobot(line);
                } else if (nextRobotLineNumber + 1 == lineNumber) {
                    nextRobotLineNumber+=3;
                    robot.execute(createInstructionChain(line));
                    result.append(robot);
                    result.append(System.lineSeparator());
                }
                lineNumber++;
            }
            return result.toString();
        }
    }

    /**
     * This could be moved to a Orientation factory class..
     */
    public Orientation createOrientation(String orientation) {
        if(orientation.equals("N"))
            return new NorthOrientation();
        if(orientation.equals("W"))
            return new WestOrientation();
        if(orientation.equals("S"))
            return new SouthOrientation();
        if(orientation.equals("E"))
            return new EastOrientation();

        throw new IllegalArgumentException("Unknown orientation");
    }

    /**
     * This could be moved to a Robot factory class..
     */
    public Robot createRobot(String line) {
        String[] inputArray = line.split(" ");
        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);
        return new Robot(new CartesianCoordinates(x, y), surface, createOrientation(inputArray[2]));
    }

    /**
     * This could be moved to a MarsSurface factory class..
     */
    private MarsSurface createMarsSurface(String line) {
        String[] inputArray = line.split(" ");
        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);
        return new MarsSurface(new CartesianCoordinates(x, y));
    }

    /**
     * This could be moved to a Instruction factory class..
     */
    private Consumer<Robot> createInstructionChain(String line) {
        if(line.length() > 100) {
            throw new IllegalArgumentException("Instruction chain cannot be longer than 100");
        }

        return line.chars().mapToObj((int instruction)-> {
            if (instruction == 'F')
                return new ProceedForwardInstruction();
            if (instruction == 'R')
                return new TurnRightInstruction();
            if (instruction == 'L')
                return new TurnLeftInstruction();
            throw new IllegalArgumentException("Unknown command");
        }).reduce((Robot r) -> { }, Consumer::andThen);
    }
}
