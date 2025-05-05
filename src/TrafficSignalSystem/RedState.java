package TrafficSignalSystem;

public class RedState implements SignalState{
    @Override
    public void handle(TrafficLight light, TrafficSignalController controller, Direction direction) {
        System.out.println(direction + " is RED");

        int duration = controller.getSignalDuration(direction, this);
        Direction next = controller.getNextDirection(direction);
        TrafficLight nextLight = controller.getTrafficLight(next);

        controller.scheduleStateChange(nextLight, next, new GreenState(), duration);
    }

    @Override
    public String getName() {
        return "RED";
    }
}
