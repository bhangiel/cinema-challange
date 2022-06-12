package cinemachallenge.api;

import cinemachallenge.IntegrationBaseTest;
import cinemachallenge.TestConstants;
import cinemachallenge.api.model.Movie;
import cinemachallenge.api.model.Room;
import cinemachallenge.api.model.ScheduleRequest;
import cinemachallenge.api.model.Screening;
import cinemachallenge.domain.model.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

class ScheduleFacadeTest extends IntegrationBaseTest {
    @BeforeEach
    void setUp() {
        this.scheduleRepository.create(Schedule.emptySchedule(TestConstants.SCHEDULE_ID));
    }

    @Test
    void should_return_scheduled_result() {
        //given
        var movie = new Movie(TestConstants.MOVIE_NAME, TestConstants.MOVIE_DURATION.toMinutes());
        var room = new Room(TestConstants.ROOM_NAME);
        var screening = new Screening(movie, room, DayOfWeek.MONDAY, TestConstants.SCREENING_STARTING);
        //when
        var scheduleResponse = this.scheduleFacade.schedule(new ScheduleRequest(TestConstants.SCHEDULE_ID, screening));
        //then
        assertThat(scheduleResponse.result()).isEqualTo("Scheduled");
    }
}