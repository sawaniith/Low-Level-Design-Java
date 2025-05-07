package SplitWise;

import SplitWise.SplitTypes.EqualSplit;
import SplitWise.SplitTypes.PercentSplit;
import SplitWise.SplitTypes.Split;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SplitwiseService {
    private static SplitwiseService instance;
    private final Map<String, User> users;
    private final Map<String, Group> groups;

    private static final String TRANSACTION_ID_PREFIX = "TXN";
    private static final AtomicInteger transactionCounter = new AtomicInteger(0);

    private SplitwiseService() {
        users = new ConcurrentHashMap<>();
        groups = new ConcurrentHashMap<>();
    }

    public static synchronized SplitwiseService getInstance() {
        if (instance == null) {
            instance = new SplitwiseService();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public void addExpense(String groupId, Expense expense) {
        Group group = groups.get(groupId);
        if (group != null) {
            group.addExpense(expense);
            splitExpense(expense);
            updateBalances(expense, group);
        }
    }

    private void splitExpense(Expense expense) {
        double totalAmount = expense.getAmount();
        List<Split> splits = expense.getSplits();
        int totalSplits = splits.size();

        double splitAmount = totalAmount / totalSplits;
        for (Split split : splits) {
            if (split instanceof EqualSplit) {
                split.setAmount(splitAmount);
            } else if (split instanceof PercentSplit) {
                double amount = totalAmount * split.getPercent() / 100.0;
                split.setAmount(amount);
            }
        }
    }

    private void updateBalances(Expense expense, Group group) {
        User paidBy = expense.getPaidBy();
        for (Split split : expense.getSplits()) {
            User user = split.getUser();
            double amount = split.getAmount();

            if (!paidBy.equals(user)) {
                updateBalance(user, paidBy, amount, group);
                updateBalance(paidBy, user, -amount, group);
            }
        }
    }

    private void updateBalance(User user1, User user2, double amount, Group group) {
        String key = getBalanceKey(user1, user2);
        group.balances.put(key, group.balances.getOrDefault(key, 0.0) + amount);
    }

    private String getBalanceKey(User user1, User user2) {
        return user1.getName() + " Owes to " + user2.getName();
    }

    public void settleBalance(String userId1, String userId2, Group group) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);

        if (user1 != null && user2 != null) {
            String key = getBalanceKey(user1, user2);
            double balance = group.balances.getOrDefault(key, 0.0);

            if (balance > 0) {
                createTransaction(user1, user2, balance);
                group.balances.put(key, 0.0);
                group.balances.put(getBalanceKey(user2, user1), 0.0);
            } else if (balance < 0) {
                createTransaction(user2, user1, Math.abs(balance));
                group.balances.put(key, 0.0);
                group.balances.put(getBalanceKey(user2, user1), 0.0);
            }
        }
    }

    private void createTransaction(User sender, User receiver, double amount) {
        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(transactionId, sender, receiver, amount);
        // Process the transaction
        // ...
    }

    private String generateTransactionId() {
        int transactionNumber = transactionCounter.incrementAndGet();
        return TRANSACTION_ID_PREFIX + String.format("%06d", transactionNumber);
    }
}
