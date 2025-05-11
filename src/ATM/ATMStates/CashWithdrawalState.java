package ATM.ATMStates;

import ATM.ATM;
import ATM.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawAmount) {

        if (atmObject.getAtmBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {
            boolean isDispensed = atmObject.dispenseCash(withdrawAmount);
            if(isDispensed){
                card.deductBankBalance(withdrawAmount);
                atmObject.deductATMBalance(withdrawAmount);
            }
            exit(atmObject);
        }
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
