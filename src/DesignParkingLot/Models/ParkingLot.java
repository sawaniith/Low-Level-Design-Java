package DesignParkingLot.Models;

import DesignParkingLot.Models.Floor.ParkingFloor;
import DesignParkingLot.Models.Gate.EntryGate;
import DesignParkingLot.Models.Gate.ExitGate;
import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.Vehicle.Vehicle;

import java.util.Date;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public ParkingSpot findAndAssignSpot(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findSpot(vehicle);
            if (spot != null) {
                return spot; // Spot found, return it
            }
        }
        System.out.println("Parking is Full");
        return null; // No spot available
    }

    public int getSpotsCount(){
        int count=0;
        for (ParkingFloor floor : floors) {
            count += floor.countSpot();
        }
        return count;
    }

    public void freeSpot(ParkingSpot spot, Date startTime, Date endTime) {
        spot.removeVehicle(startTime, endTime);
    }
}
