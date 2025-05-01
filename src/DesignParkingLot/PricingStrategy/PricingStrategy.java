package DesignParkingLot.PricingStrategy;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculateFare(LocalDateTime entry, LocalDateTime exit);
}
