/**
 * Represents a Coffee object with specific attributes and behaviors.
 * This class manages coffee properties like name, roast type, caffeine level and price,
 * and provides methods for coffee preparation and information display.
 */
public class Coffee {

    // Attributes to store information about the coffee
    /** Name of the coffee drink (e.g., "Espresso", "Latte", "Mocha") */
    String name;
    /** Roast level of the coffee beans (e.g., "light", "medium", "dark") */
    String roast;
    /** Amount of caffeine in milligrams, calculated based on the roast type */
    int caffeineLevelInMg;
    /** Price of the coffee in dollars (e.g., 2.50) */
    double price;

    /**
     * Constructor to create a new coffee object with the specified parameters.
     * Automatically calculates and sets the caffeine level based on the roast type.
     *
     * @param name  The name of the coffee drink
     * @param roast The roast level of the coffee beans
     * @param price The price of the coffee in dollars
     */
    public Coffee(String name, String roast, double price) {
        this.name = name;
        this.roast = roast;
        this.price = price;

        // The constructor calls the method to set the caffeine level based on the roast
        setCaffeineLevel();
    }

    /**
     * Sets the caffeine level of the coffee based on the roast type.
     * Light roast: 50mg
     * Medium roast: 100mg
     * Dark roast: 150mg
     * Unknown roast: 0mg
     */
    public void setCaffeineLevel() {
        if (roast.equals("light")) {
            caffeineLevelInMg = 50;
        } else if (roast.equals("medium")) {
            caffeineLevelInMg = 100;
        } else if (roast.equals("dark")) {
            caffeineLevelInMg = 150;
        } else {
            caffeineLevelInMg = 0;
        }
    }

    /**
     * Simulates the process of grinding coffee beans.
     * Prints a message indicating the grinding process for the specific coffee type.
     */
    public void grindBeans() {
        System.out.println("\nGrinding beans for " + name + "...");
    }

    /**
     * Simulates the process of brewing coffee.
     * Prints a message indicating the brewing process for the specific coffee type.
     */
    public void brewCoffee() {
        System.out.println("\nBrewing your favorite " + name + "...");
    }

    /**
     * Displays detailed information about the coffee.
     * Prints the coffee name, roast type, and caffeine level.
     */
    public void printInfo() {
        System.out.println("\nYou ordered a " + name + " with a " + roast + " roast.");
        System.out.println("The caffeine level in your coffee is " + caffeineLevelInMg + " mg.");
    }
}