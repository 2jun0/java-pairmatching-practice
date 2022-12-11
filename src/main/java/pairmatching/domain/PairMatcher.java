package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PairMatcher {

    public List<CrewPair> matchPair(List<Crew> crews) {
        List<Crew> shuffled = Randoms.shuffle(crews);
        List<CrewPair> crewPairs = new ArrayList<>();

        for (int i = 0; i < shuffled.size(); i+=2) {
            if (i == shuffled.size() - 3) {
                crewPairs.add(new CrewPair(shuffled.get(i), shuffled.get(i+1), shuffled.get(i+2)));
                break;
            }

            crewPairs.add(new CrewPair(shuffled.get(i), shuffled.get(i+1)));
        }

        return crewPairs;
    }
}
