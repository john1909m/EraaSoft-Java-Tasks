import Model.Account;
import Model.EWalletSystem;
import Service.AccountService;
import Service.ApplicationService;
import Service.Impl.AccountServiceImpl;
import Service.Impl.ApplicationServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EWalletSystem eWalletSystem = new EWalletSystem();
        eWalletSystem.getAccounts().add(new Account("John", "123", "201225648451"));
        eWalletSystem.getAccounts().add(new Account("Omar", "456", "242843541"));

        AccountService accountService = new AccountServiceImpl(eWalletSystem);

        ApplicationService applicationService = new ApplicationServiceImpl(accountService);
        applicationService.startApp();









    }
}