package ParkingLot.Models.ParkingSpot;

import ParkingLot.Enums.ParkingSpotType;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(String id) {
        super(id, ParkingSpotType.FOUR_WHEELER);
    }
}
