package RideSharingApplication;

import java.util.Comparator;
import java.util.List;

public class MostVacantSelectionStrategy implements RideSelectionStrategy {
    public Ride select(List<Ride> rides, String preferredVehicle) {
        return rides.stream().max(Comparator.comparingInt(r -> r.availableSeats)).orElse(null);
    }
}
