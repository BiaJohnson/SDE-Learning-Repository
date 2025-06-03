/**
 * Represents an examination with its details like ID, subject, date and time
 */
public class Exam {
    // Unique identifier for the exam
    int examId;
    // Subject identifier for the exam
    String subjectId;
    // Date of the exam
    String date;
    // Time of the exam
    String time;

    /**
     * Constructor to create a new Exam object
     * @param id The exam identifier
     * @param subjectId The subject identifier
     * @param date The exam date
     * @param time The exam time
     */
    public Exam(int id, String subjectId, String date, String time) {
        this.examId = id;
        this.subjectId = subjectId;
        this.date = date;
        this.time = time;
    }

    /**
     * Gets the exam identifier
     * @return The exam ID
     */
    public int getExamId() {
        return examId;
    }

    /**
     * Returns a string representation of the exam
     * @return String containing exam ID, date and time separated by tabs
     */
    public String toString(){
        return examId + "\t" + date + "\t" + time;
    }

    /**
     * Gets the subject identifier
     * @return The subject ID
     */
    public String getSubjectId() {
        return subjectId;
    }

    /**
     * Gets the exam date
     * @return The exam date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the exam date
     * @param date The new exam date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the exam time
     * @return The exam time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the exam time
     * @param time The new exam time
     */
    public void setTime(String time) {
        this.time = time;
    }
}