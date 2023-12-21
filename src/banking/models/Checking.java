package banking.models;

import framework.customer.ICustomer;

public class Checking extends BankAccount {
    public Checking(Double balance, ICustomer accountOwner) {
        super(balance, accountOwner);
    }

    @Override
    public Double getInterestRate() {
        return BankAccount.CHECKING_INTEREST_RATE;
    }

}
