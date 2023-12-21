package framework.transaction;

import framework.account.IAccount;

import java.time.LocalDate;

public class Transaction implements ITransaction {
    private final Double amount;
    private final LocalDate date;
    private final String name;
    private final IAccount account;

    /**
     * Credit Debit/Credit Transaction for an Account
     * @param name | title of transaction
     * @param amount
     * @param account
     */
    public Transaction(String name, Double amount, IAccount account){
        this.amount = amount;
        this.name = name;
        this.date = LocalDate.now();
        this.account  = account;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    @Override
    public IAccount getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
