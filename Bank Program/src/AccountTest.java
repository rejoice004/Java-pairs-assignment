import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

abstract class Bank{
    protected String accountname;
    protected double balance;

    public Bank(String accountname, double balance){
        this.accountname = accountname;
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract double getBalance();
 
    protected void logTransaction(String message) {
        try (FileWriter writer = new FileWriter("Bank.txt", true)) {
            writer.write(LocalDateTime.now() + "-" + accountname + ": " + message + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}

class Account extends Bank{

    public Account(String accountname, double balance) {
        super(accountname, balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            logTransaction("Deposited " + amount + ". New Balance is: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
            logTransaction("Deposit procedure has failed: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn is: " + amount);
            logTransaction("Amount withdrawn is: " + amount + ". New balance is: " + balance);
        } else {
            System.out.println("Withdrawal amount has exceeded account balance");
            logTransaction("Withdrawal attempt has failed: " + amount);
        }
    }

    public double getBalance() {
        logTransaction("Remaining balance is: " + balance);
        return balance;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account("Nigel Rushwaya", 2000);
        account1.deposit(500);
        System.out.println("Balance after deposit is: " + account1.getBalance());

        account1.withdraw(2000);
        System.out.println("Balance after withdrawal: " + account1.getBalance());

        account1.withdraw(800);
        System.out.println("Balance after withdrawal: " + account1.getBalance());

        account1.deposit(-100);
        System.out.println("Final balance is: " + account1.getBalance());
    }
}
