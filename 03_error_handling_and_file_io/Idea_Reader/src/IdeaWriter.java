import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 The {@code IdeaWriter} class provides functionality to write text content to a file.
 */
public class IdeaWriter {
    /**
     Writes the given content to a file at the specified file path.
     *
     @param filePath     The path of the file where content will be written.
     @param fileContents The content to be written to the file.
     */
    public void writeIdea(String filePath, String fileContents) {
        // Create a File object representing the specified file path
        File file = new File(filePath);
        // Convert the content string into a byte array
        byte[] fileContentsAsBytes = fileContents.getBytes();
        // Try-with-resources ensures that FileOutputStream is closed automatically
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            // Write byte array content to the file
            outputStream.write(fileContentsAsBytes);
        } catch (FileNotFoundException fileNotFoundException) {
            // Handle case where file is not found
            System.err.println("File not found! Please check the path and try again!");
        } catch (IOException ioException) {
            // Handle other I/O exceptions
            System.err.println(ioException.getMessage());
        }
    }
}