package RideSharingApplication;

public class RideShareMain {
    public static void main(String[] args) {
        //problem link
        //https://www.geeksforgeeks.org/flipkart-machine-coding-round-experience/

        RideSharingService service = new RideSharingService();

        service.addUser("Rohan", "M", 36);
        service.addVehicle("Rohan", "Swift", "KA-01-12345");

        service.addUser("Shashank", "M", 29);
        service.addVehicle("Shashank", "Baleno", "TS-05-62395");

        service.addUser("Nandini", "F", 29);

        service.addUser("Shipra", "F", 27);
        service.addVehicle("Shipra", "Polo", "KA-05-41491");
        service.addVehicle("Shipra", "Activa", "KA-12-12332"); // Bike

        service.addUser("Gaurav", "M", 29);

        service.addUser("Rahul", "M", 35);
        service.addVehicle("Rahul", "XUV", "KA-05-1234");

        service.offerRide("Rohan", "Hyderabad", "Bangalore", 1, "KA-01-12345");
        service.offerRide("Shipra", "Bangalore", "Mysore", 1, "KA-12-12332");
        service.offerRide("Shipra", "Bangalore", "Mysore", 2, "KA-05-41491");
        service.offerRide("Shashank", "Hyderabad", "Bangalore", 2, "TS-05-62395");
        service.offerRide("Rahul", "Hyderabad", "Bangalore", 5, "KA-05-1234");
        service.offerRide("Rohan", "Bangalore", "Pune", 1, "KA-01-12345"); // Should fail

        service.selectRide("Nandini", "Bangalore", "Mysore", 1, "Most Vacant", null);
        service.selectRide("Gaurav", "Bangalore", "Mysore", 1, "Preferred Vehicle", "Activa");
        service.selectRide("Shashank", "Mumbai", "Bangalore", 1, "Most Vacant", null);
        service.selectRide("Rohan", "Hyderabad", "Bangalore", 1, "Preferred Vehicle", "Baleno");
        service.selectRide("Shashank", "Hyderabad", "Bangalore", 1, "Preferred Vehicle", "Polo");

        service.endRide("KA-01-12345"); // Rohan's
        service.endRide("KA-12-12332"); // Shipra's Activa
        service.endRide("KA-05-41491"); // Shipra's Polo
        service.endRide("TS-05-62395"); // Shashank's

        service.printRideStats();
    }
}
