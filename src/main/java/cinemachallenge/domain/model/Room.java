package cinemachallenge.domain.model;

import java.time.Duration;

public class Room implements RoomAvailability {
    String name;
    Duration cleaningTime;
    Boolean available;

    public Room(String name, Duration cleaningTimen, boolean available) {
        this.name = name;
        this.cleaningTime = cleaningTime;
        this.available = available;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }
}
