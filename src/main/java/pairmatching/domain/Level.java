package pairmatching.domain;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableMap;

import java.util.Map;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String label;

    private static final Map<String, Level> labelToLevel =
            stream(values()).collect(toUnmodifiableMap(Level::label, level -> level));

    Level(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    public static Level findByLabel(String label) {
        return labelToLevel.get(label);
    }
}
