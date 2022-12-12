package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class CrewPairRepository {

    private final List<CrewPair> crewPairs = new ArrayList<>();

    public void save(CrewPair crewPair) {
        crewPairs.add(crewPair);
    }

    public List<CrewPair> findByCourseAndLevel(Course course, Level level) {
        return crewPairs.stream()
                .filter(crewPair -> crewPair.course() == course)
                .filter(crewPair -> crewPair.mission().level() == level)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CrewPair> findByCourseAndMission(Course course, Mission mission) {
        return crewPairs.stream()
                .filter(crewPair -> crewPair.course() == course)
                .filter(crewPair -> crewPair.mission() == mission)
                .collect(Collectors.toUnmodifiableList());
    }
}
