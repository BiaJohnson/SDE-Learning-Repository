/**
 * The Book class represents a book with basic attributes such as tile, author, publisher, and publication date.
 */
public class Book {

    protected String title;
    protected String author;
    protected String publisher;
    protected String publicationDate;

    /**
     * Sets the book title.
     * @param userTitle
     */
    public void setTitle(String userTitle) {

        title = userTitle;
    }

    /**
     * Gets the book title.
     * @return the title
     */
    public String getTitle() {

        return title;
    }

    /**
     * Sets the book author
     * @param userAuthor
     */
    public void setAuthor(String userAuthor) {

        author = userAuthor;
    }

    /**
     * Gets the book author
     * @return the author
     */
    public String getAuthor(){

        return author;
    }

    /**
     * Set the publisher of the book
     * @param userPublisher
     */
    public void setPublisher(String userPublisher) {

        publisher = userPublisher;
    }

    /**
     * Return the book publisher
     * @return publisher
     */
    public String getPublisher() {

        return publisher;
    }

    /**
     * Set the publication date of the bpook
     * @param userPublicationDate
     */
    public void setPublicationDate(String userPublicationDate) {

        publicationDate = userPublicationDate;
    }

    /**
     * Get the publication date of the book
     * @return publicationDate
     */
    public String getPublicationDate() {

        return publicationDate;
    }

    /**
     * Prints book details.
     */
    public void printInfo() {
        System.out.println("Book Information: ");
        System.out.println("   Book Title: " + title);
        System.out.println("   Author: " + author);
        System.out.println("   Publisher: " + publisher);
        System.out.println("   Publication Date: " + publicationDate);
    }
}