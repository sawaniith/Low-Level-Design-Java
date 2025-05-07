package SplitWise.SplitTypes;

import SplitWise.User;

public abstract class Split {
    protected User user;
    protected double percent;
    protected double amount;

    public Split(User user) {
        this.user = user;
    }

    public abstract double getAmount();

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getPercent() {
        return percent;
    }
}
