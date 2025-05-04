package CarRentalSystem;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class VehicleRentalSystem {
    private static VehicleRentalSystem instance;
    private final Map<String, Branch> branches;
    private final Map<String, Booking> bookings;

    private VehicleRentalSystem() {
        branches = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
    }

    public static synchronized VehicleRentalSystem getInstance() {
        if (instance == null) {
            instance = new VehicleRentalSystem();
        }
        return instance;
    }

    public void addBranch(Branch branch) {
        branches.put(branch.getBranchCity().toLowerCase(), branch);
    }

    public void addCar(String branchCity, Car car) {
        Branch branch = branches.get(branchCity.toLowerCase());
        if (branch == null) {
            System.out.println("Branch not available: " + branchCity);
        }else {
            branch.addCar(car);
            System.out.println("Car [" + car.model + "] added to branch: " + branchCity);
        }
    }

    public List<Car> searchVehicles(String branchCity, LocalDate startDate, LocalDate endDate) {
        Branch branch = branches.get(branchCity.toLowerCase());
        if (branch == null) {
            System.out.println("City not serviceable: " + branchCity);
            return List.of();
        }
        // Filter available cars for the specified dates
        return branch.getAvailableVehicles().stream()
                .filter(car -> isCarAvailable(car, startDate, endDate)) // Check availability
                .collect(Collectors.toList());
    }

    // Check if the car is available for the given date range
    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Booking booking : bookings.values()) {
            if (booking.getCar().equals(car)) {
                if (!(endDate.isBefore(booking.getStartDate()) || startDate.isAfter(booking.getEndDate()))) {
                    return false;  // Car is not available if there's an overlap
                }
            }
        }
        return true;  // Car is available if no overlap is found
    }

    // Make a booking if the car is available
    public synchronized Booking makeBooking(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if (isCarAvailable(car, startDate, endDate)) {
            String bookingId = generateBookingId();
            Booking booking = new Booking(bookingId, customer, car, startDate, endDate);
            bookings.put(bookingId, booking);
            car.setCarStatus(CarStatus.BOOKED); // Update car status to booked
            return booking;
        } else {
            System.out.println("Car [" + car.model + "] is not available for the selected dates.");
            return null;  // Return null if car is not available
        }
    }

    // Cancel a booking by booking ID
    public synchronized void cancelBooking(String bookingId) {
        Booking booking = bookings.remove(bookingId);
        if (booking != null) {
            Car car = booking.getCar();
            car.setCarStatus(CarStatus.AVAILABLE); // Update car status to available
            System.out.println("Booking " + bookingId + " has been canceled successfully.");
        } else {
            System.out.println("No booking found with ID: " + bookingId);
        }
    }

    // Method to generate a unique booking ID
    private String generateBookingId() {
        return "BOOK" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
