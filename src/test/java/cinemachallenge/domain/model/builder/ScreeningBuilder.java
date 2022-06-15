package cinemachallenge.domain.model.builder;

import cinemachallenge.TestConstants;
import cinemachallenge.domain.model.Movie;
import cinemachallenge.domain.model.Room;
import cinemachallenge.domain.model.Screening;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class ScreeningBuilder {

    public static ScreeningBuilder sample() {
        return new ScreeningBuilder()
                .withMovie(MovieBuilder.sample().build())
                .withDay(DayOfWeek.MONDAY)
                .withRoom(RoomBuilder.sample().build())
                .withStartingTime(TestConstants.SCREENING_STARTING);
    }

    private Movie movie;
    private DayOfWeek day;
    private LocalTime startingTime;
    private Room room;

    public Screening build() {
        return new Screening(this.movie, this.day, this.startingTime, this.room);
    }

    public ScreeningBuilder withMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public ScreeningBuilder withDay(DayOfWeek day) {
        this.day = day;
        return this;
    }

    public ScreeningBuilder withStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
        return this;
    }

    public ScreeningBuilder withRoom(Room room) {
        this.room = room;
        return this;
    }
}
