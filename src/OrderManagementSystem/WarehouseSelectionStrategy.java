package OrderManagementSystem;

import java.util.List;

public interface WarehouseSelectionStrategy {
    public abstract Warehouse selectWarehouse(List<Warehouse> warehouseList);
}