package ApplyCoupons;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private Coupon appliedCoupon;

    public void addItem(CartItem item) {
        items.add(item);
    }

    public double getTotalBeforeDiscount() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public void applyCoupon(Coupon coupon) {
        double total = getTotalBeforeDiscount();
        if (coupon.isValid(total)) {
            this.appliedCoupon = coupon;
        } else {
            throw new IllegalArgumentException("Coupon is not valid for this cart.");
        }
    }

    public double getFinalPrice() {
        double total = getTotalBeforeDiscount();
        if (appliedCoupon != null) {
            return total - appliedCoupon.getDiscount(total);
        }
        return total;
    }
}
