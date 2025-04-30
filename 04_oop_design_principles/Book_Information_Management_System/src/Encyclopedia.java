/**
 * The encyclopedia class extends the book class and adds additional attributes such as edition and number of pages.
 */
public class Encyclopedia extends Book {

    private String edition;
    private int numberOfPages;

    /**
     * Sets the edition of the encyclopedia.
     * @param edition
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * Sets the number of pages of the encyclopedia
     * @param numberOfPages
     */
    public void setNumPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Gets the number of the pages of the encyclopedia
     * @return numOfPages
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Gets the edition of the encyclopedia
     * @return edition
     */
    public String getEdition() {
        return edition;
    }


    /**
     * Prints encyclopedia details including inherited book details.
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.print("Edition: " + edition + "\nNumber of pages: " + numberOfPages);
    }
}