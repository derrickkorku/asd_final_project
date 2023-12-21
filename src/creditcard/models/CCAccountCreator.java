package creditcard.models;

import framework.customer.ICustomer;

public class CCAccountCreator {

    public static CCAccount createAccount(ICustomer accountOwner, String accountType) {
        if(accountType.equals("Gold")) {
            return new Gold(accountOwner);
        }

        if (accountType.equals("Silver")) {
            return new Silver(accountOwner);
        }

        return new Copper(accountOwner);

    }
}
