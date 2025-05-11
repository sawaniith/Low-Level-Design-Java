package ATM.Enums;

public enum TransactionType {
    CASH_WITHDRAWAL, CASH_DEPOSIT, BALANCE_CHECK;

    public static void showAllTransactionTypes(){
        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
