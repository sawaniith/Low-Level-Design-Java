package ElevatorDesign;

import java.util.*;

class ElevatorCar implements Runnable {
    private final int id;
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private ElevatorStatus status = ElevatorStatus.IDLE;
    private final int capacity;

    private final PriorityQueue<Integer> upQueue = new PriorityQueue<>();
    private final PriorityQueue<Integer> downQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private final Set<Integer> deferredUp = new HashSet<>();
    private final Set<Integer> deferredDown = new HashSet<>();
    private final Object lock = new Object();

    private final ElevatorDoor door = new ElevatorDoor();

    public ElevatorCar(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public void handleExternalRequest(Request req) {
        synchronized (lock) {
            int src = req.srcFloor;
            int dest = req.destinationFloor;
            Direction reqDir = (dest > src) ? Direction.UP : Direction.DOWN;

            // Set the direction for the initial movement
            if (status == ElevatorStatus.IDLE) {
                direction = (src > currentFloor) ? Direction.UP : Direction.DOWN;
            }

            // Add source floor first
            if (direction == Direction.UP) {
                if (src > currentFloor && reqDir == Direction.UP) {
                    upQueue.offer(src);
                } else {
                    deferredDown.add(src);
                }
            } else if (direction == Direction.DOWN) {
                if (src < currentFloor && reqDir == Direction.DOWN) {
                    downQueue.offer(src);
                } else {
                    deferredUp.add(src);
                }
            }

            // Always enqueue the destination floor
            if (reqDir == Direction.UP) upQueue.offer(dest);
            else downQueue.offer(dest);

            lock.notify(); // Wake thread to start moving
        }
    }

    private void goToFloor(int floor) throws InterruptedException {
        System.out.printf("🚗 ElevatorCar %d moving from floor %d to %d%n", id, currentFloor, floor);
        Thread.sleep(1000); // Simulate time taken to move
        currentFloor = floor;
        door.openDoor(); // Open the door when arriving at a floor
        Thread.sleep(500); // Simulate time for doors open
        door.closeDoor(); // Close the door after the stop
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (upQueue.isEmpty() && downQueue.isEmpty() && deferredUp.isEmpty() && deferredDown.isEmpty()) {
                    status = ElevatorStatus.IDLE;
                    direction = Direction.IDLE;
                    try {
                        lock.wait(); // Wait until there are requests
                    } catch (InterruptedException ignored) {}
                }
                status = ElevatorStatus.MOVING;
            }

            try {
                if (direction == Direction.UP) {
                    processUpQueue();
                    if (downQueue.isEmpty() && !deferredDown.isEmpty()) {
                        downQueue.addAll(deferredDown);
                        deferredDown.clear();
                    }
                    direction = Direction.DOWN;
                } else if (direction == Direction.DOWN) {
                    processDownQueue();
                    if (upQueue.isEmpty() && !deferredUp.isEmpty()) {
                        upQueue.addAll(deferredUp);
                        deferredUp.clear();
                    }
                    direction = Direction.UP;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void processUpQueue() throws InterruptedException {
        while (!upQueue.isEmpty()) {
            int next = upQueue.poll();
            goToFloor(next);
        }
    }

    private void processDownQueue() throws InterruptedException {
        while (!downQueue.isEmpty()) {
            int next = downQueue.poll();
            goToFloor(next);
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}