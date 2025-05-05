package ParkingLot.PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy {
    private final double hourlyRate;

    public HourlyPricingStrategy(double rate) {
        this.hourlyRate = rate;
    }

    @Override
    public double calculateFare(LocalDateTime entry, LocalDateTime exit) {
        long minutes = Duration.between(entry, exit).toMinutes();
        double hours = Math.ceil(minutes / 60.0);
        if (hours == 0) hours = 1; // Minimum charge
        return hours * hourlyRate;
    }
}
