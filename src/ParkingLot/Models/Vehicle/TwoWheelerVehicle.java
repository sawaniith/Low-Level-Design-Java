package ParkingLot.Models.Vehicle;

import ParkingLot.Enums.VehicleType;

public class TwoWheelerVehicle extends Vehicle{
    public TwoWheelerVehicle(String regNumber) {
        super(regNumber, VehicleType.TWO_WHEELER);
    }
}
