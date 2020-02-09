package Account;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;


    Scanner scanner = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");


    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return this.customerNumber;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }


    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return this.pinNumber;
    }

    public double getSavingBalance() {
        return this.savingBalance;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }
    public double calcSavingDeposit(double amount) {
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount){
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from Checking Account: ");
        double amount = scanner.nextDouble();
        if ((checkingBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        }else {
            System.out.println("Balance cannot be negative");
            System.out.println();
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit from Checking Account: ");
        double amount = scanner.nextDouble();
        if ((checkingBalance + amount) >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: "+ moneyFormat.format(checkingBalance));
        }else {
            System.out.println("Balance cannot be negative");
            System.out.println();
        }
    }

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from Saving Account: ");
        double amount = scanner.nextDouble();
        if ((savingBalance - amount) >= 0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: "+ moneyFormat.format(savingBalance));
        }else {
            System.out.println("Balance cannot be negative");
            System.out.println();
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit from Saving Account: ");
        double amount = scanner.nextDouble();
        if ((savingBalance + amount) >= 0){
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: "+ moneyFormat.format(savingBalance));
        }else {
            System.out.println("Balance cannot be negative");
            System.out.println();
        }
    }



}
