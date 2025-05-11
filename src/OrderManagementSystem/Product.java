package OrderManagementSystem;

public class Product {
    private int id;
    private String name;
    private ProductCategory productCategory;
    private double price;
    private int quantity;

    public Product(int id, String name, ProductCategory productCategory, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() { return id; }

    public String getName() { return name; }

    public ProductCategory getProductCategory() { return productCategory; }

    public double getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void updatePrice(double price) {
        this.price = price;
    }
}
