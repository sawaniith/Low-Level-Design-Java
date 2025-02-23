package DesignParkingLot.Models.ParkingSpotManager;

import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Strategy.ParkingStrategy.ParkingStrategy;

import java.util.List;

public abstract class ParkingSpotManager {
    protected List<ParkingSpot> spots;
    protected ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> spots, ParkingStrategy parkingStrategy) {
        this.spots = spots;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot findAvailableSpot() {
        return parkingStrategy.findBestSpot(spots);
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public int freeSpots() {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty) {
                count++;
            }
        }
        return count;
    }

    public abstract boolean isResponsibleFor(Vehicle vehicle);
}
