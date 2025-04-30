import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The BookInformation class allows user to enter and display information about books and encyclopedias.
 */
public class BookInformation {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Book myBook = new Book();
        Encyclopedia myEncyclopedia = new Encyclopedia();


        while (true) {
            try {
                // Display menu options
                System.out.println("\n**** Book Information Menu ****");
                System.out.println("1 - Enter information for a book");
                System.out.println("2 - Enter information for an encyclopedia");
                System.out.println("3 - Exit");
                System.out.print("Enter your choice: ");
                int choice = scnr.nextInt();
                scnr.nextLine(); // Consume the newline
                if (choice == 1) {
                    // Enter Book information
                    System.out.print("Enter the book title: ");
                    String title = scnr.nextLine();
                    System.out.print("Enter the book author: ");
                    String author = scnr.nextLine();
                    System.out.print("Enter the book publisher: ");
                    String publisher = scnr.nextLine();
                    System.out.print("Enter the book publication date: ");
                    String publicationDate = scnr.nextLine();

                    // Set book details
                    myBook.setTitle(title);
                    myBook.setAuthor(author);
                    myBook.setPublisher(publisher);
                    myBook.setPublicationDate(publicationDate);

                    // Display book details
                    myBook.printInfo();

                } else if (choice == 2) {
                    // Enter Encyclopedia information
                    System.out.print("Enter the encyclopedia title: ");
                    String eTitle = scnr.nextLine();
                    System.out.print("Enter the encyclopedia author: ");
                    String eAuthor = scnr.nextLine();
                    System.out.print("Enter the encyclopedia publisher: ");
                    String ePublisher = scnr.nextLine();
                    System.out.print("Enter the encyclopedia publication date: ");
                    String ePublicationDate = scnr.nextLine();
                    System.out.print("Enter the edition: ");
                    String edition = scnr.nextLine();
                    System.out.print("Enter the number of pages: ");
                    int numPages = scnr.nextInt();

                    // Set encyclopedia details
                    myEncyclopedia.setTitle(eTitle);
                    myEncyclopedia.setAuthor(eAuthor);
                    myEncyclopedia.setPublisher(ePublisher);
                    myEncyclopedia.setPublicationDate(ePublicationDate);
                    myEncyclopedia.setEdition(edition);
                    myEncyclopedia.setNumPages(numPages);

                    // Display encyclopedia details
                    myEncyclopedia.printInfo();

                } else if (choice == 3) {
                    System.out.println("Exiting program. Goodbye!");
                    break; // Exit loop
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
                scnr.nextLine(); // Clear invalid input
            }
        }
        scnr.close();
    }
}