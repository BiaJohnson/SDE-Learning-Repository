/**
 * A class that handles the coffee preparation process.
 */
public class CoffeeMaker {

    /**
     * Prepares coffee by executing the required steps in sequence.
     *
     * @param coffee The Coffee object to be prepared
     */
    public void prepareCoffee(Coffee coffee) {
        // First grind the coffee beans
        coffee.grindBeans();

        // Then brew the ground coffee
        coffee.brewCoffee();

    }
}