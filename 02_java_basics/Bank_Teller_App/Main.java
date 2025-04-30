public class Main {
    public static void main(String[] args) {

        //list of people at bank listed in the order they are in line
        String[] customers ={
                "Jennifer Figueroa",
                "Heather Mcgee",
                "Amanda Schwartz",
                "Nicole Yoder",
                "Melissa Hoffman",
                "Beatrice Helman",
                "Louis Sanders",
                "Catherine Altman",
                "Ralph Estees",
                "Samantha Augustine",
                "Peter Fredricks",
                "David Alters"};

        //create teller 1 and 2 objects.
        Teller teller1 = new Teller(1);
        Teller teller2 = new Teller(2);
        //variable to hold the position of the customer in line
        int position;

        //Welcome message
        System.out.println("======================================\n" +
                "Welcome to the Bank Teller Application\n" +
                "======================================\n");

        //Start processing the line
        System.out.println("************* Processing Line *************");
        //iterate through the array containing the customers
        //start at position 1
        //teller sees every other person in line
        //so teller 1 will be assigned customers in odd positions and teller 2 will be assigned customers in even positions.
        for (int i = 0; i < customers.length; i++) {
            position = i + 1;
            if (position % 2 == 0) {
                teller2.processTransaction(customers[i], i+1);
            }else{
                teller1.processTransaction(customers[i], i+1);
            }
        }

        System.out.println("*************** End of Line ***************\n"); //end of line

        //print each tellers drawer balance and customers seen by accessing the method printTransation in teller objects.
        teller1.printTransactions();
        teller2.printTransactions();
    }
}