package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.dto.MissionSelectCommandDto;

public class InputParser {

    private final InputValidator inputValidator;

    public InputParser(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    MissionSelectCommandDto parseMissionSelectCommands(String commandsStr) {
        String[] commands = commandsStr.split(",");

        inputValidator.validateMissionSelectCommands(commands);

        return new MissionSelectCommandDto(
                Course.findByLabel(commands[0].trim()),
                Level.findByLabel(commands[1].trim()),
                Mission.findByLabel(commands[2].trim()));
    }
}
