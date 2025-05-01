package RideSharingApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideSharingService {
    public Map<String, User> users = new HashMap<>();
    public Map<String, Vehicle> vehicles = new HashMap<>();
    public List<Ride> activeRides = new ArrayList<>();
    public List<Ride> completedRides = new ArrayList<>();

    void addUser(String name, String gender, int age) {
        users.put(name, new User(name, gender, age));
    }

    void addVehicle(String userName, String model, String number) {
        User user = users.get(userName);
        if (user != null) {
            Vehicle vehicle;
            // Infer type from model (you can change this to take explicit input)
            if (model.equalsIgnoreCase("Activa")) {
                vehicle = new Bike(userName, model, number);
            } else {
                vehicle = new Car(userName, model, number);
            }
            user.vehicles.add(vehicle);
            vehicles.put(number, vehicle);
        }
    }

    void offerRide(String userName, String origin, String destination, int availableSeats, String vehicleNumber) {
        Vehicle vehicle = vehicles.get(vehicleNumber);
        if (vehicle == null || !vehicle.ownerName.equals(userName)) {
            System.out.println("Invalid vehicle or owner mismatch");
            return;
        }
        boolean alreadyActive = activeRides.stream().anyMatch(r -> r.vehicle.number.equals(vehicleNumber) && r.isActive);
        if (alreadyActive) {
            System.out.println("Ride already active for this vehicle");
            return;
        }
        Ride ride = new Ride(origin, destination, availableSeats, vehicle, userName);
        activeRides.add(ride);
    }

    void selectRide(String userName, String origin, String destination, int seats, String strategyType, String preferredVehicle) {
        List<Ride> possibleRides = new ArrayList<>();
        for (Ride ride : activeRides) {
            if (ride.isActive && ride.origin.equalsIgnoreCase(origin) && ride.destination.equalsIgnoreCase(destination) && ride.availableSeats >= seats) {
                possibleRides.add(ride);
            }
        }
        RideSelectionStrategy strategy = strategyType.equalsIgnoreCase("Most Vacant") ?
                new MostVacantSelectionStrategy() : new PreferredVehicleSelectionStrategy();
        Ride selectedRide = strategy.select(possibleRides, preferredVehicle);
        if (selectedRide != null) {
            selectedRide.availableSeats -= seats;
            selectedRide.passengers.add(userName);
            users.get(userName).ridesTaken++;
            System.out.println("Ride selected successfully: " + selectedRide.vehicle.model + " (" + selectedRide.vehicle.getType() + ")");
        } else {
            System.out.println("No rides found");
        }
    }

    void endRide(String vehicleNumber) {
        for (Ride ride : activeRides) {
            if (ride.vehicle.number.equals(vehicleNumber) && ride.isActive) {
                ride.isActive = false;
                completedRides.add(ride);
                users.get(ride.driverName).ridesOffered++;
                return;
            }
        }
    }

    void printRideStats() {
        for (User user : users.values()) {
            System.out.println(user.name + ": " + user.ridesTaken + " Taken, " + user.ridesOffered + " Offered");
        }
    }
}
