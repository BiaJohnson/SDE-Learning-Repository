import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * The BakingSystem class is the entry point for the banking application.
 * It provides a text-based menu that allows users to create accounts,
 * view balances, deposit, and withdraw cash or check using various operations.
 */
public class BakingSystem {
    /**
     * The main method runs the banking system.
     */
    public static void main(String[] args) {

        // Create a Scanner object for reading user input.
        Scanner sc = new Scanner(System.in);
        // Create a Bank object to manage accounts.
        Bank bank = new Bank();

        // Predefined account types and operation options.
        String savingsType = "Savings";
        String checkingsType = "Checkings";
        String balance= "view balance";
        String cashWithdrawal = "withdrawal cash";
        String cashDeposit = "deposit cash";
        String checkWithdrawal = "withdrawal check";
        String checkDeposit= "deposit check";
        int input =0;


        System.out.println("****** Welcome to BakingSystem ******\n");
        /*
         * Display Menu options
         */
        // While loop to validate entry.
        while(true) {
            try {
                System.out.println("Please select your choice (1-12):\n");
                System.out.println("Create new accounts:");
                System.out.println("\t1 - Create a new Savings account.");
                System.out.println("\t2 - Create a new Checkings account.");
                System.out.println("View Balance:");
                System.out.println("\t3 - View Savings account balance.");
                System.out.println("\t4 - View Checkings account balance.");
                System.out.println("\t5 - View all accounts balance.");
                System.out.println("Deposit:");
                System.out.println("\t6 - Deposit cash at Savings account.");
                System.out.println("\t7 - Deposit cash at Checkings account.");
                System.out.println("\t8 - Deposit a check.");
                System.out.println("Withdrawal:");
                System.out.println("\t9 - Withdrawal cash from Savings account.");
                System.out.println("\t10 - Withdrawal cash from Checkings account.");
                System.out.println("\t11 - Withdrawal a check.");
                System.out.println("End program:");
                System.out.println("\t12 - Exit");
                // Read the user's menu selection.
                input = sc.nextInt();
                // Check if the input is within the valid range.
                if (input < 1 || input > 12) {
                    System.out.println("Option out of range.");
                }
            }catch (InputMismatchException e){
                // Handle invalid (non-integer) input.
                System.out.println("Invalid input!\n");
                sc.nextLine(); // Clear invalid input
            }
            /*
             * Process the user's selection.
             */
            // Option 1: Create a new Savings Account.
            if (input == 1) {
                SavingsAccount savings = new SavingsAccount();
                bank.addAccount(savings);
                System.out.println("Savings Account created!");
                System.out.println("------------------------------------------\n");
            }
            // Option 2: Create a new Checkings Account.
            else if (input == 2) {
                CheckingsAccount checkings = new CheckingsAccount();
                bank.addAccount(checkings);
                System.out.println("Checkings Account created!");
                System.out.println("------------------------------------------\n");
            }
            // Option 3: View balance for Savings accounts.
            else if (input == 3) {
                bank.printAccounts(savingsType, balance);
            }
            // Option 4: View balance for Checkings accounts.
            else if (input == 4) {
                bank.printAccounts(checkingsType, balance);
            }
            // Option 5: View balance for all accounts.
            else if (input == 5) {
                bank.viewAllBalances();
            }
            // Option 6: Deposit cash into a Savings account.
            else if (input == 6) {
                bank.printAccounts(savingsType, cashDeposit);
            }
            // Option 7: Deposit cash into a Checkings account.
            else if (input == 7) {
                bank.printAccounts(checkingsType, cashDeposit);
            }
            // Option 8: Deposit a check into a Checkings account.
            else if (input == 8) {
                bank.printAccounts(checkingsType, checkDeposit);
            }
            // Option 9: Withdraw cash from a Savings account.
            else if (input == 9) {
                bank.printAccounts(savingsType, cashWithdrawal);
            }
            // Option 10: Withdraw cash from a Checkings account.
            else if (input == 10) {
                bank.printAccounts(checkingsType, cashWithdrawal);
            }
            // Option 11: Withdraw a check from a Checkings account.
            else if (input == 11) {
                bank.printAccounts(checkingsType, checkWithdrawal);
            }
            // Option 12: Exit the program.
            else if (input == 12) {
                System.out.println("Exiting program. Goodbye!");
                break;  // Exits the loop
            }
        }
        // Close the scanner once the loop is exited.
        sc.close();
    }
}