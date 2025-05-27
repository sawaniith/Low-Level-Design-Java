package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {
    private final Map<Product, Integer> items;

    public Cart() {
        items = new ConcurrentHashMap<>();
    }

    public void add(Product product, int quantity) {
        if (items.containsKey(product)) {
            items.put(product, items.get(product) + quantity);
        } else {
            items.put(product, quantity);
        }
    }

    public Map<Product, Integer> getItems() {
        return new HashMap<>(items);
    }

    public void clear() {
        items.clear();
    }
}
