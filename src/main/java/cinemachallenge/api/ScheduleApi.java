package cinemachallenge.api;

import cinemachallenge.api.model.ScheduleRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleApi {
    private final ScheduleFacade scheduleFacade;

    public ScheduleApi(ScheduleFacade scheduleFacade) {
        this.scheduleFacade = scheduleFacade;
    }

    public void scheduleMovie(ScheduleRequest scheduleRequest) {
        scheduleFacade.schedule(scheduleRequest);
    }
}
