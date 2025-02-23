package DesignParkingLot.Strategy.ParkingStrategy;

import DesignParkingLot.Models.ParkingSpot.ParkingSpot;

import java.util.List;
import java.util.Random;

public class RandomSpotStrategy implements ParkingStrategy{
    private final Random random = new Random();

    @Override
    public ParkingSpot findBestSpot(List<ParkingSpot> spots) {
        List<ParkingSpot> availableSpots = spots.stream().filter(ParkingSpot::isAvailable).toList();
        if (availableSpots.isEmpty()) return null;
        return availableSpots.get(random.nextInt(availableSpots.size()));
    }
}
