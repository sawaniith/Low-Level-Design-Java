package ATM.ATMStates;

import ATM.ATM;
import ATM.Card;

public class CashDepositState extends ATMState {

    public CashDepositState() {
        System.out.println("Please enter the Deposit Amount");
    }

    public void cashDeposit(ATM atmObject, Card card, int depositAmount, int noOfFiveHundredNotes, int noOfTwoHundredNotes, int noOfOneHundredNotes) {
        atmObject.addATMBalance(depositAmount, noOfFiveHundredNotes, noOfTwoHundredNotes, noOfOneHundredNotes);
        card.addBankBalance(depositAmount);
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
