package DesignParkingLot.Strategy.PricingStrategy;

public interface PricingStrategy {
    int calculatePrice(long duration, int basePrice);
}
