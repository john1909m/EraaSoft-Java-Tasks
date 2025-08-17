package Service.Impl;

import Model.Account;
import Model.EWalletSystem;
import Service.AccountService;
import Service.ValidationService;

import java.util.stream.IntStream;

public class AccountServiceImpl implements AccountService {


    private EWalletSystem eWalletSystem;

    public AccountServiceImpl(EWalletSystem eWalletSystem) {
        this.eWalletSystem = eWalletSystem;
    }
    @Override
    public Boolean createAccount(Account account){
            if(eWalletSystem.getAccounts().stream().anyMatch(a -> a.getUsername().equals(account.getUsername()) || a.getPassword().equals(account.getPassword()))){
                System.out.println("❌username or password already exists");
                return false;
            }
        eWalletSystem.getAccounts().add(account);
        return true;
    };
    @Override
    public Account getAccount(Account account){
        return eWalletSystem.getAccounts().stream()
                .filter(acc -> acc.getUsername().equals(account.getUsername())
                        && acc.getPassword().equals(account.getPassword()))
                .findFirst().orElse(null);
    }
    private int accountLoggedIn = -1;
    public boolean checkLoggedIn(Account account){
//        boolean exists = false;
//        for(int i=0;i<eWalletSystem.getAccounts().size();i++){
//            if(eWalletSystem.getAccounts().get(i).getUsername().equals(account.getUsername()) && eWalletSystem.getAccounts().get(i).getPassword().equals(account.getPassword())){
//                exists = true;
//                accountLoggedIn = i;
//            }
//        }
//        return exists;
//
//    }

        return IntStream.range(0,eWalletSystem.getAccounts().size()).filter(i ->eWalletSystem.getAccounts().get(i).getUsername().equals(account.getUsername())
                && eWalletSystem.getAccounts().get(i).getPassword().equals(account.getPassword()))
                .findFirst().stream().mapToObj(i -> {
            accountLoggedIn=i;
            return true;
        }).isParallel();
    }
    @Override
    public Boolean showAccountDetails(Account account){
        if(!checkLoggedIn(account)){
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        System.out.println("_________________Profile______________________");
        System.out.println("📃Name: "+eWalletSystem.getAccounts().get(accountLoggedIn).getUsername());
        System.out.println("📱Phone Number: "+eWalletSystem.getAccounts().get(accountLoggedIn).getPhoneNumber());
        System.out.println("💷Balance: "+eWalletSystem.getAccounts().get(accountLoggedIn).getBalance()+" EGP");
        System.out.println("_______________________________________________");
        return true;
    }
    @Override
    public Boolean deposit(Account account, double amount){

        if(!checkLoggedIn(account)){
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        if(amount>0){
            eWalletSystem.getAccounts().get(accountLoggedIn).setBalance(account.getBalance()+amount);
            System.out.println("Your deposit done✅");
            System.out.println("Your account balance is "+eWalletSystem.getAccounts().get(accountLoggedIn).getBalance() +" EGP");

            return true;
        }
        return false;
    }
    @Override
    public Boolean withdraw(Account account, double amount){

        if (!checkLoggedIn(account)) {
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        if(amount>0){
            eWalletSystem.getAccounts().get(accountLoggedIn).setBalance(account.getBalance()-amount);
            System.out.println("Your Withdraw done✅");
            System.out.println("Your account balance is "+eWalletSystem.getAccounts().get(accountLoggedIn).getBalance()+" EGP");
            return  true;
        }
        return false;
    }
    @Override
    public Boolean Transfer(Account sender,String usernameAcceptor, double amount){
        if(!checkLoggedIn(sender)){
            System.out.println("😇You must be logged in to perform this operation");
            return false;
        }
        int acceptorExists=-1;
        Account acceptor = null;
        for(int i=0;i<eWalletSystem.getAccounts().size();i++){
            if(eWalletSystem.getAccounts().get(i).getUsername().equals(usernameAcceptor)){
                acceptor = eWalletSystem.getAccounts().get(i);
                acceptorExists=i;
            }

        }
        if(acceptor ==null){
            System.out.println(usernameAcceptor+" does not exist😟");
            return false;
        } else if (sender.getUsername()==usernameAcceptor) {
            System.out.println("Cannot transfer to yourself😇");
            return false;
        } else {
            if(eWalletSystem.getAccounts().get(accountLoggedIn).getBalance()>=amount){
                eWalletSystem.getAccounts().get(acceptorExists).setBalance(eWalletSystem.getAccounts().get(acceptorExists).getBalance()+amount);
                eWalletSystem.getAccounts().get(accountLoggedIn).setBalance(eWalletSystem.getAccounts().get(accountLoggedIn).getBalance()-amount);
                System.out.println("Transfer done✅");
                System.out.println("💷Your account balance now is "+sender.getBalance()+" EGP");
                return true;
            }
            else {
                System.out.println("😟insufficient balance");
                return false;
            }
        }


    }

    @Override
    public Boolean changePassword(Account account, String oldPassword, String newPassword) {
        if(!checkLoggedIn(account)){
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        if(oldPassword.equals(newPassword)){
            System.out.println("New password can't be the same old password");
            return false;
        }
        eWalletSystem.getAccounts().get(accountLoggedIn).setPassword(newPassword);
        return true;
    }

    @Override
    public Boolean checkPassword(Account account, String password) {
        if(!checkLoggedIn(account)){
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        else{
            if(password.equals(eWalletSystem.getAccounts().get(accountLoggedIn).getPassword())){
                return true;
            }
            else{
                System.out.println("Wrong password");
                return false;
            }
        }

    }

    @Override
    public Boolean deleteAccount(Account account,String password) {
        if(!checkLoggedIn(account)){
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        if(!password.equals(eWalletSystem.getAccounts().get(accountLoggedIn).getPassword())){
            System.out.println("Wrong password");
            return false;
        }
        eWalletSystem.getAccounts().remove(accountLoggedIn);
        return true;

    }


}
