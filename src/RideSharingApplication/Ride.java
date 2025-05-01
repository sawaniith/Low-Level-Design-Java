package RideSharingApplication;

import java.util.ArrayList;
import java.util.List;

public class Ride {
    public String origin;
    public String destination;
    public int availableSeats;
    public Vehicle vehicle;
    public String driverName;
    public List<String> passengers = new ArrayList<>();
    public boolean isActive = true;

    Ride(String origin, String destination, int availableSeats, Vehicle vehicle, String driverName) {
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.vehicle = vehicle;
        this.driverName = driverName;
    }
}
