package InventorySystem;

import java.time.LocalDateTime;

public class Inventory {
    private int id;
    private int productId;
    private int warehouseId;
    private int quantity;
    private LocalDateTime lastUpdated;

    public Inventory(int id, int productId, int warehouseId, int quantity, LocalDateTime lastUpdated) {
        this.id = id;
        this.productId = productId;
        this.warehouseId = warehouseId;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
    }

    public int getProductId() { return productId; }
    public int getWarehouseId() { return warehouseId; }
    public int getQuantity() { return quantity; }
    public void addQuantity(int qty) { this.quantity += qty; }
    public void removeQuantity(int qty) { this.quantity -= qty; }
    public void setLastUpdated(LocalDateTime time) { this.lastUpdated = time; }
}
