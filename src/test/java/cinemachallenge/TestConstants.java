package cinemachallenge;

import cinemachallenge.domain.model.ScreeningType;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public abstract class TestConstants {
    public static final String SCHEDULE_ID = "AnyScheduleId";
    public static final String MOVIE_NAME = "Shrek";
    public static final Duration MOVIE_DURATION = Duration.of(90, ChronoUnit.MINUTES);
    public static final LocalTime SCREENING_STARTING = LocalTime.of(12, 00, 00);
    public static final LocalTime SCREENING_STARTING_2 = LocalTime.of(14, 15, 00);
    public static final String ROOM_NAME = "ROOM_1";
    public static final Duration ROOM_CLEANING_TIME = Duration.of(30, ChronoUnit.MINUTES);
    public static final Set<ScreeningType> SCREENING_TYPES = Set.of(ScreeningType._2D,ScreeningType._3D);

}
