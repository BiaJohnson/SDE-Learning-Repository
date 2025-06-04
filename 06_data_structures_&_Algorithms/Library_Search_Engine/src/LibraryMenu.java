import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Manages the library menu interface and user interactions.
 * This class handles displaying menu options, processing user input,
 * and executing library operations.
 */
public class LibraryMenu {
    // Core library instance to manage books
    private Library library;
    // Logger to track user interactions
    private UserInteractionLogger logger = new UserInteractionLogger();
    // Serializer to save/load library data
    private LibrarySerializer serializer = new LibrarySerializer();
    // List to store book collection
    private List<Book> books;
    /**
     * Constructs a LibraryMenu with the specified library.
     * Attempts to load saved library data, falls back to default books if no saved data exists.
     *
     * @param library The library instance to be managed
     */
    public LibraryMenu(Library library) {
        this.library = library;
        // Load the library data when the program starts
        this.books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("Debug: No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }
    /**
     * Displays the main menu and handles user interactions.
     * Provides options for viewing, sorting, and searching books.
     * Continues to display menu until user chooses to exit.
     */
    public void displayMenu() {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n ********* Welcome to the Library Search Engine  *********");

        while (true) {
            // Display menu options
            System.out.println("\nMenu Options - Enter a number (1-6): ");
            System.out.println("1. View all Books");
            System.out.println("2. Sort Books by title");
            System.out.println("3. Sort Books by author");
            System.out.println("4. Sort Books by publication year");
            System.out.println("5. Search for a Book by keyword");
            System.out.println("6. Exit");

            // Get user choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Display all books
                    logger.logViewAllBooks();
                    library.viewAllBooks();
                    break;
                case 2:
                    // Sort books by title using bubble sort
                    logger.logSort("title");
                    SortUtil.bubbleSort(books, Comparator.comparing(Book::getTitle));
                    library.viewAllBooks();
                    break;
                case 3:
                    // Sort books by author using insertion sort
                    logger.logSort("author");
                    SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    library.viewAllBooks();
                    break;
                case 4:
                    // Sort books by publication year using quick sort
                    logger.logSort("publication year");
                    SortUtil.quickSort(books, Comparator.comparing(Book::getPublicationYear), 0, books.size() - 1);
                    library.viewAllBooks();
                    break;
                case 5:
                    // Search for a book by keyword
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    logger.logSearch(keyword);
                    Book foundBook = library.searchBookByKeyword(keyword);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Thank you for using the Library Management System!");
                    // serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser"); // for test
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}