package DesignParkingLot.Models.Gate;

import DesignParkingLot.Models.Ticket;
import DesignParkingLot.PricingStrategy.PricingStrategy;

import java.time.LocalDateTime;
import java.util.Map;

public class ExitGate {
    private final String gateId;
    private final PricingStrategy pricingStrategy;
    private final Map<String, Ticket> ticketStore;

    public ExitGate(String gateId, PricingStrategy strategy, Map<String, Ticket> ticketStore) {
        this.gateId = gateId;
        this.pricingStrategy = strategy;
        this.ticketStore = ticketStore;
    }

    public double exit(String ticketId) {
        Ticket ticket = ticketStore.remove(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid Ticket");

        LocalDateTime exitTime = LocalDateTime.now();
        double fare = pricingStrategy.calculateFare(ticket.entryTime, exitTime);

        ticket.spot.removeVehicle();
        System.out.println("Vehicle exited via " + gateId + ". Fare: " + fare);
        return fare;
    }
}
