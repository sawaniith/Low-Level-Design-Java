package ParkingLot.Models.ParkingSpot;

import ParkingLot.Enums.ParkingSpotType;

public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot(String id) {
        super(id, ParkingSpotType.TWO_WHEELER);
    }
}
