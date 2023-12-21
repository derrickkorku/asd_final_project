package framework.customer;
import framework.owner.Owner;
import framework.transaction.ITransaction;
import framework.utilities.Email;

import java.time.LocalDate;

public class Person extends Customer implements IPerson {
    private LocalDate birthDate;

    /**
     * Create a new Person object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param birthDate
     */
    public Person(String name, String street, String city, String zip, String email, LocalDate birthDate){
        super(name, street, city, zip, email);
        this.birthDate = birthDate;
    }

    public Person(String name, String street, String city, String zip, String email) {
        super(name, street, city, zip, email);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void sendEmail(ITransaction transaction) {
       if (Math.abs(transaction.getAmount()) > 400){
           new Email("New Transaction", Owner.getEmail(), transaction.getAccount().getAccountOwner().getEmail(), transaction.toString());
       }
    }
}
