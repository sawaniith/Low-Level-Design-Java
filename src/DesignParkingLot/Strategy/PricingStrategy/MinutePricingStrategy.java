package DesignParkingLot.Strategy.PricingStrategy;

public class MinutePricingStrategy implements PricingStrategy{
    @Override
    public int calculatePrice(long duration, int basePrice) {
        return (int) (duration * basePrice);  // ₹X per minute
    }
}
