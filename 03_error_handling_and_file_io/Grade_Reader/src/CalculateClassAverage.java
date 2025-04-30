/**
 The CalculateClassAverage class computes the class averages for midterms and final exam grades.
 It calculates the average for each exam by dividing the total by the number of students,
 and then returns a formatted string representing these averages with two decimal places.
 */
public class CalculateClassAverage {
    /**
     Calculates the average grades for midterm1, midterm2, and the final exam.
     @param classAverageMidterm1 the cumulative total of midterm1 grades for the class
     @param classAverageMidterm2 the cumulative total of midterm2 grades for the class
     @param classAverageFinal    the cumulative total of final exam grades for the class
     @param size                 the number of students in the class
     @return a formatted string displaying the averages for midterm1, midterm2, and the final exam
     */
    public String setClassAverage(float classAverageMidterm1, float classAverageMidterm2, float classAverageFinal, int size) {
        // Compute the average for each exam by dividing the total grade sum by the number of students.
        classAverageMidterm1 = classAverageMidterm1/size;
        classAverageMidterm2 = classAverageMidterm2/size;
        classAverageFinal = classAverageFinal/size;

        // Format each average to two decimal places using String.format.
        return "Averages: Midterm1 " + String.format("%.2f,", classAverageMidterm1)
                + " Midterm2 " + String.format("%.2f,", classAverageMidterm2)
                + " Final " + String.format("%.2f", classAverageFinal);
    }
}