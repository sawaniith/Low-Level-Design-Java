package ParkingLot.Models.Gate;

import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.ParkingSpot.ParkingSpot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle.Vehicle;

import java.util.UUID;

public class EntryGate {
    private final String gateId;
    private final ParkingLot parkingLot;

    public EntryGate(String gateId, ParkingLot lot) {
        this.gateId = gateId;
        this.parkingLot = lot;
    }

    public Ticket enter(Vehicle vehicle) {
        ParkingSpot spot = parkingLot.assignSpot(vehicle);
        if (spot == null || !spot.assignVehicle(vehicle)) return null;
        String ticketId = UUID.randomUUID().toString();
        return new Ticket(ticketId, vehicle, spot, this);
    }
}
