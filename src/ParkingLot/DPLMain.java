package ParkingLot;

import ParkingLot.Models.Gate.EntryGate;
import ParkingLot.Models.Gate.ExitGate;
import ParkingLot.Models.ParkingFloor;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.ParkingSpot.FourWheelerSpot;
import ParkingLot.Models.ParkingSpot.TwoWheelerSpot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle.FourWheelerVehicle;
import ParkingLot.Models.Vehicle.TwoWheelerVehicle;
import ParkingLot.Models.Vehicle.Vehicle;
import ParkingLot.PricingStrategy.HourlyPricingStrategy;

public class DPLMain {
    public static void main(String[] args) throws InterruptedException{
        ParkingLot lot = ParkingLot.getInstance();
        lot.setPricingStrategy(new HourlyPricingStrategy(30.0));

        ParkingFloor floor = new ParkingFloor(0);
        floor.addSpot(new TwoWheelerSpot("TW1"));
        floor.addSpot(new FourWheelerSpot("FW1"));
        lot.addFloor(floor);

        lot.addEntryGate("E1");
        lot.addEntryGate("E2");
        lot.addExitGate("X1");

        EntryGate e1 = lot.getEntryGates().get(0);
        EntryGate e2 = lot.getEntryGates().get(1);
        ExitGate x1 = lot.getExitGates().get(0);

        Vehicle bike = new TwoWheelerVehicle("KA01");
        Vehicle car = new FourWheelerVehicle("KA02");
        Vehicle car2 = new FourWheelerVehicle("KA03");

        Thread t1 = new Thread(() -> {
            Ticket t = e1.enter(car2);
            if (t != null) {
                lot.storeTicket(t);
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                x1.exit(t.ticketId);
            }else{
                System.out.println("no available");
            }
        });

        Thread t2 = new Thread(() -> {
            Ticket t = e2.enter(car);
            if (t != null) {
                lot.storeTicket(t);
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                x1.exit(t.ticketId);
            }else{
                System.out.println("no available");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
