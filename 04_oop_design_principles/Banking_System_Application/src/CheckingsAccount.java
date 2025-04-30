/**
 * The CheckingsAccount class implements the Account interface to represent a checkings account.
 * It applies 0% interest, and includes operations specific to check transactions.
 */
public class CheckingsAccount implements Account {
    private double balance;
    /**
     * Constructs a new CheckingsAccount with a zero balance.
     */
    public CheckingsAccount() {
        this.balance = 0; //starts at 0.
    }
    /**
     * Returns the type of account.
     * @return "Checkings"
     */
    @Override
    public String getAccountType() {
        return "Checkings";
    }
    /**
     * Displays the current balance.
     * For Checkings accounts, interest is 0%.
     */
    @Override
    public void viewBalance() {

        this.balance += calculateInterest();
        System.out.println("The balance in this Checkings account after interest rate of 0% is: $" + this.balance);
        System.out.println("------------------------------------------\n");
    }
    /**
     * Calculates interest for the Checkings account.
     * For Checkings, the interest rate is 0%.
     * @return 0 interest.
     */
    @Override
    public double calculateInterest() {
        //0% interest
        return this.balance* 0.00;
    }
    /**
     * Withdraws an amount from the Checkings account.
     * Displays an error if the amount exceeds the current balance.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {

        if (amount > this.balance) {
            System.out.println("Insufficient Balance to withdrawn $" + amount + " from Checkings account.");
            System.out.println("------------------------------------------\n");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawn $" + amount + " from your Checkings account.");
            System.out.println("------------------------------------------\n");
        }
    }
    /**
     * Deposits an amount into the Checkings account.
     * @param amount the amount to deposit.
     */
    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited $" + amount + " to your Checkings account.");
        System.out.println("------------------------------------------\n");
    }
    /**
     * Withdraws a check from the Checkings account.
     * Displays an error if the amount exceeds the current balance.
     * @param amount the amount of the check to withdraw
     * @param checkNumber the check number
     */
    public void withdrawCheck(double amount, int checkNumber) {
        if (amount > this.balance) {
            System.out.println("Insufficient Balance to withdrawn $" + amount + " from Checkings account.");
            System.out.println("------------------------------------------\n");
        }else{
            this.balance -= amount;
            System.out.println("Cashed check #" + checkNumber + " for $" + this.balance + " from Checkings account.");
            System.out.println("------------------------------------------\n");
        }
    }
    /**
     * Deposits a check into the Checkings account.
     * @param amount the amount of the check
     * @param checkNumber the check number
     */
    public void depositCheck(double amount, int checkNumber) {
        this.balance += amount;
        System.out.println("Deposited check #" + checkNumber + " for $" + this.balance + " to Checkings account.");
        System.out.println("------------------------------------------\n");
    }
}