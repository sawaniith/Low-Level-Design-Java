package SplitWise.SplitTypes;

import SplitWise.User;

public class PercentSplit extends Split{

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public double getPercent() {
        return percent;
    }
}
