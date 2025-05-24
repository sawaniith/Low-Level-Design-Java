package InventorySystem;

public class Product {
    private int id;
    private String barcode;
    private String name;
    private String description;
    private Category category;

    public Product(int id, String barcode, String name, String description, Category category) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public int getId() { return id; }
    public String getBarcode() { return barcode; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
}