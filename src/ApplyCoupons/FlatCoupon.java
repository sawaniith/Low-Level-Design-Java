package ApplyCoupons;

import java.time.LocalDate;

public class FlatCoupon extends Coupon{
    private double flatDiscount;

    public FlatCoupon(String code, LocalDate expiryDate, double minCartValue, double flatDiscount) {
        super(code, expiryDate, minCartValue);
        this.flatDiscount = flatDiscount;
    }

    @Override
    public double getDiscount(double cartValue) {
        return isValid(cartValue) ? flatDiscount : 0;
    }
}
