package pairmatching.repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.utils.ResourceReader;

public class BackendCrewRepository implements CrewRepository {

    public static final String BACKEND_CREW_MD = "backend-crew.md";

    @Override
    public List<Crew> readCrews() throws IOException {
        List<String> names = ResourceReader.readResource(BACKEND_CREW_MD);

        return names.stream()
                .map(name -> new Crew(Course.BACKEND, name))
                .collect(Collectors.toList());
    }
}
