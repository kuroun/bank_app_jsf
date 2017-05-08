package service;

import java.util.Collection;

import converter.FullName;
import model.Account;



public interface IAccountService {
//    public String createAccount(long accountNumber, String customerName);
    public String createAccount(long accountNumber, FullName customerName);
    public String getAccount(long accountNumber);
    public Collection<Account> getAllAccounts();
    public String deposit (long accountNumber, double amount);
    public String withdraw (long accountNumber, double amount);
    public void depositEuros (long accountNumber, double amount);
    public void withdrawEuros (long accountNumber, double amount);
    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
