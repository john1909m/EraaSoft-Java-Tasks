package Service;

import Model.Account;

public interface AccountService {
    Boolean createAccount(Account account);
    Account getAccount(Account account);
    boolean checkLoggedIn(Account account);
    Boolean deposit(Account account, double amount);
    Boolean withdraw(Account account, double amount);
    Boolean showAccountDetails(Account account);
    Boolean Transfer(Account sender,String usernameAcceptor, double amount);
    Boolean changePassword(Account account, String oldPassword, String newPassword);
    Boolean checkPassword(Account account, String password);
    Boolean deleteAccount(Account account,String password);
}
