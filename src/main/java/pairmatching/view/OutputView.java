package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewPair;

public class OutputView {

    public void printPariMatchResult(List<CrewPair> crewPairs) {
        printLine("페어 매칭 결과입니다.");
        for (CrewPair crewPair : crewPairs) {
            printLine(crewPair.crews().stream()
                    .map(Crew::name)
                    .collect(Collectors.joining(" : ")));
        }
    }

    private void printLine(String line) {
        System.out.println(line);
    }
}
