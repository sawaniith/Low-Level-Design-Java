package DesignParkingLot.Models.ParkingSpot;

import DesignParkingLot.Enums.ParkingSpotType;
import DesignParkingLot.Models.Vehicle.Vehicle;

abstract public class ParkingSpot {
    public String id;
    public boolean isFree;
    public Vehicle vehicle;
    public ParkingSpotType parkingSpotType;

    public ParkingSpot(String id, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.isFree = true;
        this.parkingSpotType = parkingSpotType;
    }

    public synchronized boolean assignVehicle(Vehicle v) {
        if (!isFree) return false;
        this.vehicle = v;
        this.isFree = false;
        return true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
    }
}
