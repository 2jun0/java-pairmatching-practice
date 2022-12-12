package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Level;
import pairmatching.repository.CrewPairRepository;

public class CrewPairService {

    private final CrewPairRepository crewPairRepository;
    private final CrewService crewService;

    public CrewPairService(CrewPairRepository crewPairRepository, CrewService crewService) {
        this.crewPairRepository = crewPairRepository;
        this.crewService = crewService;
    }

    public List<CrewPair> pairMatch(Level level, Course course) {
        for (int i = 0; i < 3; i++) {
            List<CrewPair> crewPairs = tryPairMatch(course);

            if (!isAlreadyPairMatchedMany(level, crewPairs)) {
                return crewPairs;
            }
        }

        throw new IllegalArgumentException("폐어 매칭 실패");
    }

    private List<CrewPair> tryPairMatch(Course course) {
        List<Crew> crews = crewService.getCrews(course);
        List<CrewPair> crewPairs = new ArrayList<>();

        for (int i = 0; i < crews.size(); i+=2) {
            if (i == crews.size() - 3) {
                crewPairs.add(new CrewPair(crews.get(i), crews.get(i+1), crews.get(i+2)));
                break;
            }

            crewPairs.add(new CrewPair(crews.get(i), crews.get(i+1)));
        }

        return crewPairs;
    }

    public void saveCrewPairs(Level level, List<CrewPair> crewPairs) {
        for (CrewPair crewPair : crewPairs) {
            crewPairRepository.save(level, crewPair);
        }
    }

    private boolean isAlreadyPairMatchedMany(Level level, List<CrewPair> crewPairs) {
        return crewPairs.stream()
                .anyMatch(crewPair -> isAlreadyPairMatchedOne(level, crewPair));
    }

    private boolean isAlreadyPairMatchedOne(Level level, CrewPair crewPair) {
        List<CrewPair> crewPairs = crewPairRepository.findByLevel(level);

        return crewPairs.stream()
                .anyMatch(pair -> hasIntersectionWithCrews(pair.crews(), crewPair.crews()));
    }

    private boolean hasIntersectionWithCrews(Set<Crew> crews1, Set<Crew> crews2) {
        Set<Crew> intersection = new HashSet<>(crews1);
        intersection.retainAll(crews2);

        return intersection.size() > 1;
    }
}
