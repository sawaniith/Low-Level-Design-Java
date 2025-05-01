package RideSharingApplication;

public class Bike extends Vehicle {
    public Bike(String ownerName, String model, String number) {
        super(ownerName, model, number);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}
