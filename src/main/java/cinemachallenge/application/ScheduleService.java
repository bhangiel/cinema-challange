package cinemachallenge.application;

import cinemachallenge.api.model.ScheduleRequest;
import cinemachallenge.api.model.ScheduleResponse;
import cinemachallenge.domain.exception.DomainException;
import cinemachallenge.domain.exception.ExceptionCode;
import cinemachallenge.domain.model.Screening;
import cinemachallenge.domain.repository.ScheduleRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ConversionService conversionService;

    public ScheduleService(ScheduleRepository screeningRepository, ConversionService conversionService) {
        this.scheduleRepository = screeningRepository;
        this.conversionService = conversionService;
    }

    public ScheduleResponse schedule(ScheduleRequest request) {
        var schedule = scheduleRepository.findById(request.id()).orElseThrow(() -> new DomainException(ExceptionCode.SCHEDULE_NOT_FOUND, request.id()));
        var screening = conversionService.convert(request.screening(), Screening.class);
        var scheduleResult = schedule.schedule(screening);
        return new ScheduleResponse(scheduleResult.name());
    }
}
