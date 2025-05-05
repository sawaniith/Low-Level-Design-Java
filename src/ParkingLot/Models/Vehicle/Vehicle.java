package ParkingLot.Models.Vehicle;

import ParkingLot.Enums.VehicleType;

public abstract class Vehicle {
    public String regNumber;
    public VehicleType vehicleType;

    public Vehicle(String regNumber, VehicleType vehicleType) {
        this.regNumber = regNumber;
        this.vehicleType = vehicleType;
    }
}
