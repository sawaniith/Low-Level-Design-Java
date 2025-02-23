package DesignParkingLot.Strategy.ParkingStrategy;

import DesignParkingLot.Models.ParkingSpot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findBestSpot(List<ParkingSpot> spots);
}
