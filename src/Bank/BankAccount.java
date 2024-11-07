package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction>transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }


    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactionHistory.add(new Transaction(new Date(), "Deposit", amount));
        System.out.println("Deposit successful. the new balance is: "+balance);
    }


    public void withdrawal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        transactionHistory.add(new Transaction(new Date(), "Withdrawal", amount));
    }

    public void displayTransactionHistory() {
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getDate() + " - " + transaction.getType() + ": $" + transaction.getAmount());
        }
    }
    public List<Transaction> getTransactionHistory( ){
        return  new ArrayList<>(transactionHistory);

    }
    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
