import java.io.Serializable;

/**
 * Represents a Book entity with basic information like title, author and publication year.
 * This class implements Serializable to allow for object serialization.
 */
public class Book implements Serializable {
    // The title of the book
    private String title;
    // The author of the book
    private String author;
    // The year the book was published
    private int publicationYear;
    /**
     * Constructs a new Book with the specified details.
     * @param title The title of the book
     * @param author The author of the book
     * @param publicationYear The year the book was published
     */
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    /**
     * Gets the title of the book.
     * @return The book's title
     */
    public String getTitle() { return title; }
    /**
     * Sets the title of the book.
     * @param title The new title to set
     */
    public void setTitle(String title) { this.title = title; }
    /**
     * Gets the author of the book.
     * @return The book's author
     */
    public String getAuthor() { return author; }
    /**
     * Sets the author of the book.
     * @param author The new author to set
     */
    public void setAuthor(String author) { this.author = author; }
    /**
     * Gets the publication year of the book.
     * @return The book's publication year
     */
    public int getPublicationYear() { return publicationYear; }
    /**
     * Sets the publication year of the book.
     * @param publicationYear The new publication year to set
     */
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    /**
     * Returns a string representation of the Book object.
     * @return A string containing the book's title, author and publication year
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}