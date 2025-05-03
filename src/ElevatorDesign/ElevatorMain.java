package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorMain {
    public static void main(String[] args) throws InterruptedException{

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

        ElevatorController controller = new ElevatorController(3, 5);

        // Trigger requests that are best served by different elevators
        controller.handleExternalRequest(new Request(1, 7)); // Elevator 1
        controller.handleExternalRequest(new Request(8, 2)); // Elevator 2
        controller.handleExternalRequest(new Request(5, 10)); // Elevator 3

        // Give some time for elevators to process
        Thread.sleep(15000);

        // More requests to keep elevators busy
        controller.handleExternalRequest(new Request(3, 0)); // Elevator 1 again
        controller.handleExternalRequest(new Request(9, 4)); // Elevator 2 again
        controller.handleExternalRequest(new Request(6, 12)); // Elevator 3 again
    }
}
