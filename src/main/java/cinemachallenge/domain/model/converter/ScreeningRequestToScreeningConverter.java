package cinemachallenge.domain.model.converter;

import cinemachallenge.domain.model.Movie;
import cinemachallenge.domain.model.Room;
import cinemachallenge.domain.model.Screening;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.util.Collections;

@Component
public class ScreeningRequestToScreeningConverter implements Converter<cinemachallenge.api.model.Screening, Screening> {

    @Override
    public Screening convert(cinemachallenge.api.model.Screening source) {
        var movie = new Movie(source.movie().name(), Duration.ofMinutes(source.movie().durationInMin()), Collections.emptySet());
        var room = new Room(source.room().name(), null, true);
        return new Screening(movie, source.day(), source.startingTime(), room);
    }
}
