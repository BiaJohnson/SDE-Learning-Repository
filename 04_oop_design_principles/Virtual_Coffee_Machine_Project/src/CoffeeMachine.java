/**
 * CoffeeMachine class represents a coffee vending machine that can make different types of coffee drinks
 * This class handles user input and creates appropriate coffee objects based on user selection
 */
import java.util.Scanner;

public class CoffeeMachine {

    /**
     * Main method that runs the coffee machine program
     * Displays menu options and handles user input to create coffee drinks
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        // Create a Scanner object to read input from keyboard
        Scanner keyboard = new Scanner(System.in);

        // Create an instance of CoffeeMaker to prepare drinks
        CoffeeMaker cafeCoffeeMaker = new CoffeeMaker();

        // Main program loop
        while (true) {
            // Display the menu options to the user
            System.out.println("\nWelcome to the Coffee Machine!");
            System.out.println("Select an option to continue:");
            System.out.println("1. Espresso");
            System.out.println("2. Latte");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");

            // Read user's menu selection
            int choice = keyboard.nextInt();

            // Process user's choice
            switch (choice) {
                case 1: // Handle Espresso order
                    // Initialize the name of Espresso
                    String espressoName = "Espresso";

                    // Initialize the price of Espresso per serving
                    double espressoPrice = 2.50;

                    // Get user input for espresso customization
                    System.out.print("What Roast would you like? (light, medium, dark): ");
                    String espressoRoast = keyboard.next();

                    System.out.print("How many servings would you like? (a number please): ");
                    int numberOfShots = keyboard.nextInt();

                    // Create new Espresso object with user specifications
                    Espresso myFavoriteEspresso = new Espresso(espressoName, espressoRoast, espressoPrice, numberOfShots);

                    // Prepare the espresso and display order details
                    cafeCoffeeMaker.prepareCoffee(myFavoriteEspresso);
                    myFavoriteEspresso.printInfo();

                    break;
                case 2: // Handle Latte order
                    // Initialize the name of Latte
                    String latteName = "Latte";

                    // Initialize the price of Latte
                    double lattePrice = 3.50;

                    // Get user input for latte customization
                    System.out.print("What Roast would you like? (light, medium, dark): ");
                    String latteRoast = keyboard.next();

                    System.out.print("What milk type would you like? (whole, skim, almond, oat): ");
                    String milkType = keyboard.next();

                    // Handle syrup options
                    System.out.print("Would you like syrup? (yes/ no): ");
                    String syrupWanted = keyboard.next();

                    String syrupFlavor = "no";
                    // If user wants syrup, get their preferred flavor
                    if(syrupWanted.equals("yes")){
                        System.out.print("Which flavor would you like? (vanilla, caramel, hazelnut): ");
                        syrupFlavor = keyboard.next();
                    }

                    // Create new Latte object with user specifications
                    Latte myFavoriteLatte = new Latte(latteName, latteRoast, lattePrice, milkType, syrupFlavor);

                    // Prepare the latte and display order details
                    cafeCoffeeMaker.prepareCoffee(myFavoriteLatte);
                    myFavoriteLatte.printInfo();

                    break;
                case 3: // Exit the program
                    System.out.println("Thank you for using the Coffee Machine!");
                    return;
                default: // Handle invalid input
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}