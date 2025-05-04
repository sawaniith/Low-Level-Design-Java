package CarRentalSystem;

import java.util.*;
import java.util.stream.Collectors;

public class Branch {
    private final String branchId;
    private final String branchCity;
    private final List<Car> cars;

    public Branch(String branchId, String branchCity) {
        this.branchId = branchId;
        this.branchCity = branchCity;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAvailableVehicles() {
        return cars.stream()
                .filter(v -> v.status == CarStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    public String getBranchId() {
        return branchId;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public List<Car> getAllVehicles() {
        return cars;
    }
}