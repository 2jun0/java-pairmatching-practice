package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.utils.ResourceReader;

public class CrewRepository {

    public static final String BACKEND_CREW_MD = "backend-crew.md";
    public static final String FRONTEND_CREW_MD = "frontend-crew.md";

    public List<Crew> findCrewsByCourse(Course course) throws IOException {
        String resourceName = resourceNameByCourse(course);
        List<String> names = shuffleNames(ResourceReader.readResource(resourceName));

        return names.stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
    }

    private String resourceNameByCourse(Course course) {
        if (course == Course.BACKEND) {
            return BACKEND_CREW_MD;
        }

        if (course == Course.FRONTEND) {
            return FRONTEND_CREW_MD;
        }

        throw new IllegalArgumentException("해당 과정의 리소스는 찾을 수 없습니다.");
    }

    private List<String> shuffleNames(List<String> names) {
        return Randoms.shuffle(names);
    }
}
