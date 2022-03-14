package com.esther.lab.wk08;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Q2InsufficientFundsException extends Exception{
    private double amount;
    public Q2InsufficientFundsException(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
}
class CheckingAccount {
    private double balance;
    private double accountNumber;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void deposit(double amount) throws Exception{
        if (amount <=0) throw new Exception("Invalid deposit amount");
        balance += amount;
    }
    public void withdraw(double amount) throws Q2InsufficientFundsException{
        if(amount > balance) throw new Q2InsufficientFundsException(amount - balance);
    }
    public double getBalance(){
        return balance;
    }
    public double getAccountNumber(){
        return accountNumber;
    }

    public static void main(String[] args){
        try {
            Scanner input = new Scanner(System.in);
            CheckingAccount myAccount = new CheckingAccount();
            System.out.println("Deposit amount: $");
            myAccount.deposit(input.nextDouble());
            System.out.println("Withdraw amount: $");
            myAccount.withdraw(input.nextDouble());
            System.out.println("The balance after withdraw is: $" + df.format(myAccount.getBalance()));
        }
        catch(Q2InsufficientFundsException e){
            System.out.println("Sorry, your account is short by: $" + df.format(e.getAmount()));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
