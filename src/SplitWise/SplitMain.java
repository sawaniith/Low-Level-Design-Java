package SplitWise;

import SplitWise.SplitTypes.EqualSplit;
import SplitWise.SplitTypes.PercentSplit;

import java.util.Arrays;
import java.util.Map;

public class SplitMain {
    public static void main(String[] args) {
        SplitwiseService splitwiseService = SplitwiseService.getInstance();

        // Create users
        User user1 = new User("1", "Alice", "alice@example.com");
        User user2 = new User("2", "Bob", "bob@example.com");
        User user3 = new User("3", "Charlie", "charlie@example.com");

        splitwiseService.addUser(user1);
        splitwiseService.addUser(user2);
        splitwiseService.addUser(user3);

        // Create a group
        Group group = new Group("1", "Apartment");
        group.addMember(user1);
        group.addMember(user2);
        group.addMember(user3);

        splitwiseService.addGroup(group);

        // Add an expense
        Expense expense = new Expense("1", 300.0, "Rent", user1);
        EqualSplit equalSplit1 = new EqualSplit(user1);
        EqualSplit equalSplit2 = new EqualSplit(user2);
        EqualSplit equalSplit3 = new EqualSplit(user3);

        expense.addSplit(equalSplit1);
        expense.addSplit(equalSplit2);
        expense.addSplit(equalSplit3);

        splitwiseService.addExpense(group.getId(), expense);

        Expense expense2 = new Expense("2", 600.0, "Food", user2);
        PercentSplit equalSplit4 = new PercentSplit(user1, 30);
        PercentSplit equalSplit5 = new PercentSplit(user2, 40);
        PercentSplit equalSplit6 = new PercentSplit(user3, 30);

        expense2.addSplit(equalSplit4);
        expense2.addSplit(equalSplit5);
        expense2.addSplit(equalSplit6);

        splitwiseService.addExpense(group.getId(), expense2);

        // Print user balances before settlement
        for (Map.Entry<String, Double> entry : group.balances.entrySet()) {
            double balance = entry.getValue()<0 ? 0.0 : entry.getValue();
            System.out.println(entry.getKey() + ": " + balance);
        }

        System.out.println("-------------------------");

        //Settle balances
        splitwiseService.settleBalance(user2.getId(), user1.getId(), group);
        splitwiseService.settleBalance(user3.getId(), user1.getId(), group);
        splitwiseService.settleBalance(user3.getId(), user2.getId(), group);

        // Print user balances after settlement
        for (Map.Entry<String, Double> entry : group.balances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
