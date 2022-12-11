package pairmatching.domain;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableMap;

import java.util.Map;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String label;

    private static final Map<String, Course> labelToCourse =
            stream(values()).collect(toUnmodifiableMap(Course::label, course -> course));


    Course(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    public static Course findByLabel(String label) {
        return labelToCourse.get(label);
    }
}