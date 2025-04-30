/**
 * Represents a purchase with a category and price.
 * Implements Comparable to allow sorting purchases by category.
 */
import java.text.DecimalFormat;

class Purchase implements Comparable<Purchase> {
    // The category of the purchase (e.g. groceries, entertainment, etc)
    private String category;
    // The price of the purchase in dollars
    private double price;

    /**
     * Creates a new Purchase with the specified category and price.
     * @param category The purchase category
     * @param price The purchase price in dollars
     */
    public Purchase(String category, double price) {
        this.category = category;
        this.price = price;
    }

    /**
     * Gets the category of this purchase.
     * @return The purchase category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the price of this purchase.
     * @return The purchase price in dollars
     */
    public double getPrice() {
        return price;
    }

    /**
     * Compares this purchase to another purchase by category (case-insensitive).
     * @param other The purchase to compare to
     * @return A negative integer, zero, or positive integer if this category
     *         is less than, equal to, or greater than the other category
     */
    @Override
    public int compareTo(Purchase other) {
        return this.category.compareToIgnoreCase(other.category);
    }
    /**
     * Returns a string representation of this purchase.
     * Format: "Category: [category]     Price: $[price]"
     * Price is formatted with 2 decimal places and thousands separators.
     * @return The formatted string representation
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return String.format("Category: %-15s Price: $%s", category, df.format(price));
    }
}
