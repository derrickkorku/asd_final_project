package framework.transaction;

import framework.account.IAccount;

import java.time.LocalDate;

public interface ITransaction {
    public Double getAmount();
    public LocalDate getDate();
    public String getName();
    public IAccount getAccount();
}
