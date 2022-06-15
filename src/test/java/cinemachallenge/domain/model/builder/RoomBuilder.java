package cinemachallenge.domain.model.builder;

import cinemachallenge.TestConstants;
import cinemachallenge.domain.model.Room;
import java.time.Duration;

public class RoomBuilder {
    public static RoomBuilder sample() {
        return new RoomBuilder()
                .withName(TestConstants.ROOM_NAME)
                .withCleaningTime(TestConstants.ROOM_CLEANING_TIME)
                .withAvailable(true);
    }

    private String name;
    private Duration cleaningTime;
    private Boolean available;

    public Room build() {
        return new Room(this.name, this.cleaningTime, this.available);

    }

    public RoomBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RoomBuilder withCleaningTime(Duration cleaningTime) {
        this.cleaningTime = cleaningTime;
        return this;
    }

    public RoomBuilder withAvailable(Boolean available) {
        this.available = available;
        return this;
    }
}
