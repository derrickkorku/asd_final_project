package framework.customer;

import framework.account.IAccount;
import framework.transaction.ITransaction;

public interface ICustomer {
    void addAccount(IAccount account);
    void removeAccount(IAccount account);
    void sendEmail(ITransaction transaction);
    String getEmail();
    public String getName();

    public String getStreet();

    public String getCity();

    public String getState();

    public String getZip();
}
