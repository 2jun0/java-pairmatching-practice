package pairmatching.domain;

import java.util.Objects;
import java.util.Set;

public class CrewPair {

    private final Set<Crew> crews;

    public CrewPair(Crew crew1, Crew crew2) {
        crews = Set.of(crew1, crew2);
    }

    public CrewPair(Crew crew1, Crew crew2, Crew crew3) {
        crews = Set.of(crew1, crew2, crew3);
    }

    public Set<Crew> crews() {
        return crews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CrewPair crewPair = (CrewPair) o;

        return Objects.equals(crews, crewPair.crews);
    }

    @Override
    public int hashCode() {
        return crews != null ? crews.hashCode() : 0;
    }
}
