package creditcard.models;

import framework.customer.ICustomer;

public class Copper extends CCAccount {
    Double mi = 0.20;
    Double mp = 0.24;
    public Copper(ICustomer accountOwner) {
        super(accountOwner);
    }


    @Override
    public Double getNewMonthlyBalance(int month) {
        Double totalCredits = getCurrentMonthCredits(month);
        Double lastMonthBalance = getLastMonthBalance(month - 1);
        Double totalCharges = getCurrentMonthCharges();

        Double newBalance = lastMonthBalance - totalCredits + totalCharges +
                mi * (lastMonthBalance - totalCredits);
        return newBalance;
    }

    @Override
    public Double getMonthlyAmountDue(int month) {
        Double amountDue;
        amountDue = mp * this.getNewMonthlyBalance(month);
        return amountDue;
    }

    @Override
    public void addInterest() {
        Double balance = getBalance();
        setBalance(balance - (balance * mi));
    }
}
