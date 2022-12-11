package pairmatching.repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.utils.ResourceReader;

public class FrontendCrewRepository implements CrewRepository {
    
    public static final String FRONTEND_CREW_MD = "frontend-crew.md";

    @Override
    public List<Crew> readCrews() throws IOException {
        List<String> names = ResourceReader.readResource(FRONTEND_CREW_MD);

        return names.stream()
                .map(name -> new Crew(Course.FRONTEND, name))
                .collect(Collectors.toList());
    }
}
