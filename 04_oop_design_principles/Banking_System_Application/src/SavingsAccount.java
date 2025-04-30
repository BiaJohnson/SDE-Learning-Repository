/**
 * The SavingsAccount class implements the Account interface to represent a savings account.
 * It applies a 2% interest rate.
 */
public class SavingsAccount implements Account {
    private double balance;
    /**
     * Constructs a new SavingsAccount with a zero balance.
     */
    public SavingsAccount() {
        this.balance = 0; //starts at 0.
    }
    /**
     * Returns the type of account.
     * @return "Savings"
     */
    @Override
    public String getAccountType() {
        return "Savings";
    }
    /**
     * Deposits an amount into the savings account.
     * @param amount the amount to deposit
     */
    @Override
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited $" + amount + " to your Savings account.");
        System.out.println("------------------------------------------\n");
    }
    /**
     * Withdraws an amount from the savings account.
     * If the amount exceeds the current balance, an error message is displayed.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient Balance to withdrawn $" + amount + " from Savings account.");
            System.out.println("------------------------------------------\n");
        }else{
            this.balance -= amount;
            System.out.println("Withdrawn $" + amount + " from your Savings account.");
            System.out.println("------------------------------------------\n");
        }
    }
    /**
     * Calculates 2% interest on the current balance.
     * @return the interest amount
     */
    @Override
    public double calculateInterest() {
        //2% interest
        return this.balance * 0.02;
    }
    /**
     * Displays the current balance after adding the calculated interest.
     */
    @Override
    public void viewBalance() {
        calculateInterest();
        this.balance += calculateInterest();
        System.out.println("The balance in this Savings account after interest rate of 2% is: $" + this.balance);
        System.out.println("------------------------------------------\n");
    }
}