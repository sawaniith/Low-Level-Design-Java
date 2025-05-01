package DesignParkingLot.Models.Vehicle;

import DesignParkingLot.Enums.VehicleType;

public class FourWheelerVehicle extends Vehicle{
    public FourWheelerVehicle(String regNumber) {
        super(regNumber, VehicleType.FOUR_WHEELER);
    }
}
