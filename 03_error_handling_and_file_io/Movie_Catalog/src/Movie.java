import java.util.ArrayList;

/**
 * Represents a movie with its title, rating, and show times.
 */
public class Movie {
    // The movie's title
    private String name;
    // The movie's rating (e.g., PG, R, etc.)
    private String rating;
    // List to store all show times for this movie
    private ArrayList<String> showTimes;

    /**
     * Constructs a new Movie with the specified attributes.
     *
     * @param name     The title of the movie
     * @param rating   The movie's rating
     * @param showTime The initial show time for the movie
     */
    Movie(final String name, final String rating, final String showTime) {
        this.name = name;
        this.rating = rating;
        this.showTimes = new ArrayList<String>();
        this.addShowTime(showTime);
    }

    /**
     * Returns the movie's name.
     *
     * @return The title of the movie
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Adds a new show time to this movie's schedule.
     *
     * @param showTime The show time to add
     */
    public void addShowTime(final String showTime) {
        this.showTimes.add(showTime);
    }

    /**
     * Prints the movie information in a formatted table row.
     * Format: NAME (40 chars) | RATING (6 chars) | SHOWTIMES
     */
    public void print() {
        // Format name to 40 characters
        String formattedName = String.format("%-40.40s", this.name);
        // Format rating to 6 characters
        String formattedRating = String.format("%-6s", rating);
        // Join all show times with spaces
        String formattedTimes = String.join(" ", showTimes);
        // Print formatted movie information
        System.out.printf("%s | %s | %s%n", formattedName, formattedRating, formattedTimes);
    }

}