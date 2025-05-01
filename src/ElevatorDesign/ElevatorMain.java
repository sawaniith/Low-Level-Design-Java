package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorMain {
    public static void main(String[] args) {

        //SCAN Algorithm (Elevator Algorithm)
        //The disk arm moves in one direction, servicing all requests until it hits the end (start or end of disk).
        //Then it reverses direction and services requests on the way back.
        //Cons:
        //May go all the way to the end even if there are no requests there.

        //LOOK Algorithm (mostly used)
        //Similar to SCAN, but the arm only goes as far as the last request in the current direction — doesn't go all
        //the way to the disk’s physical end.
        //Then reverses direction just like SCAN.
        //More efficient than SCAN — less unnecessary movement.

        List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);

        Building building = new Building(floorList);
    }
}
