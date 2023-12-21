package banking.models;

import framework.account.Account;
import framework.customer.ICustomer;

public abstract class BankAccount extends Account {
    public static Double SAVING_INTEREST_RATE = 0.34;
    public static Double CHECKING_INTEREST_RATE = 0.3232;

    public BankAccount(Double balance, ICustomer accountOwner) {
        super(balance, accountOwner);
    }

    public abstract Double getInterestRate();

    @Override
    public void addInterest() {
        Double balance = getBalance();

        double interest = getInterestRate() * balance;
        this.addTransaction("Interest", interest);
        balance += interest;
        setBalance(balance);
    }
}
