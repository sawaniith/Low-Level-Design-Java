package HotelManagementSystem.Payments;

public class UPIPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
