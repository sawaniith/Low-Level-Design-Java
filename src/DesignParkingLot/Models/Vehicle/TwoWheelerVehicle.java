package DesignParkingLot.Models.Vehicle;

import DesignParkingLot.Enums.VehicleType;

public class TwoWheelerVehicle extends Vehicle{
    public TwoWheelerVehicle(String regNumber) {
        super(regNumber, VehicleType.TWO_WHEELER);
    }
}
