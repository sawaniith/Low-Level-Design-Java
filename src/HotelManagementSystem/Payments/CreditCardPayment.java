package HotelManagementSystem.Payments;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
