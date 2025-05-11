package OrderManagementSystem;

public class ProductCategory {
    private int id;
    private String name;
    private String description;

    public ProductCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
}
