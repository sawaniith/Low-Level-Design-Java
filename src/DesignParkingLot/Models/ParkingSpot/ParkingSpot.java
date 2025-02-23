package DesignParkingLot.Models.ParkingSpot;

import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Strategy.PricingStrategy.PricingStrategy;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

abstract public class ParkingSpot {
    protected int id;
    public boolean isEmpty = true;
    protected Vehicle vehicle;
    private int basePrice;
    private PricingStrategy pricingStrategy;

    public ParkingSpot(int id, int basePrice, PricingStrategy pricingStrategy) {
        this.id = id;
        this.basePrice = basePrice;
        this.pricingStrategy = pricingStrategy;
    }

    public boolean isAvailable() {
        return isEmpty;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public double removeVehicle(Date startTime, Date endTime) {
        this.isEmpty = true;
        long duration = 5;
        double amount = pricingStrategy.calculatePrice(duration, basePrice);
        this.vehicle = null;
        return amount;
    }

    public int getId() {
        return id;
    }
}
