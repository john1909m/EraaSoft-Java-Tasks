package Model;

import java.util.ArrayList;
import java.util.List;

public class EWalletSystem {
    private static final String name="EWalletSystem";
    private List<Account> accounts=new ArrayList<>();
    public static String getName() {
        return name;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }




}
