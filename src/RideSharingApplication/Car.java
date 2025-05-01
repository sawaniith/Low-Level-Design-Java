package RideSharingApplication;

public class Car extends Vehicle {
    public Car(String ownerName, String model, String number) {
        super(ownerName, model, number);
    }

    @Override
    public String getType() {
        return "Car";
    }
}
