package DesignParkingLot.Models.Gate;

import DesignParkingLot.Models.ParkingLot;
import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.Ticket;
import DesignParkingLot.Models.Vehicle.Vehicle;

import java.util.UUID;

public class EntryGate extends Gate{

    public EntryGate(int gateId, ParkingLot parkingLot) {
        super(gateId, parkingLot);
    }

    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot spot = parkingLot.findAndAssignSpot(vehicle);
        if (spot != null) {
            spot.parkVehicle(vehicle);
            return new Ticket(UUID.randomUUID().toString(), vehicle, spot);
        }
        return null;
    }

    public int getspotscnt(){
        return parkingLot.getSpotsCount();
    }
}
