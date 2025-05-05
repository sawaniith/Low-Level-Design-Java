package ParkingLot.Models;

import ParkingLot.Models.ParkingSpot.ParkingSpot;
import ParkingLot.Models.Vehicle.Vehicle;

import java.util.*;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots = new ArrayList<>();

    public ParkingFloor(int number) {
        this.floorNumber = number;
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {
        return spots.stream()
                .filter(s -> s.isFree && s.parkingSpotType.name().equals(vehicle.vehicleType.name()))
                .findFirst();
    }
}
