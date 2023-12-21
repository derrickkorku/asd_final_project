package framework.account;

import framework.owner.Owner;
import framework.customer.ICustomer;
import framework.transaction.ITransaction;
import framework.transaction.Transaction;
import framework.utilities.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Account implements IAccount {
    private Double balance = 0.0;
    private final ICustomer accountOwner;
    private final String accountNum;
    private final List<ITransaction> transactions = new ArrayList<>();

    public Account(Double balance, ICustomer accountOwner) {
        try {
            this.accountNum = Owner.getNextAccountNumber();
            this.accountOwner = accountOwner;
            this.accountOwner.addAccount(this);
            Owner.addAccount(this);
            this.addTransaction("New Account Deposit", balance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public Response addTransaction(String name, Double amount){
        ITransaction transaction = new Transaction(name, amount, this);

        if (transaction.getAmount() + this.balance < 0){
            return new Response(false, "Debit Transaction amount exceeds account balance.");
        }

        this.balance += transaction.getAmount();

        this.transactions.add(transaction);
        this.accountOwner.sendEmail(transaction);

        return new Response(true, "Transaction Successful!");
    }

    @Override
    public abstract void addInterest();

    public ICustomer getAccountOwner() {
        return accountOwner;
    }

    @Override
    public List<ITransaction> credits() {
        return getTransactions((tran) -> tran.getAmount() > 0.0);
    }

    @Override
    public List<ITransaction> debits() {
        return getTransactions((tran) -> tran.getAmount() < 0.0);
    }

    public List<ITransaction> transactions() {
        return transactions;
    }

    private List<ITransaction> getTransactions(Predicate<ITransaction> predicate){
        List<ITransaction> trans = new ArrayList<>();
        for (ITransaction tran : transactions){
            if (predicate.test(tran)){
                trans.add(tran);
            }
        }

        return trans;
    }

    @Override
    public String toString() {
        return "Account number: " + this.accountNum + "\n" + "Balance: " + this.balance + " \n" +
                transactions.toString();
    }
}
