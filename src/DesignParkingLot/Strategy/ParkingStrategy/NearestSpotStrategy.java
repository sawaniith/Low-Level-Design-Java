package DesignParkingLot.Strategy.ParkingStrategy;

import DesignParkingLot.Models.ParkingSpot.ParkingSpot;

import java.util.List;

public class NearestSpotStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findBestSpot(List<ParkingSpot> spots) {
        return spots.stream().filter(ParkingSpot::isAvailable).findFirst().orElse(null);
    }
}
