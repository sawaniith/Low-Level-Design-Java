package ATM;

public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accNum, double bal) {
        this.accountNumber = accNum;
        this.balance = bal;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public void credit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
