package cinemachallenge.domain.model;

public interface RoomAvailability {
    default boolean isAvailable() {
        return true;
    }
}
