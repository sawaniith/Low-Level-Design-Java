package InventorySystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    private final Map<String, Product> productMap = new HashMap<>();
    private final Map<Integer, Warehouse> warehouseMap = new HashMap<>();
    private final Map<String, Inventory> inventoryMap = new HashMap<>();
    private final List<Transaction> transactions = new ArrayList<>();
    private int inventoryId = 1;
    private int transactionId = 1;

    private String inventoryKey(int productId, int warehouseId) {
        return productId + "_" + warehouseId;
    }

    public void registerProduct(Product product) {
        productMap.put(product.getBarcode(), product);
    }

    public void registerWarehouse(Warehouse warehouse) {
        warehouseMap.put(warehouse.getId(), warehouse);
    }

    public void updateInventory(String barcode, int warehouseId, int quantity, TransactionType type) {
        Product product = productMap.get(barcode);
        if (product == null) throw new RuntimeException("Product not found");
        if (!warehouseMap.containsKey(warehouseId)) throw new RuntimeException("Warehouse not found");

        int productId = product.getId();
        String key = inventoryKey(productId, warehouseId);
        Inventory inventory = inventoryMap.getOrDefault(key, new Inventory(inventoryId++, productId, warehouseId, 0, LocalDateTime.now()));

        if (type == TransactionType.ENTRY) {
            inventory.addQuantity(quantity);
        } else {
            if (inventory.getQuantity() < quantity) throw new RuntimeException("Insufficient stock");
            inventory.removeQuantity(quantity);
        }

        inventory.setLastUpdated(LocalDateTime.now());
        inventoryMap.put(key, inventory);
        transactions.add(new Transaction(transactionId++, barcode, warehouseId, type, quantity, LocalDateTime.now()));
    }

    public void printInventory(int warehouseId) {
        System.out.println("Warehouse: " + warehouseMap.get(warehouseId).getName());
        for (Inventory inv : inventoryMap.values()) {
            if (inv.getWarehouseId() == warehouseId) {
                Product p = productMap.values().stream()
                        .filter(prod -> prod.getId() == inv.getProductId())
                        .findFirst().orElse(null);
                if (p != null) {
                    System.out.println(" - " + p.getName() + " (" + p.getBarcode() + "): " + inv.getQuantity());
                }
            }
        }
    }
}
