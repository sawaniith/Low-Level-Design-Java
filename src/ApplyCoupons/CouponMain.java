package ApplyCoupons;

import java.time.LocalDate;

public class CouponMain {
    public static void main(String[] args) {
        Product p1 = new Product("P1", "Shirt", 500);
        Product p2 = new Product("P2", "Jeans", 1000);

        Cart cart = new Cart();
        cart.addItem(new CartItem(p1, 2)); // 1000
        cart.addItem(new CartItem(p2, 1)); // 1000
        // Total: 2000

        Coupon flat100 = new FlatCoupon("FLAT100", LocalDate.of(2025, 12, 31), 1000, 100);
        Coupon percent10 = new PercentageCoupon("PERC10", LocalDate.of(2025, 12, 31), 1500, 10);

        cart.applyCoupon(flat100);
        System.out.println("Final Price with Flat100: " + cart.getFinalPrice()); // 1900

        cart.applyCoupon(percent10);
        System.out.println("Final Price with Perc10: " + cart.getFinalPrice()); // 1800
    }
}
