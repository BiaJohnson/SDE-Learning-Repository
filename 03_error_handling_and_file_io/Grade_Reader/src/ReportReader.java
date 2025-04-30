import java.io.*;
/**
 This class reads a file named "report.txt" line by line using a BufferedReader and prints each line to the console.
 It handles the case where the file is not found, and throws an IOException for other I/O errors.
 */
public class ReportReader {

    /**
     Reads the report from a file named "report.txt" and prints each line to the console.
     This method uses a try-with-resources block to ensure that the BufferedReader is closed automatically.
     If the file is not found, an error message is printed. If an I/O error occurs during reading,
     an IOException is thrown with the error message.
     *
     @throws IOException if an I/O error occurs during file reading.
     */
    public void readReport() throws IOException {
        // Name of the file to be read.
        String fileName = "report.txt";
        String line;

        // Try-with-resources.
        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))) {
            // Read each line from the file and print it until no more lines are available.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            // If the file is not found, print an error message.
            System.err.println("File not found");
        }catch(IOException e){
            // If an I/O error occurs, throw a new IOException with the error message.
            throw new IOException(e.getMessage());
        }
    }
}