package ATM;

import java.time.LocalDate;

public class Card {
    private final String cardNumber;
    private final int pin;
    private Account bankAccount;

    public Card(String cardNumber, int pin, Account bankAccount){
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public double getBankBalance(){
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount){
        bankAccount.withdraw(amount);
    }

    public void addBankBalance(int amount){
        bankAccount.credit(amount);
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getPin(){
        return pin;
    }

    public String getCardNumber(){
        return cardNumber;
    }
}
