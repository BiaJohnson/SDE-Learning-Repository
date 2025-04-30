/* Part 2: ChiliToGoProfit.java

Logic:
1. Initialize the adult and child meal prices and base cost in seperate variables
2. Get the number of meals on command line, handle edge case that meal quantity can not be <0 and not an integer(not integer)
3. Calculate the profit for adult and child meal, print the grand profit which is sum of both
4. Profit = quantity * (salePrice - baseCost)
*/

public class ChiliToGoProfit {
    public static void main(String[] args) {

        // Step 1: Initialize prices and costs
        double adultPrice = 7.00;
        double childPrice = 4.00;
        double adultBaseCost = 4.35;
        double childBaseCost = 3.10;

        // Step 2: Get valid input for number of meals
        int adultQuantity = validateInput("Enter the number of adult meals: ");
        int childQuantity = validateInput("Enter the number of child meals: ");

        // Step 3: Calculate total profit
        double adultProfit = adultQuantity * (adultPrice - adultBaseCost);
        double childProfit = childQuantity * (childPrice - childBaseCost);
        double totalProfit = adultProfit + childProfit;

        // Step 4: Display results
        System.out.println("Total profit for adult meals: $" + adultProfit);
        System.out.println("Total profit for child meals: $" + childProfit);
        System.out.println("Grand total profit: $" + String.format("%.2f", totalProfit));

    }

    private static int validateInput(String input) {
        int value;
        while (true) {
            System.out.print(input);
            try {
                value = Integer.parseInt(System.console().readLine());
                if (value < 0) {
                    System.out.println("Number of meals cannot be negative. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }
}