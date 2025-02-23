package DesignParkingLot.Models;

import DesignParkingLot.Enums.ParkingSpotType;

import java.util.HashMap;
import java.util.Map;

class ParkingDisplayBoard {
    private Map<ParkingSpotType, Integer> freeSpotsAvailableMap = new HashMap<>();

    public void updateFreeSpots(ParkingSpotType type, int spaces) {
        freeSpotsAvailableMap.put(type, spaces);
        display();
    }

    public void display() {
        System.out.println("Parking spot availability: " + freeSpotsAvailableMap);
    }
}
