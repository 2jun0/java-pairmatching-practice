package pairmatching.view;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputFormatter {

    String formatInputMissionSelectCommands() {
        final String contextDelimiter = "#############################################";
        final String enterCommands = "과정, 레벨, 미션을 선택하세요.";
        final String exampleCommands = "ex) 백엔드, 레벨1, 자동차경주";

        return contextDelimiter + "\n"
                + formatCourses() + "\n"
                + formatMissions() + "\n"
                + contextDelimiter + "\n"
                + enterCommands + "\n"
                + exampleCommands;
    }

    private String formatCourses() {
        String courseLabels = stream(Course.values())
                .map(Course::label)
                .collect(joining(" | "));

        return "과정: " + courseLabels;
    }

    private String formatMissions() {
        String formattedMissions = stream(Level.values())
                .map(this::formatMissionsForLevel)
                .collect(joining("\n"));

        return "미션:\n" + formattedMissions;
    }

    private String formatMissionsForLevel(Level level) {
        String missionLabels = Mission.findByLevel(level).stream()
                    .map(Mission::label)
                    .collect(joining(" | "));

        return String.format("  - %s: %s", level.label(), missionLabels);
    }
}
