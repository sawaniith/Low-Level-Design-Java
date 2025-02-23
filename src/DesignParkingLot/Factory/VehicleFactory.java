package DesignParkingLot.Factory;

import DesignParkingLot.Models.Vehicle.FourWheelerVehicle;
import DesignParkingLot.Models.Vehicle.TwoWheelerVehicle;
import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Enums.VehicleType;

public class VehicleFactory {
    public static Vehicle getVehicle(VehicleType vehicleType, String regNumber) {
        return switch (vehicleType) {
            case VehicleType.TWO_WHEELER -> new TwoWheelerVehicle(regNumber, vehicleType);
            case VehicleType.FOUR_WHEELER -> new FourWheelerVehicle(regNumber, vehicleType);
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }
}
