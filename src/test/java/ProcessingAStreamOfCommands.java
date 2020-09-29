import org.junit.Test;
import robot.InstructionsProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class ProcessingAStreamOfCommands {

    @Test
    public void exerciseInstructionsScenario() throws IOException {
        InputStream instructions = Files.newInputStream(Paths.get("src/test/resources/instructions_from_exercise_description"));
        String expectedOutput = Files.readString(Paths.get("src/test/resources/expected_output_from_exercise_description"));

        final var underTest = new InstructionsProcessor().process(instructions);
        assertThat(underTest).isSuccess();
        assertThat(underTest).contains(expectedOutput);
    }

    @Test
    public void unknownCommand() throws IOException {
        InputStream instructions = Files.newInputStream(Paths.get("src/test/resources/instructions_unknown_command"));

        final var underTest = new InstructionsProcessor().process(instructions);
        assertThat(underTest).isFailure();
        assertThat(underTest).failBecauseOf(IllegalArgumentException.class);
        assertThat(underTest).failReasonHasMessage("Unknown command");
    }

    @Test
    public void cannotCreateSurface_tooLargeCoordinates() throws IOException {
        InputStream instructions = Files.newInputStream(Paths.get("src/test/resources/instructions_surface_error"));

        final var underTest = new InstructionsProcessor().process(instructions);
        assertThat(underTest).isFailure();
        assertThat(underTest).failBecauseOf(IllegalArgumentException.class);
        assertThat(underTest).failReasonHasMessage("No coordinate can be more than 50");
    }

    @Test
    public void robotStartingPoint_tooLargeCoordinates() throws IOException {
        InputStream instructions = Files.newInputStream(Paths.get("src/test/resources/instructions_starting_point_error"));

        final var underTest = new InstructionsProcessor().process(instructions);
        assertThat(underTest).isFailure();
        assertThat(underTest).failBecauseOf(IllegalArgumentException.class);
        assertThat(underTest).failReasonHasMessage("No coordinate can be more than 50");
    }

    @Test
    public void robotStartingPoint_notParsable() throws IOException {
        InputStream instructions = Files.newInputStream(Paths.get("src/test/resources/instructions_starting_point_not_parsable"));

        final var underTest = new InstructionsProcessor().process(instructions);
        assertThat(underTest).isFailure();
        assertThat(underTest).failBecauseOf(IllegalArgumentException.class);
        assertThat(underTest).failReasonHasMessage("x non parsable");
    }

    @Test
    public void robotStartingPoint_unknownOrientation() throws IOException {
        InputStream instructions = Files.newInputStream(Paths.get("src/test/resources/instructions_starting_point_unknown_orientation"));

        final var underTest = new InstructionsProcessor().process(instructions);
        assertThat(underTest).isFailure();
        assertThat(underTest).failBecauseOf(IllegalArgumentException.class);
        assertThat(underTest).failReasonHasMessage("unknown orientation");
    }

    @Test
    public void unknownCommand_null() {
        final var underTest = new InstructionsProcessor().process(null);
        assertThat(underTest).isFailure();
        assertThat(underTest).failBecauseOf(NullPointerException.class);
    }

}
