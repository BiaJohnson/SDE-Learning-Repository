import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
/**
 The {@code IdeaReader} class provides functionality to read the contents of a file
 and return them as a string.
 */
public class IdeaReader {
    /**
     Reads the contents of a file at the specified file path and returns it as a string.
     *
     @param filePath The path of the file to be read.
     @return The contents of the file as a string. If the file is not found or an error occurs, an empty string is returned.
     */
    public String readIdea(String filePath) {
        // Initialize an empty string to store file contents
        String fileContents = "";
        // Create a File object representing the specified file
        File file = new File(filePath);
        // Try-with-resources ensures that FileInputStream is closed automatically after use
        try (FileInputStream inputStream = new FileInputStream(file)) {
            // Read the file content as bytes
            byte[] fileContentsAsBytes = inputStream.readAllBytes();
            // Convert byte array to string and store it
            fileContents = new String(fileContentsAsBytes);
        } catch (FileNotFoundException fileNotFoundException) {
            // Handle case where file is not found
            System.err.println("Error: File not found at " + filePath);
        } catch (IOException ioException) {
            // Handle other I/O exceptions
            System.err.println(ioException.getMessage());
        }
        // Return the file contents (empty string if an error occurred)
        return fileContents;
    }
}