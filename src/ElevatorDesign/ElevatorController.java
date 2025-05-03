package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<ElevatorCar> elevators;

    public ElevatorController(int numElevators, int capacity) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            ElevatorCar elevator = new ElevatorCar(i + 1, capacity);
            elevators.add(elevator);
            new Thread(elevator).start();
        }
    }

    public void handleExternalRequest(Request req) {
        ElevatorCar best = selectBestElevator(req.srcFloor);
        best.handleExternalRequest(req);
    }

    private ElevatorCar selectBestElevator(int floor) {
        ElevatorCar best = null;
        int minDist = Integer.MAX_VALUE;
        for (ElevatorCar e : elevators) {
            int dist = Math.abs(floor - e.getCurrentFloor());
            if (dist < minDist) {
                minDist = dist;
                best = e;
            }
        }
        return best;
    }
}