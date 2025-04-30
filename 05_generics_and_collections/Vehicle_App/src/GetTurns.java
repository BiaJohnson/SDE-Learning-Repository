import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class that handles user input for vehicle turn directions.
 * Collects a series of turn directions from user input.
 */
public class GetTurns {
    /**
     * Collects turn directions from user input until 'done' is entered.
     * @param scanner The Scanner object used to read user input
     * @return An array of Strings containing the turn directions ('L' for left, 'R' for right)
     */
    public static String[] getTurnsFromUser(Scanner scanner) {
        // Initialize list to store turns and counter for turn number
        List<String> turns = new ArrayList<>();
        int turnCount = 1;

        while (true) {
            // Prompt user for input
            System.out.print("Enter turn " + turnCount + " :");
            String input = scanner.nextLine().toUpperCase().trim();

            // Check if user wants to finish entering turns
            if (input.equals("DONE")) {
                break;
            }
            // Validate and store valid turn directions
            if (input.equals("L") || input.equals("R")) {
                turns.add(input);
                turnCount++;
            } else {
                // Display error message for invalid input
                System.out.println("Invalid input. Please enter 'L' for left, 'R' for right, or 'DONE' to finish.");
            }
        }
        // Convert ArrayList to array and return
        return turns.toArray(new String[0]);
    }
}
