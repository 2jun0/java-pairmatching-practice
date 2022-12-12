package pairmatching.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.CrewPairRepository;

public class CrewPairService {

    private final CrewPairRepository crewPairRepository;
    private final CrewService crewService;

    public CrewPairService(CrewPairRepository crewPairRepository, CrewService crewService) {
        this.crewPairRepository = crewPairRepository;
        this.crewService = crewService;
    }

    public List<CrewPair> pairMatch(Course course, Mission mission) {
        for (int i = 0; i < 3; i++) {
            List<CrewPair> crewPairs = tryPairMatch(course, mission);

            if (!isAlreadyPairMatchedMany(course, mission.level(), crewPairs)) {
                return crewPairs;
            }
        }

        throw new IllegalArgumentException("폐어 매칭 실패");
    }

    private List<CrewPair> tryPairMatch(Course course, Mission mission) {
        List<Crew> crews = crewService.getCrews(course);
        List<CrewPair> crewPairs = new ArrayList<>();

        for (int i = 0; i < crews.size(); i+=2) {
            if (i == crews.size() - 3) {
                crewPairs.add(new CrewPair(course, mission, crews.get(i), crews.get(i+1), crews.get(i+2)));
                break;
            }

            crewPairs.add(new CrewPair(course, mission, crews.get(i), crews.get(i+1)));
        }

        return crewPairs;
    }

    public void saveCrewPairs(List<CrewPair> crewPairs) {
        for (CrewPair crewPair : crewPairs) {
            crewPairRepository.save(crewPair);
        }
    }

    private boolean isAlreadyPairMatchedMany(Course course, Level level, List<CrewPair> crewPairs) {
        List<CrewPair> savedPairs = crewPairRepository.findByCourseAndLevel(course, level);

        for (CrewPair crewPair : crewPairs) {
            if (savedPairs.stream().anyMatch(
                    savedPair -> hasIntersectionWithCrews(savedPair.crews(), crewPair.crews()))) {
                return true;
            }
        }

        return false;
    }

    private boolean hasIntersectionWithCrews(List<Crew> crews1, List<Crew> crews2) {
        Set<Crew> intersection = new HashSet<>(crews1);
        intersection.retainAll(crews2);

        return intersection.size() > 1;
    }
}
