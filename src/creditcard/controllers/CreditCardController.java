package creditcard.controllers;

import creditcard.models.CCAccountCreator;
import framework.owner.Owner;
import framework.customer.ICustomer;
import framework.customer.CustomerCreator;



public class CreditCardController {

    public static void createAccount(String name, String street, String city, String zip,
                                        String email, String accountType) {


        System.out.println("Creating a new credit account type: " + accountType);
        ICustomer person = CustomerCreator.createParty(name, street, city, zip, email);
        CCAccountCreator.createAccount(person, accountType);
        System.out.println("After adding new account, owner account size: " + Owner.getAccounts().size());
    }
}
