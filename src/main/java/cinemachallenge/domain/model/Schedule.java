package cinemachallenge.domain.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Objects.isNull;

public class Schedule {
    public static Schedule emptySchedule(String id) {
        return new Schedule(id, new ArrayList<>());
    }

    private String id;

    private List<Screening> screenings;

    private Schedule(String id, List<Screening> screenings) {
        this.id = id;
        this.screenings = screenings;
    }

    public ScheduleResult schedule(Screening screening) {
        var room = screening.room();
        if (!room.isAvailable()) {
            return ScheduleResult.RoomUnavailable;
        }

        if (this.isRoomScheduledAt(room, screening.day(), screening.startingTime())) {
            return ScheduleResult.RoomUnavailableAtGivenTime;
        }
        this.screenings.add(screening);
        return ScheduleResult.Scheduled;
    }

    private boolean isRoomScheduledAt(Room room, DayOfWeek day, LocalTime time) {
        if (this.screenings.isEmpty()) {
            return false;
        }
        var sortedScreenings = this.screenings.stream()
                .filter(screening -> screening.room().equals(room) && screening.day().equals(day))
                .sorted(Comparator.comparing(Screening::roomAvailableTime))
                .toList();

        return IntStream
                .range(0, sortedScreenings.size())
                .anyMatch(i -> timeDoesNotMatchSlotBetweenScreenings(time, sortedScreenings.get(i), i + 1 < sortedScreenings.size() ? sortedScreenings.get(i + 1) : null));
    }

    private boolean timeDoesNotMatchSlotBetweenScreenings(LocalTime time, Screening screening1, Screening screening2) {
        if (isNull(screening2)) {
            return !time.isBefore(screening1.startingTime()) && time.isBefore(screening1.roomAvailableTime());
        } else {
            return time.isAfter(screening1.startingTime()) && time.isBefore(screening1.roomAvailableTime())
                    || !time.isAfter(screening2.startingTime()) && time.isBefore(screening2.roomAvailableTime());
        }
    }

    public List<Screening> getScreenings() {
        return Collections.unmodifiableList(screenings);
    }

    public String getId() {
        return id;
    }
}
