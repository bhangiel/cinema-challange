package cinemachallenge.domain.model.builder;

import cinemachallenge.TestConstants;
import cinemachallenge.domain.model.Movie;
import cinemachallenge.domain.model.ScreeningType;
import java.time.Duration;
import java.util.Set;

public class MovieBuilder {
    public static MovieBuilder sample() {
        return new MovieBuilder()
                .withName(TestConstants.MOVIE_NAME)
                .withRunningTime(TestConstants.MOVIE_DURATION)
                .withScreeningType(TestConstants.SCREENING_TYPES);
    }

    private String name;
    private Duration runningTime;
    private Set<ScreeningType> screeningTypes;

    public Movie build() {
        return new Movie(this.name, this.runningTime, this.screeningTypes);
    }

    public MovieBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MovieBuilder withRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
        return this;
    }

    public MovieBuilder withScreeningType(Set<ScreeningType> screeningTypes) {
        this.screeningTypes = screeningTypes;
        return this;
    }
}
