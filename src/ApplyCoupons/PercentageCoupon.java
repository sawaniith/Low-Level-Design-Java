package ApplyCoupons;

import java.time.LocalDate;

public class PercentageCoupon extends Coupon{
    private double percentage;

    public PercentageCoupon(String code, LocalDate expiryDate, double minCartValue, double percentage) {
        super(code, expiryDate, minCartValue);
        this.percentage = percentage;
    }

    @Override
    public double getDiscount(double cartValue) {
        return isValid(cartValue) ? cartValue * (percentage / 100) : 0;
    }
}
