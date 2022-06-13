package cinemachallenge.domain.model;

import cinemachallenge.TestConstants;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ScheduleTest {

    @Test
    void should_schedule_screening() {
        //given
        var schedule = Schedule.emptySchedule(TestConstants.SCHEDULE_ID);
        var movie = new Movie(TestConstants.MOVIE_NAME, TestConstants.MOVIE_DURATION, Set.of(ScreeningType._2D));
        var room = new Room(TestConstants.ROOM_NAME, TestConstants.ROOM_CLEANING_TIME, true);
        //when
        var screening = new Screening(movie, DayOfWeek.MONDAY, TestConstants.SCREENING_STARTING, room);
        var scheduleResult = schedule.schedule(screening);
        //then
        assertThat(schedule.getScreenings()).hasSize(1);
        assertThat(scheduleResult).isEqualTo(ScheduleResult.Scheduled);
    }

    @Test
    void should_not_schedule_screening_due_to_unavailable_room() {
        //given
        var schedule = Schedule.emptySchedule(TestConstants.SCHEDULE_ID);
        var movie = new Movie(TestConstants.MOVIE_NAME, TestConstants.MOVIE_DURATION, Set.of(ScreeningType._2D));
        var room = new Room(TestConstants.ROOM_NAME, TestConstants.ROOM_CLEANING_TIME, false);
        //when
        var screening = new Screening(movie, DayOfWeek.MONDAY, TestConstants.SCREENING_STARTING, room);
        var scheduleResult = schedule.schedule(screening);
        //then
        assertThat(schedule.getScreenings()).isEmpty();
        assertThat(scheduleResult).isEqualTo(ScheduleResult.RoomUnavailable);
    }

    @Test
    void should_not_schedule_screening_while_room_is_already_scheduled_at_given_time_with_one_screening() {
        //given
        var schedule = Schedule.emptySchedule(TestConstants.SCHEDULE_ID);
        var movie = new Movie(TestConstants.MOVIE_NAME, TestConstants.MOVIE_DURATION, Set.of(ScreeningType._2D));
        var room = new Room(TestConstants.ROOM_NAME, TestConstants.ROOM_CLEANING_TIME, true);
        var screening = new Screening(movie, DayOfWeek.MONDAY, TestConstants.SCREENING_STARTING, room);
        schedule.schedule(screening);

        //when
        var scheduleResult = schedule.schedule(screening);
        //then
        assertThat(scheduleResult).isEqualTo(ScheduleResult.RoomUnavailableAtGivenTime);
        assertThat(schedule.getScreenings()).hasSize(1);
    }

    @Test
    void should_not_schedule_screening_while_room_is_already_scheduled_at_given_time_with_two_screenings_in_one_room() {
        //given
        var schedule = Schedule.emptySchedule(TestConstants.SCHEDULE_ID);
        var movie = new Movie(TestConstants.MOVIE_NAME, TestConstants.MOVIE_DURATION, Set.of(ScreeningType._2D));
        var room = new Room(TestConstants.ROOM_NAME, TestConstants.ROOM_CLEANING_TIME, true);
        var screening = new Screening(movie, DayOfWeek.MONDAY, TestConstants.SCREENING_STARTING, room);
        var screening2 = new Screening(movie, DayOfWeek.MONDAY, TestConstants.SCREENING_STARTING_2, room);
        schedule.schedule(screening);
        schedule.schedule(screening2);

        //when
        var scheduleTime = LocalTime.of(14, 00);
        var screening3 = new Screening(movie, DayOfWeek.MONDAY, scheduleTime, room);
        var scheduleResult = schedule.schedule(screening3);
        //then
        assertThat(scheduleResult).isEqualTo(ScheduleResult.RoomUnavailableAtGivenTime);
        assertThat(schedule.getScreenings()).hasSize(2);
    }
}