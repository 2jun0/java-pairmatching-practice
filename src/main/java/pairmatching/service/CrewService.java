package pairmatching.service;

import java.io.IOException;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;

public class CrewService {
    private final CrewRepository crewRepository;

    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public List<Crew> getCrews(Course course) {
        try {
            return crewRepository.findCrewsByCourse(course);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
