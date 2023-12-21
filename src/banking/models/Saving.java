package banking.models;
import framework.customer.ICustomer;

public class Saving extends BankAccount {
    public Saving(Double balance, ICustomer accountOwner) {
        super(balance, accountOwner);
    }
    @Override
    public Double getInterestRate() {
        return BankAccount.SAVING_INTEREST_RATE;
    }
}
