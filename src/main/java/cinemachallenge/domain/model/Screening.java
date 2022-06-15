package cinemachallenge.domain.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

//Seans
public class Screening {

    private Movie movie;
    private DayOfWeek day;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private Room room;

    public Screening(Movie movie, DayOfWeek day, LocalTime startingTime, Room room) {
        this.movie = movie;
        this.room = room;
        this.startingTime = startingTime;
        this.endingTime = startingTime.plus(movie.getRunningTime());
        this.day = day;
    }

    public Movie movie() {
        return movie;
    }

    public DayOfWeek day() {
        return this.day;
    }

    public LocalTime startingTime() {
        return this.startingTime;
    }

    public LocalTime endingTime() {
        return this.endingTime;
    }

    public LocalTime roomAvailableTime() {
        return this.endingTime.plus(room.cleaningTime());
    }

    public Room room() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(movie, screening.movie) && day == screening.day && Objects.equals(startingTime, screening.startingTime) && Objects.equals(endingTime, screening.endingTime) && Objects.equals(room, screening.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, day, startingTime, endingTime, room);
    }
}
