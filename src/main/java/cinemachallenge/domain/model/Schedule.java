package cinemachallenge.domain.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private boolean isRoomScheduledAt(Room room, DayOfWeek day, LocalTime time) {
        return false;
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

    public List<Screening> getScreenings() {
        return Collections.unmodifiableList(screenings);
    }

    public String getId() {
        return id;
    }
}
