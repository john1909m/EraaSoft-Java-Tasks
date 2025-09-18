package Service.Impl;

import Model.Account;
import Model.EWalletSystem;
import Service.AccountService;
import Service.ApplicationService;
import Service.ValidationService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {
    Scanner scanner = new Scanner(System.in);

    private AccountService accountService;
    private EWalletSystem eWalletSystem;
    private ValidationService validationService=new ValidationServiceImpl();
    public ApplicationServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void startApp() {
        System.out.println("-------------------Welcome to " +EWalletSystem.getName()+ "----------------------");
        System.out.println("====================================================================================");
        int errorCount=0;

        while (true) {
            Boolean isExit = false;
            System.out.println("-------Please Choose Your Option--------");
            System.out.println("_____________");
            System.out.println("1. Login    |");
            System.out.println("2. Register |");
            System.out.println("3. Exit     |");
            System.out.println("_____________");


            int choice=0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌invalid input");
            }
            switch (choice){
                case 1:{
                    System.out.println("----------------Login-------------");
                    System.out.println("==================================");
                    login();
                    break;
                }
                case 2:{
                    System.out.println("----------Register ---------------");
                    System.out.println("==================================");

                    register();
                    break;
                }
                case 3:{
                    System.out.println("---------Have a nice day-------------");
                    System.out.println("=====================================");
                    isExit = true;
                    break;
                }
                default:{
                    System.out.println("===================");
                    System.out.println("❌Invalid choice");
                    System.out.println("===================");
                    errorCount++;
                    break;
                }

            }

            if (errorCount==4){
                System.out.println("👋Try again later");
                return;
            }
            if (isExit){
                return;
            }
        }
    }
    private void register() {
        String username,password,phoneNumber;
        while (true){
            System.out.println("-Please enter your username:");
            username=scanner.nextLine();
            if(validationService.validateName(username)){
                break;
            }
            else {
                System.out.println("❕username must be more than 3 characters & first letter must be CAPITAL❕");

            }

        }
        while (true){
            System.out.println("-Please enter your password:");
            password=scanner.nextLine();
            if(validationService.validatePassword(password)){
                break;
            }
            else {
                System.out.println("❕password must be more than 8 characters & must contain lowercase letters & must contain uppercase letters & must contain special characters❕");

            }
        }
        while (true){
            System.out.println("-Please enter your phone number:");
            phoneNumber=scanner.nextLine();
            if(validationService.validatePhoneNumber(phoneNumber)){
                break;
            }else {
                System.out.println("Enter a Valid Phone Number starts with '20' ");
            }
        }
        Account account = new Account(username,password,phoneNumber);
        if(accountService.createAccount(account)){
            System.out.println("🥳Account created successfully");
            System.out.println("==================================");

        }
        else {
            System.out.println("==================================");

        }

    }
    private void login() {
        String username,password;
        System.out.println("-Please enter your username:");
        username=scanner.nextLine();
        System.out.println("-Please enter your password:");
        password=scanner.nextLine();
        Account account=new Account(username,password);
        account=accountService.getAccount(account);
        if(Objects.nonNull(account)){
            System.out.println("==================================");
            System.out.println("Welcome back "+account.getUsername());
            System.out.println("==================================");
            loginFeatures(account);
        }
        else {
            System.out.println("invalid username or password");
        }
    }

    private void loginFeatures(Account account) {
        int counter = 4;
        boolean isUserLogout = false;
        while (counter != 0) {
            System.out.println("please choose.");
            System.out.println("_______________________________");
            System.out.println("1. ➕Deposit                  |");
            System.out.println("2. ➖Withdraw                 |");
            System.out.println("3. 📃Show Account Details     |");
            System.out.println("4. ↔️Transfer                 |");
            System.out.println("5. 🔑Change Password          |");
            System.out.println("6. 💣Delete Account           |");
            System.out.println("0. ↩️Logout                   |");
            System.out.println("_______________________________");

            int choose = 0;
            try {
                choose = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌invalid input");
            }

            switch (choose) {
                case 1:
                    deposit(account);
                    System.out.println("=====================================");
                    break;
                case 2:
                    withdraw(account);
                    System.out.println("=====================================");

                    break;
                case 3:
                    showAccountDetails(account);

                    break;
                case 4:
                    transfer(account);
                    System.out.println("=====================================");
                    break;
                case 5:
                    changePassword(account);
                    System.out.println("===================================");
                    break;
                case 6:
                    if (deleteAccount(account)){
                        isUserLogout = true;
                    }
                    System.out.println("===================================");
                    break;
                case 0:
                    System.out.println("Have a nice Day 😇");
                    isUserLogout = true;
                    startApp();
                    break;

                default:
                    counter--;
                    System.out.println("❌Invalid choose");
            }
            if (counter == 0){
                System.out.println("❌multi invalid choose please try later.");
            }

            if (isUserLogout) {
                break;
            }
        }
    }

    private Boolean deleteAccount(Account account) {
        System.out.println("Please enter your password:");
        String password=scanner.nextLine();
        if(accountService.deleteAccount(account,password)){
            System.out.println("Account deleted successfully");
            return true;
        }
        else {
            System.out.println("Failed to delete account");
            return false;
        }
    }

    private void changePassword(Account account) {
        String oldPassword,newPassword;
        System.out.println("-------Change Password-------");

        while (true){
            System.out.println("Please enter the old password:");
            oldPassword=scanner.nextLine();
            if (accountService.checkPassword(account,oldPassword)){
                break;
            }
        }
        while (true){
            System.out.println("Please enter the new password:");
            newPassword=scanner.nextLine();
            if(validationService.validatePassword(newPassword) && accountService.changePassword(account,oldPassword,newPassword)){
                break;
            }
            else if(!accountService.changePassword(account,oldPassword,newPassword)){
                System.out.println("Failed to change password");
            }
            else {
                System.out.println("❕password must be more than 8 characters & must contain lowercase letters & must contain uppercase letters & must contain special characters❕");

            }
        }
        System.out.println("Password changed successfully");


    }

    private void deposit(Account account) {
        System.out.println("-------Deposit-------");
        System.out.println("==========================");
        System.out.println("Please enter amount to deposit:");
        double amount = 0;
        try {
            amount = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("❌invalid input");
        }
        accountService.deposit(account,amount);
    }
    public void withdraw(Account account) {
        System.out.println("-------Withdraw-------");
        System.out.println("==========================");
        System.out.println("Please enter amount to withdraw:");
        double amount = 0;
        try {
            amount = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("❌invalid input");

        }
        accountService.withdraw(account,amount);
    }
    public void showAccountDetails(Account account) {
        System.out.println("=================================");
        accountService.showAccountDetails(account);
    }
    public void transfer(Account account) {
        System.out.println("-------Transfer-------");
        System.out.println("==========================");
        System.out.println("Please enter amount to transfer:");
        double amount = scanner.nextDouble();
        try {
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("invalid input");
        }
        System.out.println("Enter the username of the acceptor:");
        String usernameAcceptor = scanner.nextLine();
        accountService.Transfer(account,usernameAcceptor,amount);
    }

}
