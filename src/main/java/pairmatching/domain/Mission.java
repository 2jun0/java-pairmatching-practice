package pairmatching.domain;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static pairmatching.domain.Level.*;

import java.util.List;
import java.util.Map;

public enum Mission {
    CAR_RACING("자동차경주", LEVEL1),
    LOTTO("로또", LEVEL1),
    BASEBALL_GAME("숫자야구게임", LEVEL1),

    SHOPPING_BAG("장바구니", LEVEL2),
    PAYMENT("결제", LEVEL2),
    SUBWAY_MAP("지하철노선도", LEVEL2),

    PERFORMANCE_IMPROVEMENT("성능개선", LEVEL4),
    PUBLISH("배포", LEVEL4);

    private final String label;
    private final Level level;

    private static final Map<Level, List<Mission>> levelToMissions =
            stream(values()).collect(groupingBy(Mission::level));

    Mission(String label, Level level) {
        this.label = label;
        this.level = level;
    }

    public static List<Mission> findByLevel(Level level) {
        return levelToMissions.get(level);
    }

    public String label() {
        return label;
    }

    public Level level() {
        return level;
    }
}
