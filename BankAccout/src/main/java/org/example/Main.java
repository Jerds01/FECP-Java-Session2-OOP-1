package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void createBankAccount(ArrayList<BankAccount> accounts ,String name, int accountNumber){
        double deposit =0;
        double balance = 0;
        BankAccount newAccount = new BankAccount(accountNumber, name, deposit, balance);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }
    public static void createBankAccount(ArrayList<BankAccount> accounts, String name, int accountNumber, double deposit){
        double balance = deposit;
        BankAccount newAccount = new BankAccount(accountNumber, name, deposit, balance);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    public static boolean isExistingAccount(ArrayList<BankAccount> accounts, int accountNumber){
        int allAccountsPopulation = accounts.size();
        for (int i=0; i < allAccountsPopulation; i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                return true;
            }
        }
        return false;
    }

    public static void displayAllAccounts(ArrayList<BankAccount> accounts){
        int allAccountsPopulation = accounts.size();
        for (int i=0; i < allAccountsPopulation; i++){
            System.out.println("-----------------------------");
            System.out.println("Account Name: " +accounts.get(i).getAccountName());
            System.out.println("Account Number: " + accounts.get(i).getAccountNumber());
        }
    }
    public static void checkAccountBalance(ArrayList<BankAccount> accounts, int accountNumber){
        int allAccountsPopulation = accounts.size();
        for (int i=0; i < allAccountsPopulation; i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                System.out.println("-----------------------------");
                System.out.println("Account Name: " +accounts.get(i).getAccountName());
                System.out.println("Account Balance: " + accounts.get(i).getBalance());
            }

        }
        System.out.println("Account Balance");
    }

    public static void depositToAccountNumber(ArrayList<BankAccount> accounts, int accountNumber, double deposit){
        int allAccountsPopulation = accounts.size();
        double balance;
        for (int i=0; i < allAccountsPopulation; i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                balance = accounts.get(i).getBalance() + deposit;
                accounts.get(i).setBalance(balance);
                System.out.println("-----------------------------");
                System.out.println("Account Name: " +accounts.get(i).getAccountName());
                System.out.println("Account Balance: " + accounts.get(i).getBalance());
            }

        }
    }

    public static void withdrawFromAccountNumber(ArrayList<BankAccount> accounts,double withdrawAmount ,int accountNumber){
        int allAccountsPopulation = accounts.size();
        double balance;
        for (int i=0; i < allAccountsPopulation; i++){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                balance = accounts.get(i).getBalance() - withdrawAmount;
                if (balance < 1){
                    System.out.println("You do not have enough balance!");
                    return;
                }
                accounts.get(i).setBalance(balance);
                System.out.println("-----------------------------");
                System.out.println("Account Name: " +accounts.get(i).getAccountName());
                System.out.println("Account Balance: " + accounts.get(i).getBalance());
            }

        }
        System.out.println("You have successfully withdrawn: "+withdrawAmount);
    }

    public static void main(String[] args) {
        int choice = 0;
        String yesNo;
        int bankAccountNumber;
        String bankHolderName;
        Scanner scanner = new Scanner(System.in);
        double deposit;
        ArrayList<BankAccount> bankAccounts= new ArrayList<>();



        while (choice != 6){
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1, Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.println("Enter choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter Account Number: ");
                    bankAccountNumber = scanner.nextInt();

                    if (isExistingAccount(bankAccounts, bankAccountNumber)){
                        System.out.println("Account number already exists!");
                        break;
                    }
                    System.out.println("Enter Holder Name: ");
                    bankHolderName = scanner.next();
                    System.out.println("Initial Deposit? (yes/no): ");
                    yesNo = scanner.next().toLowerCase();

                    if (yesNo.equals("yes")) {
                        System.out.println("Enter initial deposit amount: ");
                        deposit = scanner.nextDouble();
                        if (deposit < 1){
                            System.out.println("Deposit amount must be greater than 1");
                            break;
                        }
                        createBankAccount(bankAccounts,bankHolderName, bankAccountNumber,deposit);
                        break;
                    }
                    createBankAccount(bankAccounts,bankHolderName,bankAccountNumber);
                    break;


                case 2:
                    displayAllAccounts(bankAccounts);
                    break;

                case 3:
                    System.out.println("Enter Account Number: ");
                    bankAccountNumber = scanner.nextInt();
                    checkAccountBalance(bankAccounts, bankAccountNumber);
                    break;



                case 4:
                    System.out.println("Enter Account Number: ");
                    bankAccountNumber = scanner.nextInt();
                    if(!isExistingAccount(bankAccounts,bankAccountNumber)){
                        System.out.println("Bank account does not exist");
                        break;
                    }
                    System.out.println("Enter Deposit Amount:");
                    deposit = scanner.nextDouble();
                    if (deposit < 1){
                        System.out.println("Deposit amount must be greater than 1");
                        break;
                    }
                    depositToAccountNumber( bankAccounts, bankAccountNumber, deposit);
                    break;
                case 5:
                    System.out.println("Enter Account Number: ");
                    bankAccountNumber = scanner.nextInt();
                    if(!isExistingAccount(bankAccounts, bankAccountNumber)){
                        System.out.println("Bank account does not exist");
                        break;
                    }
                    System.out.println("Enter Withdraw Amount: ");
                    double withdrawAmount = scanner.nextInt();

                    withdrawFromAccountNumber(bankAccounts,withdrawAmount,bankAccountNumber);
                    break;

            }
            if (choice!= 6){
                System.out.println("Would you like to return to main menu? (yes/no)");
                yesNo = scanner.next().toLowerCase();
                if (yesNo.equals("no")){
                    break;
                }
            }



        }
    }
}