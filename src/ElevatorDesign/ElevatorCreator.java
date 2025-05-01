package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    //The static block inside your ElevatorCreator class executes once, and only when the class is
    //first loaded into memory by the JVM.

    public static List<ElevatorController> elevatorControllerList = initControllers();

    private static List<ElevatorController> initControllers() {
        List<ElevatorController> list = new ArrayList<>();

        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.id = 1;
        list.add(new ElevatorController(elevatorCar1));

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar2.id = 2;
        list.add(new ElevatorController(elevatorCar2));

        return list;
    }
}
