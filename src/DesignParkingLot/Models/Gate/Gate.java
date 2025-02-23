package DesignParkingLot.Models.Gate;

import DesignParkingLot.Models.ParkingLot;
import DesignParkingLot.Models.Ticket;
import DesignParkingLot.Models.Vehicle.Vehicle;

public abstract class Gate {
    protected int gateId;
    public ParkingLot parkingLot;

    public Gate(int gateId, ParkingLot parkingLot) {
        this.gateId = gateId;
        this.parkingLot = parkingLot;
    }

    public int getGateId() {
        return gateId;
    }

//    public abstract Ticket generateTicket(Vehicle vehicle);
}
