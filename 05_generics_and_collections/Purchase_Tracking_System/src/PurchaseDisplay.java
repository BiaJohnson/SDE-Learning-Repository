/**
 * A class to display purchase information grouped by category.
 * This class handles the formatting and presentation of purchase data.
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

class PurchaseDisplay {
    /**
     * Displays a list of purchases grouped and totaled by category.
     * Purchases are sorted before display (based on the Purchase class's natural ordering).
     * Each category section shows individual purchases and a category total.
     *
     * @param purchases An ArrayList of Purchase objects to be displayed
     * @throws IndexOutOfBoundsException if the purchases list is empty
     */
    public void showPurchases(ArrayList<Purchase> purchases) {
        // Initialize tracking variables for the first category
        String currentCategory = purchases.get(0).getCategory();
        double categoryTotal = 0.0;

        // Create formatter for currency amounts
        DecimalFormat df = new DecimalFormat("#,##0.00");
        // Sort purchases according to their natural ordering
        Collections.sort(purchases);

        // Print header
        System.out.println("----------------");
        System.out.println("\nPurchase Details:");
        System.out.println("----------------");

        // Iterate through purchases, grouping by category
        for (Purchase p : purchases) {
            // Check if we've moved to a new category
            if (!p.getCategory().equals(currentCategory)) {
                // Print category total and reset for new category
                System.out.println("Category Total: $" + df.format(categoryTotal));
                System.out.println();
                currentCategory = p.getCategory();
                categoryTotal = 0.0;
            }
            // Display the current purchase
            System.out.println(p);
            categoryTotal += p.getPrice();
        }
        // Print the total for the final category
        System.out.println("Category Total: $" + df.format(categoryTotal));
    }
}
