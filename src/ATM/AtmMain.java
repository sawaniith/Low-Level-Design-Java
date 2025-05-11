package ATM;

import ATM.Enums.TransactionType;

public class AtmMain {
    public static void main(String[] args) {

        BankingService bankingService = new BankingService();
        ATM atm = new ATM(bankingService);

        atm.addATMBalance(10000, 10, 15, 20);

        // Create sample accounts
        Account a1 = bankingService.createAccount("1234567890", 8000.0);
        Account a2 = bankingService.createAccount("9876543210", 500.0);

        // Perform ATM operations
        Card card = bankingService.linkCardToAccount("123456789012", 1234, a1.getAccountNumber());

        atm.printCurrentATMStatus();
        atm.getCurrentATMState().insertCard(atm, card);
        atm.getCurrentATMState().authenticatePin(atm, card, 1234);
        atm.getCurrentATMState().selectOperation(atm, card, TransactionType.CASH_WITHDRAWAL);
        atm.getCurrentATMState().cashWithdrawal(atm, card, 7200);
        atm.printCurrentATMStatus();
    }
}
