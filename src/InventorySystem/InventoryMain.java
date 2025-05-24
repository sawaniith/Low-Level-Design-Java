package InventorySystem;

public class InventoryMain {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();

        Product p1 = new Product(1, "ABC123", "iPhone", "Smartphone", Category.ELECTRONICS);
        Product p2 = new Product(2, "XYZ789", "Banana", "Fresh Banana", Category.FOOD);
        Warehouse w1 = new Warehouse(1, "WH-BLR", "Bangalore");

        service.registerProduct(p1);
        service.registerProduct(p2);
        service.registerWarehouse(w1);

        service.updateInventory("ABC123", 1, 10, TransactionType.ENTRY);
        service.updateInventory("XYZ789", 1, 30, TransactionType.ENTRY);
        service.updateInventory("ABC123", 1, 3, TransactionType.EXIT);

        service.printInventory(1);
    }
}
