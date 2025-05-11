package ATM;

import ATM.ATMStates.ATMState;
import ATM.ATMStates.IdleState;

public class ATM {

    private int atmBalance;
    private int noOfFiveHundredNotes;
    private int noOfTwoHundredNotes;
    private int noOfOneHundredNotes;
    private ATMState currentATMState;
    private final BankingService bankingService;

    public ATM(BankingService bankingService) {
        this.currentATMState = new IdleState();
        this.bankingService = bankingService;
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void addATMBalance(int atmBal, int noOfFiveHundredNote, int noOfTwoHundredNote, int noOfOneHundredNote) {
        atmBalance += atmBal;
        noOfFiveHundredNotes += noOfFiveHundredNote;
        noOfTwoHundredNotes += noOfTwoHundredNote;
        noOfOneHundredNotes += noOfOneHundredNote;
    }

    public boolean authenticateUser(Card card, int pin) {
        boolean isAuthenticated = bankingService.authenticate(card.getCardNumber(), pin);
        if (isAuthenticated) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed.");
            return false;
        }
    }

    public int getNoOfTwoHundredNotes() {
        return noOfTwoHundredNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoHundredNotes(int number) {
        noOfTwoHundredNotes = noOfTwoHundredNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public boolean dispenseCash(double withdrawAmount) {
        // Cast to int, assuming only integer denominations
        int remaining = (int) withdrawAmount;

        int count500 = Math.min(remaining / 500, noOfFiveHundredNotes);
        remaining -= count500 * 500;

        int count200 = Math.min(remaining / 200, noOfTwoHundredNotes);
        remaining -= count200 * 200;

        int count100 = Math.min(remaining / 100, noOfOneHundredNotes);
        remaining -= count100 * 100;

        if (remaining != 0) {
            // Cannot dispense the exact amount with available notes
            return false;
        }

        // Deduct from ATM
        noOfFiveHundredNotes = noOfFiveHundredNotes - count500;
        noOfTwoHundredNotes = noOfTwoHundredNotes - count200;
        noOfOneHundredNotes = noOfOneHundredNotes - count100;

        // Print dispensed notes
        if (count500 > 0) System.out.println("Dispensing 500 x " + count500);
        if (count200 > 0) System.out.println("Dispensing 200 x " + count200);
        if (count100 > 0) System.out.println("Dispensing 100 x " + count100);

        return true;
    }

    public void printCurrentATMStatus() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("500 Notes: " + noOfFiveHundredNotes);
        System.out.println("200 Notes: " + noOfTwoHundredNotes);
        System.out.println("100 Notes: " + noOfOneHundredNotes);
    }
}
