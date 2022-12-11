package pairmatching.domain;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String label;

    Course(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}