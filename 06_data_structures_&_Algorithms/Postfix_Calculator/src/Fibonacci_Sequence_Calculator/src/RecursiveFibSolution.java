import java.util.Scanner;

/**
 * A class that calculates Fibonacci numbers using recursion with memoization.
 * This implementation uses a cache to store previously calculated Fibonacci numbers
 * to improve performance.
 */
public class RecursiveFibSolution {

    // Cache to store calculated Fibonacci numbers to avoid recalculating
    private static long[] fibonacciCache;

    /**
     * Main method that handles user input and displays Fibonacci numbers.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean validInput = false;

        // Keep asking for input until valid number is received
        while (!validInput) {
            System.out.println("Enter the Fibonacci number position you want to see: ");
            try {
                String input = scanner.nextLine();
                n = Integer.parseInt(input);

                // Validate that input is non-negative
                if (n < 0) {
                    System.out.println("Please enter a non-negative integer.");
                    continue;
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        scanner.close();

        // Initialize cache array with size n+1 to store values from 0 to n
        fibonacciCache = new long[n + 1];

        // Display the Fibonacci number at position n
        System.out.println("- The Fibonacci number at position " + n + " is: "+ fibonacci(n));

        // Display all Fibonacci numbers up to position n
        System.out.println("- The following are the Fibonacci numbers up to position " + n + ": ");

        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    /**
     * Calculates the Fibonacci number at a given position using recursion with memoization.
     * @param n The position in the Fibonacci sequence to calculate
     * @return The Fibonacci number at position n
     */
    private static long fibonacci(int n) {

        // Base cases for positions 0 and 1
        if (n <= 1) {
            return n;
        }

        // Return cached value if already calculated
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        // Calculate new Fibonacci number and cache it
        long nthFibonacciNumber = (fibonacci(n-1) + fibonacci(n-2));
        fibonacciCache[n] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }
}
