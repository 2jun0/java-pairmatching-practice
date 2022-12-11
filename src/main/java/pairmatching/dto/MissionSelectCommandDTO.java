package pairmatching.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionSelectCommandDTO {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public MissionSelectCommandDTO(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course course() {
        return course;
    }

    public Level level() {
        return level;
    }

    public Mission mission() {
        return mission;
    }
}
