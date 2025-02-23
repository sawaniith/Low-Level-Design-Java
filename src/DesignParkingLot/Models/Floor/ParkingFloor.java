package DesignParkingLot.Models.Floor;

import DesignParkingLot.Enums.VehicleType;
import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.ParkingSpotManager.ParkingSpotManager;
import DesignParkingLot.Models.Vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpotManager> spotManagers;

    public ParkingFloor(int floorNumber, List<ParkingSpotManager> spotManagers) {
        this.floorNumber = floorNumber;
        this.spotManagers = spotManagers;
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        for (ParkingSpotManager manager : spotManagers) {
            if (manager.isResponsibleFor(vehicle)) {
                return manager.findAvailableSpot();
            }
        }
        return null;
    }

    public int countSpot() {
        int count = 0;
        for (ParkingSpotManager manager : spotManagers) {
            count += manager.freeSpots();
        }
        return count;
    }
}
