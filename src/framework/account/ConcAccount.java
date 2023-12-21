package framework.account;
import framework.account.Account;
import framework.customer.ICustomer;

public class ConcAccount extends Account {
    public ConcAccount(Double balance, ICustomer party) {
        super(balance, party);
    }

    @Override
    public void addInterest() {
        Double balance = getBalance();
        double interest = 0.5 * balance;
        balance += interest;
        setBalance(balance);
    }
}
