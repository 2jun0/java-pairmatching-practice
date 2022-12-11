package pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Level;

public class CrewPairRepository {

    private final Map<Level, List<CrewPair>> levelToCrewPairs = new EnumMap<>(Level.class);

    public CrewPairRepository() {
        for (Level level : Level.values()) {
            levelToCrewPairs.put(level, new ArrayList<>());
        }
    }

    public void save(Level level, CrewPair crewPair) {
        levelToCrewPairs.get(level).add(crewPair);
    }

    public List<CrewPair> findByLevel(Level level) {
        return Collections.unmodifiableList(levelToCrewPairs.get(level));
    }
}
