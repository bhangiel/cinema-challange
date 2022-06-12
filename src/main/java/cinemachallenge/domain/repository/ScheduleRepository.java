package cinemachallenge.domain.repository;

import cinemachallenge.domain.model.Schedule;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule create(Schedule schedule);

    Optional<Schedule> findById(String id);
}
