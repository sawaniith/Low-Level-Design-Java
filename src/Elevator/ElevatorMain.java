package Elevator;

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

        ElevatorController controller = new ElevatorController(3, 10);

        // Simulate multiple requests
        controller.handleRequest(new Request(1, 7));   // likely Elevator 1
        Thread.sleep(500);

        controller.handleRequest(new Request(3, 5));   // likely Elevator 2
        Thread.sleep(500);

        controller.handleRequest(new Request(6, 10));  // likely Elevator 3
        Thread.sleep(500);

        controller.handleRequest(new Request(9, 2));   // assigned based on current state
        Thread.sleep(500);

        controller.handleRequest(new Request(4, 0));
        Thread.sleep(500);

        controller.handleRequest(new Request(8, 12));
        Thread.sleep(500);

        controller.handleRequest(new Request(2, 6));
    }
}
