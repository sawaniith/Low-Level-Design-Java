package DesignParkingLot.Models.ParkingSpot;

import DesignParkingLot.Enums.ParkingSpotType;

public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot(String id) {
        super(id, ParkingSpotType.TWO_WHEELER);
    }
}
