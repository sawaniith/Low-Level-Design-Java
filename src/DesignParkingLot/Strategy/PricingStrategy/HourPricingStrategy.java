package DesignParkingLot.Strategy.PricingStrategy;

public class HourPricingStrategy implements PricingStrategy{
    @Override
    public int calculatePrice(long duration, int basePrice) {
        return ((int) Math.ceil(duration / 60.0)) * basePrice;  // ₹X per hour
    }
}
