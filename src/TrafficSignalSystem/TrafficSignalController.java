package TrafficSignalSystem;

import java.util.Map;
import java.util.concurrent.*;

public class TrafficSignalController {
    private final Map<Direction, TrafficLight> signals;
    private final Map<Direction, Map<String, Integer>> signalDurations;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> currentTask;

    public TrafficSignalController(Map<Direction, TrafficLight> signals, Map<Direction, Map<String, Integer>> signalDurations) {
        this.signals = signals;
        this.signalDurations = signalDurations;
    }

    public void start(Direction startDirection) {
        TrafficLight light = signals.get(startDirection);
        light.setState(new GreenState());
        light.handle(this);
    }

    public void scheduleStateChange(TrafficLight light, Direction direction, SignalState nextState, int delaySeconds) {
        currentTask = scheduler.schedule(() -> {
            light.setState(nextState);
            light.handle(this);
        }, delaySeconds, TimeUnit.SECONDS);
    }

    public int getSignalDuration(Direction direction, SignalState state) {
        return signalDurations.get(direction).get(state.getName());
    }

    public Direction getNextDirection(Direction current) {
        Direction[] directions = Direction.values();
        int next = (current.ordinal() + 1) % directions.length;
        return directions[next];
    }

    public TrafficLight getTrafficLight(Direction direction) {
        return signals.get(direction);
    }

    public void manualOverride(Direction direction) {
        if (currentTask != null && !currentTask.isDone()) {
            currentTask.cancel(true); // Cancel current cycle
        }

        // Set all lights to RED first
        for (TrafficLight light : signals.values()) {
            light.setState(new RedState());
        }

        System.out.println("Manual override: Setting " + direction + " to GREEN.");

        // Now make the override direction GREEN and begin its cycle
        TrafficLight overrideLight = signals.get(direction);
        overrideLight.setState(new GreenState());
        overrideLight.handle(this);
    }
}
