package DesignParkingLot.Models.Vehicle;

import DesignParkingLot.Enums.VehicleType;

public abstract class Vehicle {
    protected String regNumber;
    protected VehicleType vehicleType;

    public Vehicle(String regNumber, VehicleType vehicleType) {
        this.regNumber = regNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
}
