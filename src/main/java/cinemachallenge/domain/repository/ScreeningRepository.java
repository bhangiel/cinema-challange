package cinemachallenge.domain.repository;

import cinemachallenge.domain.model.Schedule;

public interface ScreeningRepository {
    Schedule create(Schedule schedule);
}
