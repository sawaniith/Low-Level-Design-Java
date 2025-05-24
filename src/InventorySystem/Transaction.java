package InventorySystem;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private String barcode;
    private int warehouseId;
    private TransactionType type;
    private int quantity;
    private LocalDateTime timestamp;

    public Transaction(int id, String barcode, int warehouseId, TransactionType type, int quantity, LocalDateTime timestamp) {
        this.id = id;
        this.barcode = barcode;
        this.warehouseId = warehouseId;
        this.type = type;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }
}
