/**
 * The Account interface defines the basic operations for a bank account.
 */
public interface Account {
    void deposit(double amount); // Savings and Checkings account will have a deposit method.
    void withdraw(double amount); // Savings and Checkings account will have a withdrawal method.
    double calculateInterest(); // Savings and Checkings account will have a calculate interest method.
    void viewBalance(); // Savings and Checkings account will have a view balance method.
    String getAccountType(); // Savings and Checkings account will have a method that return the account type: Savings or Checkings.
}