import java.io.IOException;
import java.util.Scanner;

/**
 Main class for the Grade Processing Application.
 This application reads the filename from the user, loads student grade data
 using the GradeReader class, writes the processed grades to the output file report.txt using the
 GradeWriter class, and finally reads the report.txt file with the ReportReader class.
 */

public class Main {
    /**
     The entry point of the application.
     The method creates instances of GradeReader, GradeWriter, and ReportReader.
     It then prompts the user for a valid file name until the file is successfully
     loaded.
     After the file is read, it writes the student list to an output file
     and reads the report.
     *
     @throws IOException if an I/O error occurs during file operations
     */
    public static void main(String[] args) throws IOException {

        // Create a Scanner object to read input from the console.
        Scanner inputScanner = new Scanner(System.in);
        // Create instances of the GradeReader, GradeWriter and ReportReader classes.
        GradeReader gradeReader = new GradeReader();
        GradeWriter gradeWriter = new GradeWriter();
        ReportReader reportReader = new ReportReader();

        //keep asking for a valid file until it is successfully loaded.
        while(true){
            // Prompt the user to enter the file name.
            System.out.print("Enter the file name: ");
            String fileName = inputScanner.nextLine();
            // Try to read the file using GradeReader; if successful, break out of the loop.
            if(gradeReader.readFile("src/" + fileName)){
                break;
            }
        }
        //close scanner to free resources.
        inputScanner.close();
        // Write the student list (obtained from GradeReader) to an output file using GradeWriter.
        gradeWriter.writeFile(gradeReader.getStudentList());
        // Read and process the report using ReportReader.
        System.out.println("The following information has been written to the file:");
        reportReader.readReport();
    }
}