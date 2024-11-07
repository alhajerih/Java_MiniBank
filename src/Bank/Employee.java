package Bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double basicSalary;
    private List<Transaction> paymentHistory;
    private BankAccount employeeAccount;


    public Employee(String employeeId, String name, String position, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.basicSalary = basicSalary;
        this.paymentHistory = new ArrayList<>();
        this.employeeAccount=employeeAccount;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    //Make Payment
    public void payment(double amount, String type) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }
        paymentHistory.add(new Transaction(new Date(), type, amount));
    }


    public double calculateSalary(double overtime, double bonus, double deductions) {
        if (overtime < 0 || bonus < 0 || deductions < 0) {
            throw new IllegalArgumentException("Overtime, bonus, and deductions must be non-negative.");
        }
        return basicSalary + overtime + bonus - deductions;
    }

    //Print Payments
    public void displayPaymentHistory() {
        System.out.println("Payment History for Employee: " + name);
        for (Transaction transaction : paymentHistory) {
            System.out.println("Date: " + transaction.getDate() +
                    ", Type: " + transaction.getType() +
                    ", Amount: " + transaction.getAmount());
        }
    }

    public void displayAccountDetails(){
        System.out.println("Employee details:");
        System.out.println("ID: " + employeeId);
        System.out.println("name: " + name);
        System.out.println("position: "+ position);
        System.out.println("Basic salary: "+getBasicSalary());

    }
}
