package ApplyCoupons;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.price * quantity;
    }
}
