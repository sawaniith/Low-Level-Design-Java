package RideSharingApplication;

import java.util.List;

public class PreferredVehicleSelectionStrategy implements RideSelectionStrategy {
    public Ride select(List<Ride> rides, String preferredVehicle) {
        return rides.stream().filter(r -> r.vehicle.model.equalsIgnoreCase(preferredVehicle)).findFirst().orElse(null);
    }
}
