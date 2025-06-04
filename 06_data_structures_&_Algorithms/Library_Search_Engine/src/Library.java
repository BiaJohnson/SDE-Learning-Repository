import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a library that manages a collection of books.
 * Provides functionality to load books from a file, view all books,
 * and search for books by keyword.
 */
public class Library {

    // List to store all books in the library
    private List<Book> books = new ArrayList<>();
    /**
     * Loads books from a CSV file into the library.
     * Each line in the file should be in the format: title,author,publicationYear
     * @param fileName the path to the CSV file containing book data
     */
    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    int publicationYear = Integer.parseInt(parts[2]);
                    Book book = new Book(title, author, publicationYear);
                    books.add(book);
                }
                else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Displays all books in the library to standard output.
     */
    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    /**
     * Searches for a book by keyword in title, author or publication year.
     * The search is case-insensitive.
     * @param keyword the search term to look for
     * @return the first book matching the keyword, or null if no match found
     */
    public Book searchBookByKeyword(String keyword) {
        keyword = keyword.toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                book.getAuthor().toLowerCase().contains(keyword) ||
                Integer.toString(book.getPublicationYear()).equals(keyword)) {
                return book;
            }
        }
        return null;
    }
    /**
     * Gets the list of all books in the library.
     *
     * @return the list of books
     */
    public List<Book> getBooks() {
        return books;
    }
    /**
     * Sets the list of books in the library.
     * @param books the list of books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}