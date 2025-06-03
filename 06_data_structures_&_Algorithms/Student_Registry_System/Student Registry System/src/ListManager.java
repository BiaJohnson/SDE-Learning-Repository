import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

/**
 * A class that manages a list of students using a TreeMap data structure.
 * Provides functionality to add, remove, find, and update student records.
 */
public class ListManager {

    /** TreeMap to store student records with lastName as key */
    TreeMap studentsMap = new TreeMap();

    /**
     * Constructor that initializes the ListManager with an array of students
     * @param students Array of Student objects to initialize the list
     */
    public ListManager(Student [] students){
        for (Student student : students) {
            studentsMap.put(student.lastName, student);
        }
    }

    /**
     * Lists all students currently in the system
     */
    public void listStudents( ) {
        if(studentsMap.isEmpty()){
            System.out.println("The system has no students in the waiting list");
        } else {
            System.out.println("Listing all Students\n");
            Set entries = studentsMap.entrySet();
            for (Object entry : entries) {
                Map.Entry mapEntry = (Map.Entry) entry;
                Student student = (Student)mapEntry.getValue();
                System.out.println(student);
            }
        }
    }

    /**
     * Finds and displays a student by their last name
     * @param lastName The last name of the student to find
     */
    public void findStudent(String lastName) {
        if(studentsMap.containsKey(lastName)){
            System.out.println("Student Found\n");
            Student student = (Student)studentsMap.get(lastName);
            System.out.println(student);
        }else{
            System.out.println("\nStudent with name '" + lastName + "' Does not exist.");
        }
    }

    /**
     * Updates the status of a student
     * @param lastName The last name of the student to update
     * @param newStatus The new status to set for the student
     */
    public void updateStudentStatus(String lastName, String newStatus){
        Student student = (Student)studentsMap.get(lastName);
        if(student != null){
            String oldStatus = student.status;
            student.status = newStatus;
            studentsMap.put(lastName,student);
            System.out.println();
            System.out.println("Student ("+ lastName +") status was changed from '" + oldStatus + "'' to '" + newStatus + "'");
            System.out.println(student);
        }else {
            System.out.println();
            System.out.println("Student does not exist. Status was not updated.");
        }
    }

    /**
     * Removes a student from the system
     * @param lastName The last name of the student to remove
     */
    public void removeStudent(String lastName) {
        Student studentRemoved = (Student)studentsMap.remove(lastName);
        if(studentRemoved != null){
            System.out.println();
            System.out.println("Student removed.");
            System.out.println(studentRemoved);
            System.out.println();
        }else{
            System.out.println("Student was not removed.");
        }
    }

    /**
     * Finds and displays the first student in the alphabetically ordered list
     */
    public void findFirstStudent(){
        Map.Entry firstEntry = studentsMap.firstEntry();
        Student student = (Student)firstEntry.getValue();

        if(student != null){
            System.out.println("First Student");
            System.out.println(student);
        }
        if(student != null){
            return;
        }
        if(student == null){
            System.out.println("First Student");
            System.out.println("Student not found.");
        }
    }

    /**
     * Finds and displays the last student in the alphabetically ordered list
     */
    public void findLastStudent(){
        Map.Entry lastEntry = studentsMap.lastEntry();
        Student student = (Student)lastEntry.getValue();

        if(student != null){
            System.out.println("Last Student");
            System.out.println(student);
        }
        if(student != null){
            return;
        }
        if(student == null){
            System.out.println("Last Student");
            System.out.println("Student not found.");
        }
    }

    /**
     * Finds and displays the next student after the given student in alphabetical order
     * @param searchString The last name of the reference student
     */
    public void findNextStudent(String searchString){
        // First check if the exact key exists in the map
        if (!studentsMap.containsKey(searchString)) {
            System.out.println("Next Student");
            System.out.println("Student not found.");
            return;
        }
        // Get the higher entry only if the search string exists
        Map.Entry higherEntry = studentsMap.higherEntry(searchString);
        // Check if higherEntry is null (means we're at the last student)
        if (higherEntry == null) {
            // Get the current student to show in the message
            Student currentStudent = (Student) studentsMap.get(searchString);
            System.out.println("Next Student");
            System.out.println(currentStudent.firstName + " " + currentStudent.lastName + " is the last student in the list.");
            System.out.println("No next student exists.");
            return;
        }
        // If we get here, higherEntry is not null and the search was valid
        Student student = (Student)higherEntry.getValue();
        System.out.println("Next Student");
        System.out.println(student);
    }

    /**
     * Finds and displays the previous student before the given student in alphabetical order
     * @param searchString The last name of the reference student
     */
    public void findPreviousStudent(String searchString) {
        // First check if the exact key exists in the map
        if (!studentsMap.containsKey(searchString)) {
            System.out.println("Previous Student");
            System.out.println("Student not found.");
            return;
        }

        // Get the lower entry only if the search string exists
        Map.Entry lowerEntry = studentsMap.lowerEntry(searchString);

        // Check if lowerEntry is null (means we're at the first student)
        if (lowerEntry == null) {
            // Get the current student to show in the message
            Student currentStudent = (Student) studentsMap.get(searchString);
            System.out.println("Previous Student");
            System.out.println(currentStudent.firstName + " " + currentStudent.lastName + " is the first student in the list.");
            System.out.println("No previous student exists.");
            return;
        }
        // If we get here, lowerEntry is not null and the search was valid
        Student student = (Student)lowerEntry.getValue();
        System.out.println("Previous Student");
        System.out.println(student);
    }
}