package DesignParkingLot.Models.ParkingSpotManager;

import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.Vehicle.FourWheelerVehicle;
import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Strategy.ParkingStrategy.NearestSpotStrategy;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager{
    public FourWheelerSpotManager(List<ParkingSpot> spots) {
        super(spots, new NearestSpotStrategy());
    }

    @Override
    public boolean isResponsibleFor(Vehicle vehicle) {
        return vehicle instanceof FourWheelerVehicle;
    }

}
