package OrderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, Integer> productIdVsCountMap;

    public Cart(){
        productIdVsCountMap = new HashMap<>();
    }

    //add item to cart
    public void addItemInCart(int productId, int count){

        if(productIdVsCountMap.containsKey(productId)){
            int noOfItemsInCart = productIdVsCountMap.get(productId);
            productIdVsCountMap.put(productId, noOfItemsInCart + count);
        } else{
            productIdVsCountMap.put(productId, count);
        }
    }


    //remove item to cart
    public void removeItemFromCart(int productId, int count) {

        if (productIdVsCountMap.containsKey(productId))
        {
            int noOfItemsInCart = productIdVsCountMap.get(productId);
            if (count - noOfItemsInCart == 0) {
                productIdVsCountMap.remove(productId);
            } else {
                productIdVsCountMap.put(productId, noOfItemsInCart - count);
            }
        }
    }


    //empty my cart
    public void emptyCart(){
        productIdVsCountMap = new HashMap<>();
    }

    //View Cart
    public Map<Integer, Integer> getCartItems(){
        return productIdVsCountMap;
    }
}
