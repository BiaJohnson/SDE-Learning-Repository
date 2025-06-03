import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents a student in an educational system.
 * This class manages student information including their personal details,
 * enrolled subjects and exams.
 */
public class Student {
    // Student's unique identification number
    Integer studentNumber;
    // Student's full name
    String name;
    // List of subjects the student is enrolled in
    ArrayList<Subject> subjects = new ArrayList<>();
    // Map of exams indexed by subject ID
    HashMap<String, Exam> examsMap = new HashMap<>();

    /**
     * Constructs a new Student with the given name and student number.
     * @param name The student's name
     * @param studentNumber The student's unique identification number
     */
    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    /**
     * Returns a string representation of the student.
     * @return A string containing the student number and name, tab separated
     */
    public String toString(){
        return studentNumber + "\t" + name;
    }

    /**
     * Gets the student's name.
     * @return The student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the student's identification number.
     * @return The student number
     */
    public Integer getStudentNumber() {
        return studentNumber;
    }

    /**
     * Gets the list of subjects the student is enrolled in.
     * @return List of subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Adds multiple subjects to the student's enrollment.
     * @param subjects List of subjects to add
     */
    public void addSubjects(ArrayList<Subject> subjects) {
        this.subjects.addAll(subjects);
    }

    /**
     * Adds a single subject to the student's enrollment.
     * @param subject The subject to add
     */
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    /**
     * Adds an exam result for the student.
     * @param exam The exam to add
     */
    public void addExam(Exam exam) {
        examsMap.put(exam.subjectId, exam);
    }

    /**
     * Adds multiple exam results for the student.
     * @param exams List of exams to add
     */
    public void addExams(List<Exam> exams) {
        for (Exam exam : exams) {
            addExam(exam);
        }
    }

    /**
     * Gets all exam results for the student.
     * @return List of all exams
     */
    public List<Exam> getExams() {
        List<Exam> exams = new ArrayList<>();
        for(Exam exam : examsMap.values()) {
            exams.add(exam);
        }
        return exams;
    }
}