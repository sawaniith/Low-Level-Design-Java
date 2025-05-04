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

    public void handleRequest(Request req) {
        ElevatorCar best = selectBestElevator(req.srcFloor);
        System.out.println("📦 Assigning floor " + req.srcFloor + " → " + req.destinationFloor + " to Elevator " + best.id);
        best.addRequest(req);
    }

    private ElevatorCar selectBestElevator(int floor) {
        ElevatorCar best = null;
        int minScore = Integer.MAX_VALUE;

        for (ElevatorCar e : elevators) {
            int distance = Math.abs(floor - e.getCurrentFloor());
            int load = e.getPendingRequestCount();

            // Scoring: favor closer and less-burdened elevators
            int score = distance + (load * 2);  // Tune this weight if needed

            if (score < minScore) {
                minScore = score;
                best = e;
            }
        }

        return best;
    }
}