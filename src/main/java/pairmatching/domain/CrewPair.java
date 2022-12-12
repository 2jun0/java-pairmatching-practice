package pairmatching.domain;

import java.util.List;

public class CrewPair {

    private final List<Crew> crews;
    private final Course course;
    private final Mission mission;

    public CrewPair(Course course, Mission mission, Crew crew1, Crew crew2) {
        this.course = course;
        this.mission = mission;
        crews = List.of(crew1, crew2);
    }

    public CrewPair(Course course, Mission mission, Crew crew1, Crew crew2, Crew crew3) {
        this.course = course;
        this.mission = mission;
        crews = List.of(crew1, crew2, crew3);
    }

    public List<Crew> crews() {
        return crews;
    }

    public Mission mission() {
        return mission;
    }

    public Course course() {
        return course;
    }
}
