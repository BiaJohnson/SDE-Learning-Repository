import java.util.Scanner;

/**
 * Palindrome Checker
 * A program that checks whether an input string is a Palindrome
 */
public class PalindromeChecker {

    // Scanner object to read user input from the console
    // 'static' because it's shared across all instances
    // 'final' because we don't want to reassign this Scanner
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Display initial welcome message to user
        displayWelcomeMessage();

        // Main program loop - continues as long as user wants to check more palindromes
        do {
            // Get user input string
            String word = collectWords();
            // Check if the input is a palindrome and store result
            boolean result = isPalindrome(word);
            // Show the result to the user
            displayResult(word, result);

            // Loop continues based on user's desire to continue or quit

        } while (askToPlayAgain());

        // Exit message and cleanup
        System.out.println("\nThanks for using Palindrome Checker!");
        scanner.close();
    }

    /**
     * Displays welcome message and program title
     * Uses ASCII art-style formatting for visual appeal
     */
    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("   Welcome to Palindrome Checker   ");
        System.out.println("=====================================");
    }

    /**
     * Collects a string from the user with input validation
     * Removes all whitespace from the input before processing
     *
     * @return A user-provided string with all whitespace removed
     */
    private static String collectWords() {
        // Variable to store user input
        String userString;
        // Loop until valid input is received
        do {
            System.out.print("Enter a word/phrase/sentence: ");
            // Get input and remove leading/trailing whitespace
            userString = scanner.nextLine().trim();
            // Validate that input is not empty
            if (userString.isEmpty()) {
                System.out.println("Please enter something - it can't be empty!");
            }
        } while (userString.isEmpty());
        // Remove ALL whitespace and return the clean string
        userString = userString.replaceAll("\\s+", "");
        return userString.toLowerCase();
    }

    /**
     * Checks if the given string is a palindrome using two-pointer technique
     *
     * @param word The string to check (already cleaned of whitespace)
     * @return true if the string is a palindrome, false otherwise
     */
    private static boolean isPalindrome(String word) {
        // Two-pointer technique is more efficient than creating a reversed string
        // Start pointer begins at start of string
        int start = 0;
        // End pointer begins at end of string
        int end = word.length() - 1;
        // Continue until pointers meet in middle
        while (start <= end) {
            // Compare characters at both ends
            if (word.charAt(start) == word.charAt(end)) {
                // If match, move pointers toward center
                start++;
                end--;
            } else {
                // If characters don't match, not a palindrome
                return false;
            }
        }
        // If we complete the loop, it's a palindrome
        return true;
    }

    /**
     * Displays the result with decorative formatting
     * Uses ternary operator to determine output message
     *
     * @param word   The original input string
     * @param result The boolean result of palindrome check
     */
    private static void displayResult(String word, boolean result) {
        // Ternary operator to choose between "IS" and "IS NOT"
        String resultStr = result ? "IS" : "IS NOT";
        System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.printf("Your string '%s' %s a Palindrome!\n", word, resultStr);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /**
     * Handles the "play again" functionality
     * Loops until user provides valid input (yes/no)
     * Accepts both full words and single letters (y/n)
     *
     * @return true if user wants to check another string, false otherwise
     */
    private static boolean askToPlayAgain() {
        while (true) {
            System.out.print("\nWould you like to play again? (yes/no): ");
            // Get user input, remove whitespace, convert to lowercase
            String response = scanner.nextLine().trim().toLowerCase();

            // Check for valid positive responses
            if (response.equals("yes") || response.equals("y")) {
                return true;
                // Check for valid negative responses
            } else if (response.equals("no") || response.equals("n")) {
                return false;
                // Handle invalid input
            } else {
                System.out.println("Please enter 'yes' or 'no'");
            }
        }
    }
}