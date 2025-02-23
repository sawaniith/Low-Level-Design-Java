package DesignParkingLot.Models.ParkingSpot;

import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Strategy.PricingStrategy.PricingStrategy;

public class FwParkingSpot extends ParkingSpot {

    public FwParkingSpot(int id, int basePrice, PricingStrategy pricingStrategy) {
        super(id, basePrice, pricingStrategy);
    }
}
