package cinemachallenge.domain.model;

import java.time.Duration;
import java.util.Objects;

public class Room implements RoomAvailability {
    private String name;
    private Duration cleaningTime;
    private Boolean available;

    public Room(String name, Duration cleaningTime, boolean available) {
        this.name = name;
        this.cleaningTime = cleaningTime;
        this.available = available;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public Duration cleaningTime() {
        return cleaningTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) && Objects.equals(cleaningTime, room.cleaningTime) && Objects.equals(available, room.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cleaningTime, available);
    }
}
