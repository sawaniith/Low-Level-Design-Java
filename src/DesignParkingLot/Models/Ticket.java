package DesignParkingLot.Models;

import DesignParkingLot.Models.Gate.EntryGate;
import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.Vehicle.Vehicle;

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
