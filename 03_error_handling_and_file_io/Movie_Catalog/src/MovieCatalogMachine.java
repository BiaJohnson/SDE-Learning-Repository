import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class that handles the movie catalog system interface.
 * This class manages user input and initialization of the movie catalog system.
 */
class MovieCatalogMachine {
    /**
     * Main entry point of the program.
     * Handles the primary flow of getting file input and processing the movie
     * catalog.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner
        try (Scanner keyboard = new Scanner(System.in)) {
            // Get valid filename from user
            String inputFileName = getValidFileName(keyboard);

            // Create new movie catalog instance
            MovieCatalog movieCatalog = new MovieCatalog(inputFileName);

            try {
                // Attempt to load and display the movie data
                movieCatalog.loadData();
                movieCatalog.print();

            } catch (IllegalArgumentException e) {
                // Handle format errors in the CSV file
                // e.g., wrong number of columns, invalid data format
                System.err.println("Error in data format: " + e.getMessage());

            } catch (FileNotFoundException e) {
                // Handle case where the specified file cannot be found
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Prompts user for a filename and validates the input.
     * Continues to prompt until a non-empty filename is provided.
     *
     * @param keyboard Scanner object for reading user input
     * @return A non-empty filename string
     */
    private static String getValidFileName(Scanner keyboard) {
        String fileName = "";

        // Continue prompting until a non-empty filename is provided
        while (fileName.isEmpty()) {
            // Prompt user for input
            System.out.print("Please enter CSV file name from which to read movie data from: ");
            fileName = keyboard.nextLine().trim();

            // Validate that filename is not empty
            if (fileName.isEmpty()) {
                System.out.println("Error: Filename cannot be empty. Please try again.");
                continue;
            }

            // Warn user if file doesn't have .csv extension
            if (!fileName.endsWith(".csv")) {
                System.out.println("Warning: File doesn't have .csv extension");
            }
        }

        return fileName;
    }
}