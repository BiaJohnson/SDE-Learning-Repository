/* Part 1: ChiliToGo.java
Logic:
1. Initialize the adult and child meal prices in 2 variables
2. Get the number of meals on command line, handle edge case that meal quantity can not be <0 or not integer
3. Calculate Revenue for adult and child meal, print the grand total of both as the total money collected
*/

public class ChiliToGo { public static void main(String[] args) {

    double adultPrice = 7.00;
    double childPrice = 4.00;

    // Input and Validation
    int adultQuantity = validateInput("Enter the number of adult meals: ");
    int childQuantity = validateInput("Enter the number of child meals: ");

    // Calculations
    double adultTotal = adultQuantity * adultPrice;
    double childTotal = childQuantity * childPrice;
    double grandTotal = adultTotal + childTotal;

    // Output
    System.out.println("Total collected for adult meals: $" + adultTotal);
    System.out.println("Total collected for child meals: $" + childTotal);
    System.out.println("Grand total collected: $" + grandTotal);
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