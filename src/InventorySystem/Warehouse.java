package InventorySystem;

public class Warehouse {
    private int id;
    private String name;
    private String location;

    public Warehouse(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
}