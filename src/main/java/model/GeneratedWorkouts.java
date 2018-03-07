package model;

import java.security.SecureRandom;

public enum GeneratedWorkouts
{
    //upper
    PUSH_UPS(1, "push ups"),
    BURPEES(1, "Burpees"),
    HANDSTAND_PUSH_UPS(1, "Handstand push ups"),
    BENCH_PRESS(1, "Bench press"),
    PULL_UPS(1, "Pull ups"),
    BICEP_CURLS(1, "Bicep curls"),

    //Legs
    SQUATS(2, "Squats"),
    LUNGES(2, "Lunges"),
    MOUNTAIN_CLIMBERS(2, "Mountain Climbers"),
    WALL_SITS(2, "Wall sits"),

    //ABS
    SIT_UPS(3, "Sit ups"),
    PLANK(3, "Plank"),
    TRICEP_DIPS(3, "Tricep dips");

    private int code;
    private String name;
    private static final SecureRandom random = new SecureRandom();

    GeneratedWorkouts(int code, String name) {
        this.code = code;
        this.name = name;

    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
