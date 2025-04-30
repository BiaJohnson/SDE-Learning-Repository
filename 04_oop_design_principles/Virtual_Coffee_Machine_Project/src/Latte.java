import java.util.Objects;

/**
 * Represents a Latte coffee drink that extends the base Coffee class.
 * Adds milk type and syrup flavor customization options.
 */
public class Latte extends Coffee {
    // Instance variables for milk type and syrup flavor
    private String milkType;     // Type of milk used (e.g. whole, skim, almond)
    private String syrupFlavor;  // Flavor of syrup added (e.g. vanilla, caramel)

    /**
     * Constructs a new Latte with the specified parameters.
     *
     * @param name The name of the latte
     * @param roast The roast level of the coffee beans
     * @param price The price of the latte
     * @param milkType The type of milk to use
     * @param syrupFlavor The flavor of syrup to add
     */
    public Latte(String name, String roast, double price, String milkType, String syrupFlavor) {
        // Call parent constructor with base coffee attributes
        super(name, roast, price);

        // Set latte-specific attributes
        this.milkType = milkType;
        this.syrupFlavor = syrupFlavor;
    }

    /**
     * Overrides the bean grinding process for lattes.
     * Uses a medium grind setting appropriate for lattes.
     */
    @Override
    public void grindBeans() {
        //super.grindBeans();
        System.out.println("\nGrinding coffee beans coarsely for a latte (medium grind)");
    }

    /**
     * Overrides the coffee brewing process for lattes.
     * Handles syrup flavor addition and milk steaming.
     */
    @Override
    public void brewCoffee() {
        //super.brewCoffee();
        System.out.println("Brewing coffee for a latte...");
        // Check if syrup flavor was requested
        if (syrupFlavor.equals("no")){
            System.out.println("No syrup flavor selected for coffee...");
        }else{
            System.out.println("Adding " + syrupFlavor + " syrup to the cup...");
            System.out.println("Steaming " + milkType + " milk...");
            System.out.println("Adding a layer of foam on top...");
        }
    }

    /**
     * Prints detailed information about this latte.
     * Includes base coffee info plus milk and syrup details.
     */
    @Override
    public void printInfo() {
        // Print base coffee information
        super.printInfo();

        // Print latte-specific details
        System.out.println("Your latte has " + milkType + " milk and " + syrupFlavor + " flavor.");
        System.out.println("Your total bill is " + price + "$.");
    }
}