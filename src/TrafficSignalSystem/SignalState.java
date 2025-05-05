package TrafficSignalSystem;

public interface SignalState {
    public void handle(TrafficLight light, TrafficSignalController controller, Direction direction);
    public String getName();
}
