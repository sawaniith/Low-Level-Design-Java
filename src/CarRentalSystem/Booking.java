package CarRentalSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
    private final String bookingId;
    private final Customer customer;
    private final Car car;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double totalPrice;
    private BookingStatus bookingStatus;

    public Booking(String bookingId, Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = calculateTotalPrice();
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    private double calculateTotalPrice() {
        long daysRented = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return car.rentalPricePerDay * daysRented;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Car getCar() {
        return car;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
        this.car.setCarStatus(CarStatus.AVAILABLE);
    }
}
