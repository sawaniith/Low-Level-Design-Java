package DesignParkingLot.Models.ParkingSpot;

import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Strategy.PricingStrategy.PricingStrategy;

public class TwParkingSpot extends ParkingSpot {

    public TwParkingSpot(int id, int basePrice, PricingStrategy pricingStrategy) {
        super(id, basePrice, pricingStrategy);
    }
}
