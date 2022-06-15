package cinemachallenge.domain.model;

import java.time.Duration;
import java.util.Set;

public class Movie {
    private String name;
    private Duration runningTime;
    private Set<ScreeningType> screeningTypes;

    public Movie(String name, Duration runningTime, Set<ScreeningType> screeningTypes) {
        this.name = name;
        this.runningTime = runningTime;
        this.screeningTypes = screeningTypes;
    }

    public Duration getRunningTime() {
        return runningTime;
    }
}
