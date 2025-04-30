import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Get and process string inputs
        Pair<String> stringPair = getStringInputs();
        processValues("Strings", stringPair);

        // Get and process integer inputs
        Pair<Integer> integerPair = getIntegerInputs();
        processValues("Integers", integerPair);

        scanner.close();
    }

    /**
     * Gets two string inputs from the user with error handling
     * @return Pair of strings
     */
    private static Pair<String> getStringInputs() {
        System.out.println("\nEnter two strings:");
        String first = getStringInput("first string");
        String second = getStringInput("second string");
        return new Pair<>(first, second);
    }

    /**
     * Gets two integer inputs from the user with error handling
     * @return Pair of integers
     */
    private static Pair<Integer> getIntegerInputs() {
        System.out.println("\nEnter two integers:");
        Integer first = getIntegerInput("first integer");
        Integer second = getIntegerInput("second integer");
        return new Pair<>(first, second);
    }

    /**
     * Gets string input with specific error handling
     * @param inputName Name of the input for messages
     * @return The validated string input
     */
    private static String getStringInput(String inputName) {
        while (true) {
            try {
                System.out.print("Enter " + inputName + ": ");
                String input = scanner.nextLine();
                
                if (input.trim().isEmpty()) {
                    System.out.println("Error: " + inputName + " cannot be empty. Please enter some text.");
                    continue;
                }
                
                return input;
                
            } catch (Exception e) {
                System.out.println("Error: An unexpected error occurred while reading " + 
                                 inputName + ". Please try again.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * Gets integer input with specific error handling
     * @param inputName Name of the input for messages
     * @return The validated integer input
     */
    private static Integer getIntegerInput(String inputName) {
        while (true) {
            try {
                System.out.print("Enter " + inputName + ": ");
                String input = scanner.nextLine();
                
                // Check for empty input
                if (input.trim().isEmpty()) {
                    System.out.println("Error: " + inputName + " cannot be empty. Please enter a number.");
                    continue;
                }
                
                // Try to parse the integer
                int number = Integer.parseInt(input);
                
                // Additional validation could be added here if needed
                // For example, checking for positive numbers, range limits, etc.
                
                return number;
                
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + scanner.nextLine().trim() + 
                                 "' is not a valid integer. Please enter a whole number.");
            } catch (Exception e) {
                System.out.println("Error: An unexpected error occurred while reading " + 
                                 inputName + ". Please try again.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    /**
     * Generic method to process and display values
     * @param type Type of values being processed
     * @param pair Pair of values to process
     */
    private static <T> void processValues(String type, Pair<T> pair) {
        SwapProcessor<T> processor = new SwapProcessor<>();
        System.out.println("\nProcessing " + type + ":");
        processor.processAndSwap(pair);
    }
}
