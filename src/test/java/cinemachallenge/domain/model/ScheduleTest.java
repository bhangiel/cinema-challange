package cinemachallenge.domain.model;

import cinemachallenge.TestConstants;
import cinemachallenge.domain.model.builder.RoomBuilder;
import cinemachallenge.domain.model.builder.ScreeningBuilder;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class ScheduleTest {

    @Test
    void should_schedule_screening() {
        //given
        var schedule = Schedule.emptySchedule(TestConstants.SCHEDULE_ID);
        //when
        var screening = ScreeningBuilder.sample().withStartingTime(TestConstants.SCREENING_STARTING).build();
        var scheduleResult = schedule.schedule(screening);
        //then
        assertThat(schedule.getScreenings()).hasSize(1);
        assertThat(scheduleResult).isEqualTo(ScheduleResult.Scheduled);
    }

    @Test
    void should_not_schedule_screening_due_to_unavailable_room() {
        //given
        var schedule = Schedule.emptySchedule(TestConstants.SCHEDULE_ID);
        var room = RoomBuilder.sample().withAvailable(false).build();
        //when
        var screening = ScreeningBuilder.sample()
                .withRoom(room)
                .withStartingTime(TestConstants.SCREENING_STARTING)
                .build();
        var scheduleResult = schedule.schedule(screening);
        //then
        assertThat(schedule.getScreenings()).isEmpty();
        assertThat(scheduleResult).isEqualTo(ScheduleResult.RoomUnavailable);
    }

    @Test
    void should_not_schedule_screening_while_room_is_already_scheduled_at_given_time_with_one_screening() {
        //given
        var schedule = Schedule.emptySchedule(TestConstants.SCHEDULE_ID);
        var screening = ScreeningBuilder.sample().withStartingTime(TestConstants.SCREENING_STARTING).build();
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
        var screening = ScreeningBuilder.sample().withStartingTime(TestConstants.SCREENING_STARTING).build();
        var screening2 = ScreeningBuilder.sample().withStartingTime(TestConstants.SCREENING_STARTING_2).build();
        schedule.schedule(screening);
        schedule.schedule(screening2);

        //when
        var scheduleTime = LocalTime.of(14, 00);
        var screening3 = ScreeningBuilder.sample().withStartingTime(scheduleTime).build();

        var scheduleResult = schedule.schedule(screening3);
        //then
        assertThat(scheduleResult).isEqualTo(ScheduleResult.RoomUnavailableAtGivenTime);
        assertThat(schedule.getScreenings()).hasSize(2);
    }
}