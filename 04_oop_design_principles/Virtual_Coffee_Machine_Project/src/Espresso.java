/**
 * Represents an Espresso coffee drink that extends the base Coffee class.
 * This class adds functionality specific to espresso preparation and serving.
 */
public class Espresso extends Coffee {

    /** Number of espresso shots ordered */
    private int numberOfShots;

    /**
     * Constructs a new Espresso object
     * @param name The name of the espresso drink
     * @param roast The roast level of the coffee beans
     * @param price The price per shot
     * @param numberOfShots The number of espresso shots
     */
    public Espresso(String name, String roast, double price, int numberOfShots) {
        // Call parent constructor to initialize base attributes
        super(name, roast, price);

        // Set the number of shots for this espresso order
        this.numberOfShots = numberOfShots;
    }

    /**
     * Overrides the base grind method to use fine grinding required for espresso
     */
    @Override
    public void grindBeans() {
        //super.grindBeans();
        System.out.println("\nGrinding the espresso beans finely…");
    }

    /**
     * Overrides the base brew method to use high pressure brewing for espresso
     */
    @Override
    public void brewCoffee() {
        //super.brewCoffee();
        System.out.println("Brewing the espresso under high pressure...");
    }

    /**
     * Prints information about the espresso order including number of shots and total price
     * Extends the base class printInfo method
     */
    @Override
    public void printInfo() {
        // Call parent printInfo first
        super.printInfo();

        // Print espresso-specific details
        System.out.println("You asked for " + numberOfShots + " servings!");
        System.out.println("Every serving of Espresso costs " + price + "$. Your total bill is " + (price * numberOfShots) + "$.");
    }
}