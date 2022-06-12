package cinemachallenge.api;

import cinemachallenge.api.model.ScheduleRequest;
import cinemachallenge.api.model.ScheduleResponse;
import cinemachallenge.application.ScheduleService;
import org.springframework.stereotype.Component;

@Component
public class ScheduleFacade {
    private final ScheduleService scheduleService;

    public ScheduleFacade(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public ScheduleResponse schedule(ScheduleRequest scheduleRequest) {
        return scheduleService.schedule(scheduleRequest);
    }

}
