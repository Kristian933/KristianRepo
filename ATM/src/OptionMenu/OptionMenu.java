package OptionMenu;

import Account.Account;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {

    Scanner scanner = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();
    int selection;

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(111111, 1111);
                data.put(222222, 2222);
                data.put(333333, 3333);

                System.out.println("Welcome to Our ATM");
                System.out.print("Please enter your Customer Number: ");
                setCustomerNumber(scanner.nextInt());

                System.out.print("Please enter your Pin Number: ");
                setPinNumber(scanner.nextInt());
            } catch (Exception e) {
                System.out.println();
                System.out.println("Invalid character(s). Only numbers allowed.");
                System.out.println();
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println();
            System.out.println("Wrong Customer or Pin Number");
            System.out.println();
            x = 2;
        } while (x == 1);
    }

    private void getAccountType() {
        System.out.println("Select the account you want to access: ");
        System.out.println("Type 1 - Checking account");
        System.out.println("Type 2 - Saving account");
        System.out.println("Type 3 - Exit");

        selection = scanner.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using our ATM");
                System.exit(0);
                break;
            default:
                System.out.println();
                System.out.println("Invalid Choice");
                System.out.println();
                getAccountType();
        }
    }

    private void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice:");

        selection = scanner.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using our ATM");
                System.exit(0);
                break;
            default:
                System.out.println();
                System.out.println("Invalid Choice");
                System.out.println();
                getChecking();
        }
    }

    private void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice:");

        selection = scanner.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using our ATM");
                System.exit(0);
                break;
            default:
                System.out.println();
                System.out.println("Invalid Choice");
                System.out.println();
                getSaving();
        }
    }
}
