package TrafficSignalSystem;

import java.util.HashMap;
import java.util.Map;

public class TrafficMain {
    public static void main(String[] args) {
        // Configure durations per direction and state
        Map<Direction, Map<String, Integer>> signalDurations = new HashMap<>();

        signalDurations.put(Direction.NORTH, Map.of("GREEN", 4, "YELLOW", 2, "RED", 1));
        signalDurations.put(Direction.SOUTH, Map.of("GREEN", 3, "YELLOW", 2, "RED", 1));
        signalDurations.put(Direction.EAST,  Map.of("GREEN", 5, "YELLOW", 2, "RED", 1));
        signalDurations.put(Direction.WEST,  Map.of("GREEN", 2, "YELLOW", 2, "RED", 1));

        // Initialize traffic lights
        Map<Direction, TrafficLight> signals = new HashMap<>();
        for (Direction direction : Direction.values()) {
            signals.put(direction, new TrafficLight(direction));
        }

        // Create and start the controller
        Intersection intersection1 = new Intersection("1", signals, signalDurations);
        intersection1.start(Direction.NORTH);

        // Manual override after 10 seconds (simulate)
        new Thread(() -> {
            try {
                Thread.sleep(15000); // wait 10 seconds
                intersection1.manualOverride(Direction.SOUTH); // force EAST to green
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}