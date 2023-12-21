package framework.customer;
import java.time.LocalDate;

public class CustomerCreator {

    /**
     * Creates a new IPerson object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param dateOfBirth
     * @param email
     * @return
     */
    public static IPerson createParty(String name, String street, String city, String zip, String email, LocalDate dateOfBirth){
        System.out.println("Creating a Person.");
        return new Person(name, street, city, zip, email, dateOfBirth);
    }

    /**
     * Creates and returns an organization object
     * @param name
     * @param street
     * @param city
     * @param zip
     * @param numOfEmployees
     * @param email
     * @return
     */
    public static ICompany createParty(String name, String street, String city, String zip, String email, int numOfEmployees) {
        System.out.println("Creating an organization.");
        return new Company(name, street, city, zip, email, numOfEmployees);
    }

    public static IPerson createParty(String name, String street, String city, String zip, String email){
        System.out.println("Creating a Person.");
        return new Person(name, street, city, zip, email);
    }

}
