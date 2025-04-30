import java.util.ArrayList; //import array list
import java.util.List;

//class to hold the tellers
public class Teller {
    //each teller will have an ID, a balance in their drawer and a list containing customers.
    int tellerID;
    double balance;
    List<String> tellerTransactions = new ArrayList<>();//array list containing the customers each teller processed.

    public Teller(int tellerID) {
        this.tellerID = tellerID;
        this.balance = 2500.0; //each teller starts the day with 2500$
    }

    //method to process the transactions
    public void processTransaction(String customerName, int customerPosition) {

        double[] amount = {250.0, 475.0, 100.0}; // list containing the transaction amount options.

        //if statement to check the customer position and complete the transaction based on the position.
        // To accommodate growth: every 15th person will be in both position 3 and 5, so they will both deposit 475 and withdraw 250.
        if(customerPosition % 15 == 0){
            balance += (amount[1] - amount[0]); //update the teller drawer balance
            System.out.println("Customer " + customerName + " deposited $" + amount[1] + " and withdrew " + amount[0] + " from account.");//print the customer name and transaction
        }else if(customerPosition % 3 == 0) {
            balance -= amount[0]; //update the teller drawer balance
            System.out.println("Customer " + customerName + " withdrew $" + amount[0] + " from account.");//print the customer name and transaction
        }else if(customerPosition % 5 == 0) {
            balance += amount[1]; //update the teller drawer balance
            System.out.println("Customer " + customerName + " deposited $" + amount[1] + " in account.");//print the customer name and transaction
        }else{
            balance += amount[2]; //update the teller drawer balance
            System.out.println("Customer " + customerName + " deposited $" + amount[2] + " in account.");//print the customer name and transaction
        }

        tellerTransactions.add(customerName);// update teller's list with the customer name they saw.

    }

    //method to print the transactions
    public void printTransactions() {

        System.out.println("********** Teller " + tellerID + " **********"); // show information for teller
        System.out.println("The total money in Teller" + tellerID +"'s drawer is: $" + balance); //show teller drawer amount
        System.out.println("The following were the Teller" + tellerID +"'s customers:"); //start printing tellers customers

        for (String customer: tellerTransactions) { //print customers in array list.
            System.out.println(customer);
        }
        System.out.println("******************************\n"); //end
    }
}