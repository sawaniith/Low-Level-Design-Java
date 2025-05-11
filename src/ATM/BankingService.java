package ATM;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();
    private final Map<String, Card> cards = new ConcurrentHashMap<>();

    public Account createAccount(String accountNumber, double initialBalance) {
        Account account = new SavingsAccount(accountNumber, initialBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Card linkCardToAccount(String cardNumber, int pin, String accountNumber) {
        Card card = null;
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            card = new Card(cardNumber, pin, account);
            cards.put(cardNumber, card);
        }
        return card;
    }

    public Card getCard(String cardNumber) {
        return cards.get(cardNumber);
    }

    public boolean authenticate(String cardNumber, int pin) {
        Card card = cards.get(cardNumber);
        return card != null && card.getPin() == pin;
    }
}
