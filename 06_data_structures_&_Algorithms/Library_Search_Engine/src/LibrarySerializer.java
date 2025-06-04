import java.io.*;
import java.util.List;
/**
 * A class responsible for serializing and deserializing library book data to/from files.
 */
public class LibrarySerializer  {
    /**
     * Saves a list of books to a file using object serialization.
     * @param books The list of Book objects to save
     * @param fileName The name of the file to save to
     */
    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(books);
        } catch (IOException e) {
            // Print stack trace if there's an error writing to file
            e.printStackTrace();
        }
    }
    /**
     * Loads a list of books from a serialized file.
     *
     * @param fileName The name of the file to load from
     * @return List of Book objects, or null if file is empty/corrupted or an error occurs
     */
    public List<Book> loadLibrary(String fileName) {
        // Check if file exists and is not empty
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // Read and cast the object to List<Book>
            return (List<Book>) ois.readObject();
        }
        catch (EOFException e) {
            // Handle case where file is empty or corrupted
            System.err.println("The file is empty or corrupted: " + fileName);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            // Handle IO errors or class loading errors
            e.printStackTrace();
        }
        return null;
    }
}