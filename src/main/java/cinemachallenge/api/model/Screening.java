package cinemachallenge.api.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record Screening(Movie movie, Room room, DayOfWeek day, LocalTime startingTime) {
}
