package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String userId;
    public String name;
    public String email;
    public final String phone;
    public final String licenseNumber;
    private final List<Booking> myBookings = new ArrayList<>();

    public Customer(String userId, String name, String email, String phone, String licenseNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
    }

    public void addBooking(Booking booking) {
        myBookings.add(booking);
    }

    public List<Booking> getMyBookings() {
        return myBookings;
    }
}