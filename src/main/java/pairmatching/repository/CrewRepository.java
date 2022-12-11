package pairmatching.repository;

import java.io.IOException;
import java.util.List;
import pairmatching.domain.Crew;

public interface CrewRepository {

    List<Crew> readCrews() throws IOException;
}
