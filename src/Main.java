import Bank.Employee;

public class Main {
    public static void main(String[] args) {

        Employee Hamad = new Employee("HQ001","Hamad","IT manager",2000);

        System.out.println(Hamad.calculateSalary(10,20,100));
        Hamad.payment(2500,"deposit");
        Hamad.payment(2500,"withdraw");
        Hamad.displayPaymentHistory();
        Hamad.displayAccountDetails();

    }
}