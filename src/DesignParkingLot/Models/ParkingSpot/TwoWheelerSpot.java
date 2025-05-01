package DesignParkingLot.Models.ParkingSpot;

import DesignParkingLot.Enums.ParkingSpotType;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(String id) {
        super(id, ParkingSpotType.FOUR_WHEELER);
    }
}
