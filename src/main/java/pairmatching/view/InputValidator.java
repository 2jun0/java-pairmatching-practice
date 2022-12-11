package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputValidator {

    void validateFunctionSelectCommand(String command) {
        if (!command.matches("^1|2|3|q$")) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    void validateMissionSelectCommands(String[] commands) {
        if (commands.length != 3) {
            throw new IllegalArgumentException("3가지를 입력해야 합니다.");
        }

        validateCourseLabel(commands[0].trim());
        validateLevelLabel(commands[1].trim());
        validateMissionLabel(commands[2].trim());
    }

    private void validateCourseLabel(String courseLabel) {
        if (Course.findByLabel(courseLabel) == null) {
            throw new IllegalArgumentException("올바른 과정이 아닙니다.");
        }
    }

    private void validateLevelLabel(String levelLabel) {
        if (Level.findByLabel(levelLabel) == null) {
            throw new IllegalArgumentException("올바른 레벨이 아닙니다.");
        }
    }

    private void validateMissionLabel(String missionLabel) {
        if (Mission.findByLabel(missionLabel) == null) {
            throw new IllegalArgumentException("올바른 미션이 아닙니다.");
        }
    }
}
