package cinemachallenge.domain.model;

import java.time.Duration;
import java.util.Set;

public class Movie {
    private String name;

    private Duration runningTime;
    private Set<ScreeningType> screeningType;

    public Movie(String name, Duration runningTime, Set<ScreeningType> screeningType) {
        this.name = name;
        this.runningTime = runningTime;
        this.screeningType = screeningType;
    }

    public Duration getRunningTime() {
        return runningTime;
    }
}
