package cinemachallenge;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class TestConstants {
    public static final String SCHEDULE_ID = "AnyScheduleId";
    public static String MOVIE_NAME = "Shrek";
    public static Duration MOVIE_DURATION = Duration.of(90, ChronoUnit.MINUTES);
    public static LocalTime SCREENING_STARTING = LocalTime.of(12, 00, 00);
    public static LocalTime SCREENING_STARTING_2 = LocalTime.of(14, 15, 00);
    public static String ROOM_NAME = "ROOM_1";
    public static Duration ROOM_CLEANING_TIME = Duration.of(30, ChronoUnit.MINUTES);

}
