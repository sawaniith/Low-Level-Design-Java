package HotelManagementSystem.Payments;

public class CashPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
