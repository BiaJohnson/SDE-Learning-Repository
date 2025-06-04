import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * A class responsible for logging user interactions with the library system.
 * Logs are written to a file with timestamps.
 */
public class UserInteractionLogger {

    /** The file path where log entries will be written */
    private static final String LOG_FILE = "src/resources/data/user_interactions.log";
    /**
     * Logs a search interaction with the provided search term.
     * @param searchTerm The term that was searched for
     */
    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }
    /**
     * Logs a sort interaction with the provided sort criteria.
     * @param sortCriteria The criteria used for sorting
     */
    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }
    /**
     * Logs when a user views all books in the system.
     */
    public void logViewAllBooks() {
        log("Viewed all books");
    }
    /**
     * Generic method to log any message with a timestamp.
     * Messages are appended to the log file.
     * @param message The message to be logged
     */
    public void log(String message) {
        // Try-with-resources to ensure proper file handling
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            // Write timestamp and message to log file
            writer.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            // Print stack trace if file writing fails
            e.printStackTrace();
        }
    }
}