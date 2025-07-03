package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void createBankAccount(ArrayList<BankAccount> accounts ,String name, int accountNumber){
        int deposit =0;
        BankAccount newAccount = new BankAccount(accountNumber, name, deposit);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }
    public static void createBankAccount(String name, int accountNumber, int deposit){
        System.out.println("Account created successfully!");
    }

    public static void displayAllAccounts(ArrayList<BankAccount> accounts){
        int allAccountsPopulation = accounts.size();
        for (int i=0; i < allAccountsPopulation; i++){
            System.out.println("-----------------------------");
            System.out.println("Account Name: " +accounts.get(i).getAccountName());
            System.out.println("Account Number: " + accounts.get(i).getAccountNumber());
        }
    }
    public static void checkAccountBalance(int accountNumber){
        System.out.println("Account Balance");
    }

    public static void depositToAccountNumber(int accountNumber){
        System.out.println("Account Number");
    }

    public static void withdrawFromAccountNumber(int accountNumber){
        System.out.println("You have successfully withdrawn: ");
    }

    public static void main(String[] args) {
        int choice = 0;
        String yesNo;
        int bankAccountNumber;
        String bankHolderName;
        Scanner scanner = new Scanner(System.in);
        int deposit;
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
                    System.out.println("Enter Holder Name: ");
                    bankHolderName = scanner.next();
                    System.out.println("Initial Deposit? (yes/no): ");
                    yesNo = scanner.next().toLowerCase();

                    if (yesNo.equals("yes")) {
                        System.out.println("Enter initial deposit amount: ");
                        deposit = scanner.nextInt();
                        createBankAccount(bankHolderName, bankAccountNumber,deposit);
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
                    checkAccountBalance(bankAccountNumber);
                    break;


                case 4:
                    System.out.println("Enter Account Number: ");
                    bankAccountNumber = scanner.nextInt();
                    depositToAccountNumber(bankAccountNumber);
                    break;

                case 5:
                    System.out.println("Enter Account Number: ");
                    bankAccountNumber = scanner.nextInt();
                    withdrawFromAccountNumber(bankAccountNumber);
                    break;

            }
            System.out.println("Would you like to return to main menu? (yes/no)");
            yesNo = scanner.next().toLowerCase();
            if (yesNo.equals("no")){
                break;
            }


        }
    }
}