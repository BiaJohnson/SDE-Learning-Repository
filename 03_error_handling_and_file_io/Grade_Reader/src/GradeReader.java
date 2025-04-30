import java.io.*;
import java.util.*;

/**
 The GradeReader class reads student grade data from a file and stores the data in a list of Student objects.
 Each line in the input file is expected to contain 5 tab-separated values:
 last name, first name, midterm1 grade, midterm2 grade, and final grade.
 For each valid line, a Student object is created,the average grade letter is computed, and the object is added to the student list.
 */
public class GradeReader {

    //List to store Student objects read from the file.
    private final List<Student> studentList = new ArrayList<>();

    /**
     @return a List of Student objects.
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     Reads student grade data from the file and populates the student list.
     *
     @param fileName the name of the file to read.
     @return true if the file was successfully read; false if the file was not found.
     @throws IOException if an I/O error occurs during reading.
     */
    public boolean readFile(String fileName) throws IOException {

        String line;
        // Try-with-resources.
        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            // Read each line of the file.
            while((line = reader.readLine()) != null ){
                // Split the line by tab characters.
                String[] info = line.split("\t");
                // Check if the line contains exactly 5 elements.
                if (info.length == 5) {
                    // Create a Student object and parse float values for the grades.
                    Student student = new Student(info[0], info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]), Float.parseFloat(info[4]));
                    // Calculate and set the student's average grade letter.
                    student.setAverageGrade();
                    // Add the Student object to the list.
                    studentList.add(student);
                }else{
                    // If the line is malformed, print a message and skip it.
                    System.out.println("Skipping line due to being malformed.");
                }
            }
            // Return true to indicate successful file reading.
            return true;
        }catch(FileNotFoundException e){
            // If the file is not found, inform the user and return false so user can reenter the file name.
            System.out.println("File not found. Please try another file");
            return false;
        }catch(IOException e){
            // If an I/O error occurs, throw a new IOException with the error message.
            throw new IOException(e.getMessage());
        }
    }
}