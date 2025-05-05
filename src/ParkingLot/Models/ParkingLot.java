package ParkingLot.Models;

import ParkingLot.Models.Gate.EntryGate;
import ParkingLot.Models.Gate.ExitGate;
import ParkingLot.Models.ParkingSpot.ParkingSpot;
import ParkingLot.Models.Vehicle.Vehicle;
import ParkingLot.PricingStrategy.PricingStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance = null;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final List<EntryGate> entryGates = new ArrayList<>();
    private final List<ExitGate> exitGates = new ArrayList<>();
    private final Map<String, Ticket> tickets = new ConcurrentHashMap<>();
    private PricingStrategy pricingStrategy;

    private ParkingLot() {}

    public static synchronized ParkingLot getInstance() {
        if (instance == null) instance = new ParkingLot();
        return instance;
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void addEntryGate(String id) {
        entryGates.add(new EntryGate(id, this));
    }

    public void addExitGate(String id) {
        exitGates.add(new ExitGate(id, pricingStrategy, tickets));
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }

    public ParkingSpot assignSpot(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.getAvailableSpot(vehicle);
            if (spot.isPresent()) return spot.get();
        }
        return null;
    }

    public void storeTicket(Ticket ticket) {
        tickets.put(ticket.ticketId, ticket);
    }
}
