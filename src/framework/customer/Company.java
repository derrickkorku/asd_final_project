package framework.customer;
import framework.owner.Owner;
import framework.utilities.Email;
import framework.utilities.Utility;
import framework.transaction.ITransaction;

public class Company extends Customer implements ICompany {
    private int numOfEmployees;

    /**
     * Create a new Organization object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param email
     * @param numOfEmployees
     */
    public Company(String name, String street, String city, String zip, String email, int numOfEmployees) {
        super(name, street, city, zip, email);
        this.numOfEmployees = numOfEmployees;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    @Override
    public void sendEmail(ITransaction transaction) {
        Utility.sendEmail(
                new Email("New Transaction", Owner.getEmail(), transaction.getAccount().getAccountOwner().getEmail(), transaction.toString())
        );
    }
}
