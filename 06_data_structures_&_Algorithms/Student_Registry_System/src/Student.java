/**
 * Represents a student entity with basic information and enrollment status.
 */
public class Student {
    /** Unique identifier for the student */
    public int studentId;

    /** Student's first name */
    public String firstName;

    /** Student's last name */
    public String lastName;

    /** Current enrollment status of the student
     *  Possible values: ENROLLED, UNDER-REVIEW, REJECTED
     */
    public String status;

    /**
     * Creates a new Student with the specified details
     * @param id The student's unique identifier
     * @param fname The student's first name
     * @param lname The student's last name
     * @param status The student's enrollment status
     */
    public Student(int id, String fname, String lname, String status){
        this.studentId = id;
        this.firstName = fname;
        this.lastName = lname;
        this.status = status;
    }

    /**
     * Returns a string representation of the Student
     * @return A formatted string containing the student's ID, full name and status
     */
    @Override
    public String toString() {
        String str = "ID:'" + this.studentId + "'";
        str += "\tNAME: '" + this.lastName +", ";
        str += this.firstName + "'";
        str += "\tSTATUS: '" +  this.status +"'";
        return str;
    }
}