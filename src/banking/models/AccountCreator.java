package banking.models;

import framework.account.IAccount;
import framework.customer.ICustomer;

public class AccountCreator {
    public static IAccount createAccount(Double balance, ICustomer accountOwner, String type){
        if (type != null && type.equals("S")){
            System.out.println("Creating a saving account");
            return new Saving(balance, accountOwner);
        } else if (type != null && type.equals("Ch")){
            System.out.println("Creating a checking account.");
            return new Checking(balance, accountOwner);
        }

        return null;
    }
}
