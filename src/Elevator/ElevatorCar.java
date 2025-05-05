package Elevator;

import java.util.*;

class ElevatorCar implements Runnable {
    public final int id;
    private final int capacity;
    private int currentFloor;
    private Direction currentDirection;

    private final PriorityQueue<Integer> upStops = new PriorityQueue<>();
    private final PriorityQueue<Integer> downStops = new PriorityQueue<>(Comparator.reverseOrder());

    private final Set<Integer> upScheduled = new HashSet<>();
    private final Set<Integer> downScheduled = new HashSet<>();

    private final Set<Request> deferredRequests = new HashSet<>();

    public ElevatorCar(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.currentDirection = Direction.IDLE;
    }

    public synchronized void addRequest(Request request) {
        int src = request.srcFloor;
        int dest = request.destinationFloor;
        Direction reqDir = (dest > src) ? Direction.UP : Direction.DOWN;

        if (currentDirection == Direction.IDLE) {
            currentDirection = (src > currentFloor) ? Direction.UP : Direction.DOWN;
        }

        if (currentDirection == reqDir &&
                ((currentDirection == Direction.UP && src >= currentFloor) ||
                        (currentDirection == Direction.DOWN && src <= currentFloor))) {
            addStop(src);
            addStop(dest);
        } else {
            deferredRequests.add(request);
        }

        notifyAll();
    }

    private void addStop(int floor) {
        // Avoid adding stop if it's already at the current floor
        if (floor == currentFloor) return;

        // Check and add stop for the UP direction
        if (floor > currentFloor) {
            if (!upScheduled.contains(floor)) {
                upScheduled.add(floor);  // Add to the set to mark as scheduled
                upStops.offer(floor);     // Add to the priority queue for processing
            }
        }
        // Check and add stop for the DOWN direction
        else {
            if (!downScheduled.contains(floor)) {
                downScheduled.add(floor); // Add to the set to mark as scheduled
                downStops.offer(floor);   // Add to the priority queue for processing
            }
        }
    }

    private void openAndCloseDoors(int floor) throws InterruptedException {
        System.out.println("🚪 Elevator " + id + " opening doors at floor " + floor);
        Thread.sleep(1000);
        System.out.println("🚪 Elevator " + id + " closing doors at floor " + floor);
    }

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                if (upStops.isEmpty() && downStops.isEmpty() && deferredRequests.isEmpty()) {
                    currentDirection = Direction.IDLE;
                    try {
                        wait();  // This wait will now work because it is inside the synchronized block
                    } catch (InterruptedException ignored) {}
                }
            }

            try {
                if (currentDirection == Direction.UP) {
                    while (!upStops.isEmpty()) {
                        int next = upStops.poll();
                        upScheduled.remove(next);
                        moveTo(next);
                    }
                    promoteDeferredRequests(Direction.DOWN);
                    currentDirection = Direction.DOWN;
                } else if (currentDirection == Direction.DOWN) {
                    while (!downStops.isEmpty()) {
                        int next = downStops.poll();
                        downScheduled.remove(next);
                        moveTo(next);
                    }
                    promoteDeferredRequests(Direction.UP);
                    currentDirection = Direction.UP;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void moveTo(int floor) throws InterruptedException {
        System.out.printf("🚗 Elevator %d moving from %d to %d%n", id, currentFloor, floor);
        Thread.sleep(1000);
        currentFloor = floor;
        openAndCloseDoors(floor);
    }

    private synchronized void promoteDeferredRequests(Direction dir) {
        List<Request> promoted = new ArrayList<>();
        for (Request req : deferredRequests) {
            int src = req.srcFloor;
            int dest = req.destinationFloor;
            Direction reqDir = (dest > src) ? Direction.UP : Direction.DOWN;

            if (reqDir == dir &&
                    ((dir == Direction.UP && src >= currentFloor) ||
                            (dir == Direction.DOWN && src <= currentFloor))) {
                addStop(src);
                addStop(dest);
                promoted.add(req);
            }
        }
        deferredRequests.removeAll(promoted);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public int getPendingRequestCount() {
        return upStops.size() + downStops.size();
    }
}