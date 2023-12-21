package banking.controllers;

import banking.models.AccountCreator;
import framework.owner.Owner;
import framework.customer.ICustomer;
import framework.customer.CustomerCreator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankController {

    public static void createAccount(String clientName, String street, String city, String zip,
                                 String email, String dateOfBirthSt, String accountType) {

        System.out.println("Creating new Account");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthSt, formatter);
        ICustomer person = CustomerCreator.createParty(clientName, street, city, zip, email, dateOfBirth);

        AccountCreator.createAccount(0.0, person, accountType);

        System.out.println("After adding a new account, owner account size: " + Owner.getAccounts().size());
    }

    public static void createAccount(String clientName, String street, String city, String zip,
                           String email, int noOfEmp , String accountType) {

        System.out.println("Adding new account");

        ICustomer party = CustomerCreator.createParty(clientName, street, city, zip, email, noOfEmp);
        AccountCreator.createAccount(0.0, party, accountType);

        System.out.println("After adding new account, owner account size: " + Owner.getAccounts().size());
    }
}
