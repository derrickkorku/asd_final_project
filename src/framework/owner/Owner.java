package framework.owner;

import framework.account.IAccount;
import framework.utilities.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Users observer pattern to notify accounts(observers) to
 * add interest
 */
public abstract class Owner {
    private static String name = "CompanyX";
    private static String email = "companyx@gmail.com";
    private static String accountNumPrexi = "Cx";

    /**
     * List of observers
     */
    private static List<IAccount> accounts = new ArrayList<>();

    public static String getName() {
        return name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setName(String name) {
        Owner.name = name;
    }

    public static void setEmail(String email) {
        Owner.email = email;
    }

    public static String getNextAccountNumber(){
        return accountNumPrexi + " " + (accounts.size() + 1);
    }

    public static List<IAccount> getAccounts() {
        return accounts;
    }

    /**
     * Serves to add observers
     * @param account
     */
    public static void addAccount(IAccount account) {
        accounts.add(account);
    }

    public static Response updateAccountBalance(String accountNumber, Double amount) {
        for (IAccount acc : accounts){
            if (acc.getAccountNum().equals(accountNumber)){
               return acc.addTransaction("Debit/Credit operation", amount);
            }
        }

        return new Response(false, "Account Not Found");
    }

    /**
     * Notify all accounts to apply interest
     */
    public static void notifyApplyInterest(){
        System.out.println("Broadcasting to all system accounts to add individual interests.");

        int count = 0;

        for (IAccount account : accounts){
            account.addInterest();
            count++;
        }

        System.out.println(count + " accounts applied interest.");
    }
}
