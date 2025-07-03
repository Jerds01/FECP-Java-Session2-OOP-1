package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void createBankAccount(String name, String accountNumber){
        System.out.println("Account created successfully!");
    }
    public static void createBankAccount(String name, String accountNumber, int deposit){

    }
    public static void main(String[] args) {
        int choice = 0;
        String yesNo;
        String bankAccountNumber;
        String bankHolderName;
        Scanner scanner = new Scanner(System.in);
        int deposit;
        ArrayList<BankAccount> bankAccount= new ArrayList<>();



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
                    bankAccountNumber = scanner.next();
                    System.out.println("Enter Holder Number: ");
                    bankHolderName = scanner.next();
                    System.out.println("Initial Deposit? (yes/no): ");
                    yesNo = scanner.next().toLowerCase();

                    if (yesNo.equals("yes")) {
                        System.out.println("Enter initial deposit amount: ");
                        deposit = scanner.nextInt();
                        createBankAccount(bankAccountNumber, bankHolderName, deposit);
                        break;
                    }
                    createBankAccount(bankAccountNumber,bankHolderName);
                    break;


                case 2:
                    break;


                case 3:
                    break;


                case 4:
                    break;


                case 5:
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