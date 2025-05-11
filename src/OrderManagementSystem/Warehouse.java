package OrderManagementSystem;

import java.util.Map;

public class Warehouse {
    Inventory inventory;
    Address address;

    //update inventory
    public void removeItemFromInventory(Map<Integer, Integer> productAndCountMap){

        //it will update the items in the inventory based upon product category.
        inventory.removeItems(productAndCountMap);
    }

    public void addItemToInventory(Map<Integer, Integer> productAndCountMap){

        //it will update the items in the inventory based upon product category.
    }
}
