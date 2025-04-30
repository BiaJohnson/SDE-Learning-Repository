import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a catalog of movies that can be loaded from a CSV file.
 * Manages a collection of Movie objects and their associated data.
 */
public class MovieCatalog {
    // Name of the input CSV file
    private final String dataFile;
    // Collection to store Movie objects
    private final ArrayList<Movie> movies;

    /**
     * Constructs a new MovieCatalog with specified file name.
     *
     * @param fileName The name of the CSV file to read movie data from
     */
    MovieCatalog(final String fileName) {
        this.dataFile = fileName;
        this.movies = new ArrayList<Movie>();
    }

    /**
     * Loads movie data from the CSV file specified in dataFile.
     * Each line should contain: movie time, name, and rating.
     *
     * @throws FileNotFoundException    if the input file cannot be found
     * @throws IllegalArgumentException if the file format is invalid
     */
    public void loadData() throws FileNotFoundException, IllegalArgumentException {
        try (Scanner fileReader = new Scanner(new FileInputStream(dataFile))) {
            // Track line number for error reporting
            int lineNum = 0;

            // Process file line by line
            while (fileReader.hasNextLine()) {
                lineNum++;
                String line = fileReader.nextLine().trim();

                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }

                processLine(line, lineNum);

            }
        } catch (FileNotFoundException e) {
            // Propagate file not found error
            throw new FileNotFoundException("Could not find file: " + dataFile);
        }
    }

    /**
     * Processes a single line from the input file.
     *
     * @param line    The line to process
     * @param lineNum The line number for error reporting
     * @throws IllegalArgumentException if the line format is invalid
     */
    private void processLine(final String line, final int lineNum) throws IllegalArgumentException {
        // Split line string into components using comma as delimiter
        // since we expect that in an csv file format
        String[] values = line.split(",");

        // Verify line has required number of fields
        if (values.length == 3) {
            String movieTime = values[0].trim();
            String movieName = values[1].trim();
            String movieRating = values[2].trim();

            // Validate individual fields
            validateFields(movieTime, movieName, movieRating, lineNum);
            // add movie to catalog
            addMovie(movieName, movieRating, movieTime);
        } else {
            String errMsg = String.format(
                    "Input file '%s' line %d: Expected 3 items (time, name, rating), found %d items",
                    dataFile, lineNum, values.length);
            throw new IllegalArgumentException(errMsg);
        }
    }

    /**
     * Validates individual fields from a line of movie data.
     */
    private void validateFields(final String time, final String name, final String rating, final int lineNum)
            throws IllegalArgumentException {
        if (time.isEmpty() || name.isEmpty() || rating.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("Empty field(s) found at line %d", lineNum));
        }
    }

    /**
     * Displays the movie catalog in a formatted table.
     * Shows movie title, rating, and all available showtimes.
     */
    public void print() {

        if (movies.isEmpty()) {
            System.out.println("No movies in catalog");
            return;
        }

        // Print table header
        System.out.printf("%n%-40s | %-6s | %s%n", "MOVIE TITLE", "RATING", "SHOWTIMES");
        System.out.println("-".repeat(80)); // Visual separator

        // Print each movie's information
        for (Movie movie : this.movies) {
            movie.print();
        }
    }

    /**
     * Adds a new movie to the catalog or updates existing movie's showtimes.
     * If the movie already exists, adds the new showtime to that movie.
     * If it's a new movie, creates a new Movie object and adds it to the catalog.
     *
     * @param name   Movie title
     * @param rating Movie rating
     * @param time   Movie showtime
     */
    private void addMovie(final String name, final String rating, final String time) {
        // Check if movie already exists in catalog
        Movie existingMovie = findMovie(name);

        if (existingMovie != null) {
            // Add new showtime to existing movie
            existingMovie.addShowTime(time);
        } else {
            // Create and add new movie to catalog
            this.movies.add(new Movie(name, rating, time));
        }
    }

    /**
     * Searches for a movie in the catalog by name.
     *
     * @param name The name of the movie to find
     * @return Movie object if found, null if not found
     */
    private Movie findMovie(final String name) {
        // Search through movie collection for matching name
        for (Movie movie : this.movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        // Return null if movie not found
        return null;
    }
}