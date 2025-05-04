package CarRentalSystem;

public class Car{
    public String carID;
    public String model;
    public String numberPlate;
    public double rentalPricePerDay;
    public CarStatus status;

    public Car(String carID, String model, String numberPlate, double rentalPricePerDay) {
        this.carID = carID;
        this.model = model;
        this.numberPlate = numberPlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.status = CarStatus.AVAILABLE;
    }

    public void setCarStatus(CarStatus status){
        this.status = status;
    }
}
