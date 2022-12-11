package pairmatching.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Level;
import pairmatching.repository.CrewPairRepository;

public class CrewPairService {

    private final CrewPairRepository crewPairRepository;

    public CrewPairService(CrewPairRepository crewPairRepository) {
        this.crewPairRepository = crewPairRepository;
    }

    public void saveCrewPairs(Level level, List<CrewPair> crewPairs) {
        for (CrewPair crewPair : crewPairs) {
            crewPairRepository.save(level, crewPair);
        }
    }

    public boolean isAlreadyPairMatched(Level level, CrewPair crewPair) {
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
