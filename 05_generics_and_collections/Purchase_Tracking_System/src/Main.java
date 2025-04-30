import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Purchase> purchases = new ArrayList<>();
        double price = 0.0;

        while (true) {
            System.out.print("Enter purchase category, or enter 'exit' to end program): ");
            String category = input.nextLine();

            if (category.equalsIgnoreCase("exit")) {
                break;
            }
            if (!category.matches("^[a-zA-Z\\s]+$")) {
                System.out.println("Invalid category. Category must contain only letters and spaces. Please try again.");
                continue;
            }
            System.out.print("Enter price: $");
            try {
                price = Double.parseDouble(input.nextLine());
                // Add validation for negative price
                if (price < 0) {
                    System.out.println("Error: Price cannot be negative. Please enter a positive value.");
                    continue;
                }
                purchases.add(new Purchase(category, price));
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please try again.");
            }
        }
        PurchaseDisplay display = new PurchaseDisplay();
        display.showPurchases(purchases);
        input.close();
    }
}
