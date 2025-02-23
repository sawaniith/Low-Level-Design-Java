package DesignParkingLot.Models;

import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.Vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private String ticketId;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private Date startTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.startTime = new Date();
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getStartTime() {
        return startTime;
    }
}
