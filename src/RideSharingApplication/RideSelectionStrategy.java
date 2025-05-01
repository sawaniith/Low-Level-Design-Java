package RideSharingApplication;

import java.util.List;

public interface RideSelectionStrategy {
    Ride select(List<Ride> rides, String preferredVehicle);
}
