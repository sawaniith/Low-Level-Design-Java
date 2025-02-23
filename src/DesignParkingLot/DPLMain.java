package DesignParkingLot;

import DesignParkingLot.Enums.VehicleType;
import DesignParkingLot.Factory.VehicleFactory;
import DesignParkingLot.Models.Floor.ParkingFloor;
import DesignParkingLot.Models.Gate.EntryGate;
import DesignParkingLot.Models.Gate.ExitGate;
import DesignParkingLot.Models.ParkingLot;
import DesignParkingLot.Models.ParkingSpot.FwParkingSpot;
import DesignParkingLot.Models.ParkingSpot.ParkingSpot;
import DesignParkingLot.Models.ParkingSpot.TwParkingSpot;
import DesignParkingLot.Models.ParkingSpotManager.FourWheelerSpotManager;
import DesignParkingLot.Models.ParkingSpotManager.ParkingSpotManager;
import DesignParkingLot.Models.ParkingSpotManager.TwoWheelerSpotManager;
import DesignParkingLot.Models.Ticket;
import DesignParkingLot.Models.Vehicle.FourWheelerVehicle;
import DesignParkingLot.Models.Vehicle.TwoWheelerVehicle;
import DesignParkingLot.Models.Vehicle.Vehicle;
import DesignParkingLot.Strategy.PricingStrategy.FixedPricingStrategy;
import DesignParkingLot.Strategy.PricingStrategy.MinutePricingStrategy;

import java.util.List;

public class DPLMain {
    public static void main(String[] args) {
        List<ParkingSpot> twoWheelerSpots = List.of(new TwParkingSpot(1, 20, new FixedPricingStrategy()), new TwParkingSpot(2, 30, new MinutePricingStrategy()));
        List<ParkingSpot> fourWheelerSpots = List.of(new FwParkingSpot(3, 40, new FixedPricingStrategy()), new FwParkingSpot(3, 50, new MinutePricingStrategy()));

        ParkingSpotManager twoWheelerManager = new TwoWheelerSpotManager(twoWheelerSpots);
        ParkingSpotManager fourWheelerManager = new FourWheelerSpotManager(fourWheelerSpots);
        List<ParkingSpotManager> managers = List.of(twoWheelerManager, fourWheelerManager);
        List<ParkingFloor> floors = List.of(new ParkingFloor(1, managers));
        ParkingLot parkingLot = new ParkingLot(floors);
        EntryGate entryGate = new EntryGate(1, parkingLot);

        Vehicle tw = VehicleFactory.getVehicle(VehicleType.TWO_WHEELER, "KA019876");
        Vehicle car = VehicleFactory.getVehicle(VehicleType.FOUR_WHEELER, "KA-05-C-5678");
        Vehicle car2 = VehicleFactory.getVehicle(VehicleType.FOUR_WHEELER, "KA-05-C-5670");
        Ticket bikeTicket = entryGate.generateTicket(tw);
        Ticket carTicket = entryGate.generateTicket(car);
        Ticket carTicket2 = entryGate.generateTicket(car2);

        System.out.println(entryGate.getspotscnt());

    }
}
