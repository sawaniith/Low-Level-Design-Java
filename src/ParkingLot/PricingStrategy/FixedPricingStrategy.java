package ParkingLot.PricingStrategy;

import java.time.LocalDateTime;

public class FixedPricingStrategy implements PricingStrategy{
    private final double fixedRate = 10.0;
    @Override
    public double calculateFare(LocalDateTime entry, LocalDateTime exit) {
        return fixedRate;
    }
}
