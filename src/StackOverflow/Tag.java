package StackOverflow;

import java.util.concurrent.atomic.AtomicInteger;

public class Tag {
    private final int id;
    private final String name;
    private final AtomicInteger nextId = new AtomicInteger(0);

    public Tag(String name) {
        this.id = generateId();
        this.name = name;
    }

    private int generateId() {
        return nextId.getAndIncrement();
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
}
