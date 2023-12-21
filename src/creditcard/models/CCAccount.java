package creditcard.models;

import framework.account.Account;
import framework.customer.ICustomer;
import framework.transaction.ITransaction;

import java.time.LocalDate;

public abstract class CCAccount extends Account {
    private LocalDate expDate;
    private Double lastMonthBalance;

    public CCAccount(ICustomer accountOwner) {
        super(0.0, accountOwner);
        this.expDate  = LocalDate.now().plusYears(4);
        this.lastMonthBalance  = 0.0;
    }

    public Double getLastMonthBalance(int lastMonth) {
        for(ITransaction accountTransaction:this.transactions()) {
            if((accountTransaction.getDate().getMonthValue() - 1)  == lastMonth) {
                lastMonthBalance += accountTransaction.getAmount();
            }
        }
        return lastMonthBalance;
    }

    public Double getCurrentMonthCredits(int currentMonth) {
        Double monthlyCredits = 0.0;
        for(ITransaction accountTransaction:this.debits()) {
            if (accountTransaction.getDate().getMonthValue() == currentMonth)  {
                monthlyCredits +=  accountTransaction.getAmount();
            }
        }
        return monthlyCredits;
    }
    public Double getCurrentMonthCharges() {
        Double monthlyCharges  = 0.0;
        for(ITransaction accountTransaction:this.credits()) {
            if (accountTransaction.getDate().isBefore(expDate.withDayOfMonth(1)))  {
                monthlyCharges +=  accountTransaction.getAmount();
            }
        }
        return monthlyCharges;
    }

    public abstract Double getNewMonthlyBalance(int month);
    public abstract Double getMonthlyAmountDue(int month);
    public abstract void addInterest();


}
