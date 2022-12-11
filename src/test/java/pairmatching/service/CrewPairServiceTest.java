package pairmatching.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Level;
import pairmatching.repository.CrewPairRepository;

class CrewPairServiceTest {

    private CrewPairService crewPairService;

    @BeforeEach
    void beforeEach() {
        CrewPairRepository repository = new CrewPairRepository();
        crewPairService = new CrewPairService(repository);
    }

    @Test
    void isAlreadyPairMatchedFalse() {
        Crew crewA = new Crew(Course.BACKEND, "CrewA");
        Crew crewB = new Crew(Course.BACKEND, "CrewB");
        CrewPair crewPair = new CrewPair(crewA, crewB);

        boolean alreadyPairMatched = crewPairService.isAlreadyPairMatched(Level.LEVEL1, crewPair);

        assertThat(alreadyPairMatched).isEqualTo(false);
    }

    @Test
    void isAlreadyPairMatchedTrue() {
        Crew crewA = new Crew(Course.BACKEND, "CrewA");
        Crew crewB = new Crew(Course.BACKEND, "CrewB");
        Crew crewC = new Crew(Course.BACKEND, "CrewC");
        CrewPair crewPairAB = new CrewPair(crewA, crewB, crewC);
        crewPairService.saveCrewPairs(Level.LEVEL1, List.of(crewPairAB));

        CrewPair crewPairAC = new CrewPair(crewA, crewC);
        boolean alreadyPairMatched = crewPairService.isAlreadyPairMatched(Level.LEVEL1, crewPairAC);

        assertThat(alreadyPairMatched).isEqualTo(true);
    }
}