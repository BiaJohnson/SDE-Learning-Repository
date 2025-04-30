/**
 Represents a student.
 This class stores a student's last name, first name, midterms and final exam grades,
 and computes a letter grade based on the average of the three exams.
 */

public class Student {
    private final String lastName;
    private final String firstName;
    private final float midTerm1;
    private final float midTerm2;
    private final float finalGrade;
    private String averageGradeLetter;


    /**
     Constructs a new Student object with the given information.
     @param lastName   The student's last name.
     @param firstName  The student's first name.
     @param midTerm1   The student's first midterm grade.
     @param midTerm2   The student's second midterm grade.
     @param finalGrade The student's final exam grade.
     */
    public Student(String lastName, String firstName, float midTerm1, float midTerm2, float finalGrade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.midTerm1 = midTerm1;
        this.midTerm2 = midTerm2;
        this.finalGrade = finalGrade;
        // Initialize averageGradeLetter to an empty string; which will be set later.
        this.averageGradeLetter = "";
    }
    /**
     @return the first midterm grade as a float.
     */
    public float getMidTerm2() {
        return midTerm2;
    }
    /**
     @return the second midterm grade as a float.
     */
    public float getMidTerm1() {
        return midTerm1;
    }
    /**
     @return the final exam grade as a float.
     */
    public float getFinalGrade() {
        return finalGrade;
    }
    /**
     Calculates the average of the midterms and final exam grades,
     rounds it to the nearest integer, and assigns the corresponding
     letter grade to averageGradeLetter.
     */
    public void setAverageGrade() {

        int averageGrade;
        // Calculate the average of the three grades using floating-point division.
        float average = ((midTerm1) + (midTerm2) + (finalGrade))/3.0f;
        // Round the computed average to the nearest integer.
        averageGrade = Math.round(average);

        // Assign a letter grade based on the rounded average.
        if (averageGrade < 60){
            this.averageGradeLetter = "F";
        }else if (averageGrade < 70){
            this.averageGradeLetter = "D";
        }else if (averageGrade < 80){
            this.averageGradeLetter = "C";
        }else if (averageGrade < 90){
            this.averageGradeLetter = "B";
        }else{
            this.averageGradeLetter = "A";
        }
    }
    /**
     Returns a formatted String containing the student's information and grades.
     The information includes the last name, first name, midterm grades, final grade,
     and the computed letter grade, with fields separated by tab characters.
     *
     @return a String representing the student's information.
     */
    public String returnStudentInfo(){

        // Cast the float grades to int for display purposes.
        return lastName + "\t" + firstName + "\t" + (int)midTerm1 + "\t" + (int)midTerm2 + "\t" + (int)finalGrade + "\t" + averageGradeLetter;
    }
}