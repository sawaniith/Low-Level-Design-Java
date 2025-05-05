package ParkingLot.Models;

import ParkingLot.Models.Gate.EntryGate;
import ParkingLot.Models.ParkingSpot.ParkingSpot;
import ParkingLot.Models.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    public String ticketId;
    public Vehicle vehicle;
    public LocalDateTime entryTime;
    public ParkingSpot spot;
    public EntryGate issuedBy;

    public Ticket(String id, Vehicle v, ParkingSpot s, EntryGate p) {
        ticketId = id;
        vehicle = v;
        spot = s;
        issuedBy = p;
        entryTime = LocalDateTime.now();
    }
}
