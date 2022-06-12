package cinemachallenge;

import cinemachallenge.api.ScheduleFacade;
import cinemachallenge.application.ScheduleService;
import cinemachallenge.domain.model.Schedule;
import cinemachallenge.domain.model.converter.ScreeningRequestToScreeningConverter;
import cinemachallenge.domain.repository.ScheduleRepository;
import cinemachallenge.domain.repository.ScreeningRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.core.convert.ConversionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegrationBaseTest {
    public ScheduleFacade scheduleFacade;
    public ScheduleService scheduleService;
    public ScheduleRepository scheduleRepository;
    public ScreeningRepository screeningRepository;
    public ConversionService conversionService;

    @BeforeAll
    void beforeAll() {
        this.scheduleRepository = new TestScheduleRepository();
        var testConversionService = new ApplicationConversionService();
        testConversionService.addConverter(new ScreeningRequestToScreeningConverter());
        this.conversionService = testConversionService;

        var scheduleService = new ScheduleService(scheduleRepository, this.conversionService);
        this.scheduleFacade = new ScheduleFacade(scheduleService);
    }

    private class TestScheduleRepository implements ScheduleRepository {
        private List<Schedule> schedules = new ArrayList<>();

        @Override
        public Schedule create(Schedule schedule) {
            schedules.add(schedule);
            return schedule;
        }

        @Override
        public Optional<Schedule> findById(String id) {
            return schedules.stream()
                    .filter(schedule -> schedule.getId().equals(id))
                    .findFirst();
        }
    }
}
