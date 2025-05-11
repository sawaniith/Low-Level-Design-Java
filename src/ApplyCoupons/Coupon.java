package ApplyCoupons;

import java.time.LocalDate;

public abstract class Coupon {
    protected String code;
    protected LocalDate expiryDate;
    protected double minCartValue;

    public Coupon(String code, LocalDate expiryDate, double minCartValue) {
        this.code = code;
        this.expiryDate = expiryDate;
        this.minCartValue = minCartValue;
    }

    public boolean isValid(double cartValue) {
        return LocalDate.now().isBefore(expiryDate) && cartValue >= minCartValue;
    }

    public abstract double getDiscount(double cartValue);

    public String getCode() {
        return code;
    }
}
