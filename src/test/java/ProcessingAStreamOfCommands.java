import org.junit.Assert;
import org.junit.Test;
import robot.InstructionsProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcessingAStreamOfCommands {

    @Test
    public void exerciseInstructionsScenario() throws IOException {
        InputStream instructions = Files.newInputStream(Paths.get("src/test/resources/instructions_from_exercise_description"));
        String expectedOutput = Files.readString(Paths.get("src/test/resources/expected_output_from_exercise_description"));

        Assert.assertEquals(expectedOutput, new InstructionsProcessor().process(instructions));
    }

}
