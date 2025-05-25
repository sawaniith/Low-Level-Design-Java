package AirlineManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookingManager {
    private static BookingManager instance;
    private final Map<String, Booking> bookings;

    private BookingManager() {
        bookings = new HashMap<>();
    }

    public static synchronized BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    public synchronized Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price) {
        String bookingNumber = UUID.randomUUID().toString();
        Booking booking = new Booking(flight, passenger, seat, price);
        bookings.put(bookingNumber, booking);
        return booking;
    }

    public void cancelBooking(String bookingNumber) {
        Booking booking = bookings.get(bookingNumber);
        if (booking != null) {
            booking.cancel();
        }
    }
}
