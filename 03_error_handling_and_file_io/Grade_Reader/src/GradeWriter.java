import java.io.*;
import java.util.*;

/**
 The GradeWriter class writes the student information and class average data to a report file.
 It processed a list of Student objects, writes each student's information to a file,
 calculates the class averages for the midterms and final exam grades,
 and appends the formatted average information to the file.
 */
public class GradeWriter {

    /**
     Writes the student's information and the class average data to the report file report.txt.
     @param students the list of student objects whose data will be written to the file.
     */
    public void writeFile(List<Student> students) {
        // Name of the output report file.
        String fileName = "report.txt";
        // Variables to accumulate the total grades for computing the class averages.
        float classAverageMidterm1 =0;
        float classAverageMidterm2 =0;
        float classAverageFinal =0;

        // Create a File object representing the output file.
        File file = new File(fileName);
        // Create an instance of CalculateClassAverage to format and compute class averages.
        CalculateClassAverage calculateClassAverage = new CalculateClassAverage();

        // Use try-with-resources.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Iterate over each student in the list provided.
            for (Student student : students) {
                // Write the student's information to the file.
                writer.write(student.returnStudentInfo());
                writer.newLine();

                // Accumulate the exam grades for computing class averages.
                classAverageMidterm1 += student.getMidTerm1();
                classAverageMidterm2 += student.getMidTerm2();
                classAverageFinal += student.getFinalGrade();
            }
            // Calculate and write the formatted class averages to the file.
            writer.write(calculateClassAverage.setClassAverage(classAverageMidterm1,classAverageMidterm2,classAverageFinal,students.size()));
            System.out.println(fileName + " written successfully");
        } catch (FileNotFoundException e) {
            // If the file is not found, print an error message.
            System.err.println("File Not Found!");
        } catch (IOException e) {
            // If an I/O error occurs, throw a new IOException with the error message.
            System.err.println(e.getMessage());
        }
    }
}