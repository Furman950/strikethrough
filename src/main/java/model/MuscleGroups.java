package model;

public enum MuscleGroups
{
    UPPER_BODY("Upper body"),
    LEGS("Legs"),
    ABS("Abs");

    private final String name;

    MuscleGroups(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}