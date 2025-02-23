package DesignParkingLot.Models.ParkingSpotManager;

import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.Vehicle.TwoWheelerVehicle;
import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Strategy.ParkingStrategy.NearestSpotStrategy;
import DesignParkingLot.Strategy.ParkingStrategy.RandomSpotStrategy;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager{
    public TwoWheelerSpotManager(List<ParkingSpot> spots) {
        super(spots, new RandomSpotStrategy());
    }

    @Override
    public boolean isResponsibleFor(Vehicle vehicle) {
        return vehicle instanceof TwoWheelerVehicle;
    }
}
