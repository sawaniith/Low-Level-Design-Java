package RideSharingApplication;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public String gender;
    public int age;
    public List<Vehicle> vehicles = new ArrayList<>();
    public int ridesOffered = 0;
    public int ridesTaken = 0;

    User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
