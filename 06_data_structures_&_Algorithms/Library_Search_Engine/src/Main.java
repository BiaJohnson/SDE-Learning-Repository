import java.util.List;

/**
 * Main class that serves as the entry point for the Library Management System.
 * This class handles initialization of the library, loading/saving of data,
 * and displays the main menu interface.
 */
public class Main {
    /**
     * The main method that runs the Library Management System.
     * It performs the following operations:
     * - Initializes the library system components
     * - Loads existing library data from serialized file if available
     * - Falls back to loading from text file if serialized data not found
     * - Displays the main menu for user interaction
     * - Saves library data on exit
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize core components
        Library library = new Library();
        LibrarySerializer serializer = new LibrarySerializer();
        UserInteractionLogger logger = new UserInteractionLogger();

        // Attempt to load serialized library data
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully from src/resources/data/library.ser");
        } else {
            // Fall back to loading from text file if serialized data not found
            System.out.println("Loading data from books.txt...");
            library.loadBooks("src/resources/data/books.txt");
        }

        // Initialize and display the main menu
        LibraryMenu menu = new LibraryMenu(library);
        logger.log("Program started and menu displayed.");
        menu.displayMenu();

        // Save library data before exit
        serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
        System.out.println("Library saved successfully to src/resources/data/library.ser");
    }
}