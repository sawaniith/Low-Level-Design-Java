package RideSharingApplication;

public abstract class Vehicle {
    public String ownerName;
    public String model;
    public String number;

    public Vehicle(String ownerName, String model, String number) {
        this.ownerName = ownerName;
        this.model = model;
        this.number = number;
    }

    public abstract String getType();
}
