package robot.actions;

import robot.Robot;

import java.util.Optional;
import java.util.function.Consumer;

import static robot.actions.moving.ProceedForwardInstruction.forwardInstruction;
import static robot.actions.turning.TurnLeftInstruction.leftInstruction;
import static robot.actions.turning.TurnRightInstruction.rightInstruction;

public class InstructionsChainFactory {

    public static Consumer<Robot> instructionChain(String line) {
        Optional.ofNullable(line).orElseThrow(() -> new IllegalArgumentException("instructions line required"));

        if(line.length() > 100) {
            throw new IllegalArgumentException("Instruction chain cannot be longer than 100");
        }

        return line.chars().mapToObj((int instruction)-> {
            if (instruction == 'F')
                return forwardInstruction();
            if (instruction == 'R')
                return rightInstruction();
            if (instruction == 'L')
                return leftInstruction();
            throw new IllegalArgumentException("Unknown command");
        }).reduce((Robot r) -> { }, Consumer::andThen);
    }
}
