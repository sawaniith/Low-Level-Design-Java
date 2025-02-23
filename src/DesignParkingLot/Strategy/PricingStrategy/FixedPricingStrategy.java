package DesignParkingLot.Strategy.PricingStrategy;

public class FixedPricingStrategy implements PricingStrategy{
    @Override
    public int calculatePrice(long duration, int basePrice) {
        return basePrice;
    }
}
