package framework.account;
import framework.customer.ICustomer;
import framework.transaction.ITransaction;
import framework.utilities.Response;

import java.util.List;

public interface IAccount {
    public Double getBalance();
    public Response addTransaction(String name, Double amount);
    public void addInterest();
    public String getAccountNum();
    public ICustomer getAccountOwner();
    public List<ITransaction> transactions();
    public List<ITransaction> credits();
    public List<ITransaction> debits();
}
