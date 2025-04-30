import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The Bank class represents a bank that manages multiple accounts.
 * It provides methods to add accounts, print account details (with various operations),
 * and view the balances of all accounts.
 */
public class Bank {
    private final ArrayList<Account> accounts;
    /**
     * Constructs a new Bank with an empty list of accounts.
     */
    public Bank() {
        this.accounts = new ArrayList<>();
    }
    /**
     * Adds an account to the bank.
     * @param account the account to be added.
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    /**
     * printAccounts performs operations on accounts of a specified type.
     * It prints a list of accounts that match the provided account type and then prompts the user to select one.
     * Based on the specified option, it performs the appropriate operation (view balance, deposit cash, withdrawal
     * cash, deposit check, or withdrawal check).
     * Deposit check and  withdrawal check are only available for Checkings accounts.
     * @param accountType the type of account ("Savings" or "Checkings")
     * @param option the operation option (e.g., "view balance", "deposit cash", "withdrawal cash", "deposit check", "withdrawal check")
     */
    public void printAccounts(String accountType, String option){

        int i = 1; // To loop through the array list.
        Scanner sc = new Scanner(System.in);
        double amount; // To hold the amount of money to be deposited or withdraw.
        int checkNumber= 0; // To hold the check number.
        int choice; // To hold the account chose.
        /*
         * Check if there are any accounts.
         */
        if (accounts.isEmpty()) {
            System.out.println("There are no " + accountType + " accounts");
            System.out.println("------------------------------------------\n");
            return;
        } else{
            // Print accounts of the specified type.
            System.out.println("The following are your " + accountType + " accounts.");
            System.out.println("Please insert the number of the " + accountType + " account you would like to " + option + ":\n");
            // Print only the accounts that matches the account types: Savings of Checkings.
            for (Account account : this.accounts) {
                if (account.getAccountType().equals(accountType)) {
                    System.out.println("Account " + i);
                }
                i++;
            }
            System.out.println(""); //just to print an empty line for aesthetic purposes.
        }
        /*
         * Validate account selection using a while loop
         */
        while (true) {
            try {
                // Enter the desired account number to perform the operation.
                System.out.print("Enter account number: ");
                choice = sc.nextInt();
                // Validate the entry is within the range.
                if (choice < 1 || choice > i) {
                    System.out.println("Account number out of range. Please try again.");
                } else {
                    break; // Break loop if is a valid input.
                }
            } catch (InputMismatchException e) {
                // Handle invalid (non-integer) input.
                System.out.println("Invalid input. Please enter a valid integer for account number.");
                sc.nextLine(); // Clear the invalid input
            }
        }
        /*
         * Process the operation chosen: view balance, deposit cash, deposit check, withdraw cash or withdraw check.
         * Validate amount entered for each operation.
         */
        // Operation: view balance.
        if (option.contains("balance")) {
            // View Balance for the selected account.
            accounts.get(choice - 1).viewBalance();
            // Operation: deposit cash.
        } else if (option.contains("deposit cash")) {
            // Validate deposit amount
            while (true) {
                try {
                    System.out.print("Please enter the amount you would like to deposit: ");
                    amount = sc.nextDouble();
                    break; // Break loop if valid amount is entered.
                } catch (InputMismatchException e) {
                    // Handle invalid (non-integer) input.
                    System.out.println("Invalid input for amount. Please enter a valid number.");
                    sc.nextLine(); //Clear the invalid input
                }
            }
            // Deposit amount for the selected account.
            accounts.get(choice - 1).deposit(amount);
            // Operation: withdraw cash.
        } else if (option.contains("withdrawal cash")) {
            // Validate withdrawal amount
            while (true) {
                try {
                    System.out.print("Please enter the amount you would like to withdraw: ");
                    amount = sc.nextDouble();
                    break; // Break loop if valid amount is entered.
                } catch (InputMismatchException e) {
                    // Handle invalid (non-integer) input.
                    System.out.println("Invalid input for amount. Please enter a valid number.");
                    sc.nextLine(); //Clear the invalid input
                }
            }
            // Withdraw amount for the selected account.
            accounts.get(choice - 1).withdraw(amount);
            // Operation: deposit check (which is only possible for checkings account).
        } else if (option.contains("deposit check")) {
            // Validate check amount
            while (true) {
                try {
                    System.out.print("Please enter the check amount to deposit: ");
                    amount = sc.nextDouble();
                    break; // Break loop if valid amount is entered.
                } catch (InputMismatchException e) {
                    // Handle invalid (non-integer) input.
                    System.out.println("Invalid input for check amount. Please enter a valid number.");
                    sc.nextLine(); //Clear the invalid input
                }
            }
            // Validate the check number.
            while (true) {
                try {
                    System.out.print("Please enter the check number: ");
                    checkNumber = sc.nextInt();
                    break; // Break loop if valid number is entered.
                } catch (InputMismatchException e) {
                    // Handle invalid (non-integer) input.
                    System.out.println("Invalid input for check number. Please enter a valid integer.");
                    sc.nextLine(); // Clear invalid input.
                }
            }
            // Downcast to CheckingsAccount, since depositCheck is specific to it.
            ((CheckingsAccount) accounts.get(choice - 1)).depositCheck(amount, checkNumber);
            // Operation: withdraw check (which is only possible for checkings account).
        } else if (option.contains("withdrawal check")) {
            // Validate check withdrawal amount
            while (true) {
                try {
                    System.out.print("Please enter the check amount to withdraw: ");
                    amount = sc.nextDouble();
                    break; // Break loop if valid amount is entered.
                } catch (InputMismatchException e) {
                    // Handle invalid (non-integer) input.
                    System.out.println("Invalid input for check withdrawal amount. Please enter a valid number.");
                    sc.nextLine(); // Clear invalid input.
                }
            }
            // Validate the check number.
            while (true) {
                try {
                    System.out.print("Please enter the check number: ");
                    checkNumber = sc.nextInt();
                    break; // Break loop if valid number is entered.
                } catch (InputMismatchException e) {
                    // Handle invalid (non-integer) input.
                    System.out.println("Invalid input for check number. Please enter a valid integer.");
                    sc.nextLine(); // Clear invalid input.
                }
            }
            // Downcast to CheckingsAccount for withdrawCheck.
            ((CheckingsAccount) accounts.get(choice - 1)).withdrawCheck(amount, checkNumber);
        }
    }
    /**
     * Displays the balances for all accounts managed by the bank.
     */
    public void viewAllBalances() {

        int i = 1; // To display the accounts (starting at 1).
        System.out.println("The following are the balance for all accounts:");
        for (Account account : this.accounts) {
            System.out.println("Account " + i + " :");
            // Display the balance for the account.
            account.viewBalance();
            i++;
        }
    }
}