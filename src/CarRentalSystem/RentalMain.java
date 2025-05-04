package CarRentalSystem;

import java.time.LocalDate;
import java.util.List;

public class RentalMain {
    public static void main(String[] args) {
        VehicleRentalSystem rentalSystem = VehicleRentalSystem.getInstance();

        // Create some branches with Indian cities
        Branch branchBengaluru = new Branch("B1", "Bengaluru");
        Branch branchDelhi = new Branch("B2", "Delhi");
        Branch branchMumbai = new Branch("B3", "Mumbai");

        rentalSystem.addBranch(branchBengaluru);
        rentalSystem.addBranch(branchDelhi);
        rentalSystem.addBranch(branchMumbai);

        rentalSystem.addCar("Bengaluru", new Car("C1", "Toyota Corolla", "ABC123", 500.0));
        rentalSystem.addCar("Bengaluru", new Car("C2", "Honda Civic", "XYZ456", 600.0));

        Customer customer = new Customer("U1", "Sawan", "sawan@example.com", "8876543210", "DRIVE100");

        // Define the booking dates
        LocalDate startDate = LocalDate.of(2025, 5, 5);
        LocalDate endDate = LocalDate.of(2025, 5, 7);

        // Store search results in Main class
        System.out.println("\nSearching for available cars in Bengaluru...");
        List<Car> availableCarsBengaluru = rentalSystem.searchVehicles("Bengaluru", startDate, endDate);
        availableCarsBengaluru.forEach(car ->
                System.out.println("Available car: " + car.model)
        );

        // Try making a booking for a car in Bengaluru
        if (!availableCarsBengaluru.isEmpty()) {
            System.out.println("\nMaking a booking for Toyota Corolla...");
            Booking booking1 = rentalSystem.makeBooking(customer, availableCarsBengaluru.get(0), startDate, endDate);
            System.out.println("Booking successful: " + booking1.getBookingId());
            booking1.setBookingStatus(BookingStatus.COMPLETED);
            LocalDate startDate2 = LocalDate.of(2025, 5, 8);
            LocalDate endDate2 = LocalDate.of(2025, 5, 10);

            // Try searching again in Bengaluru for the same dates (should show no available cars)
            System.out.println("\nSearching for available cars in Bengaluru after booking...");
            List<Car> availableCarsAfterBooking = rentalSystem.searchVehicles("Bengaluru", startDate2, endDate2);
            availableCarsAfterBooking.forEach(car ->
                    System.out.println("Available car: " + car.model)
            );
        }else{
            System.out.println("No Cars Available");
        }

        // Cancel the booking
//        if (booking != null) {
//            System.out.println("\nCanceling the booking...");
//            rentalSystem.cancelBooking(booking.getBookingId());
//        }

        // Try to cancel a non-existing booking
//        System.out.println("\nTrying to cancel a non-existing booking...");
//        rentalSystem.cancelBooking("NONEXISTING123");
    }
}
