import java.util.*;
import java.util.Stack;

/**
 * Main class for the Student Information System
 * Handles user interaction and system operations
 */
public class Main {
    // Scanner for user input
    static Scanner keyboard;
    // Main system instance
    static StudentInfoSystem studentInfoSystem = new StudentInfoSystem();

    /**
     * Main program loop that displays menu and handles user choices
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        while (true) {
            // Display main menu options
            System.out.println("\nOptions:");
            System.out.println("1. Add Student"); // bubble sort on subjects
            System.out.println("2. Remove Student"); // binary search
            System.out.println("3. View Students"); // insertion sort on students
            System.out.println("4. View Exam Schedule");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            int choice = -1;
            try {
                choice = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                keyboard.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            // Process user choice
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    viewStudents();
                    break;
                case 4:
                    viewExamSchedule();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("\nInvalid choice. Try again.");
            }
        }
    }

    /**
     * Creates a new student with subjects and exam schedule
     * Collects student details, subject choices and exam preferences
     */
    public static void createStudent(){
        // Get student name
        System.out.println("Enter student name as \"last, first\":");
        String name = keyboard.nextLine();
        int number = studentInfoSystem.newStudentNumber();

        // Display available subjects
        System.out.println("Here is a list of subjects available.");
        List<Subject> subjects = studentInfoSystem.sortSubjectsByName();

        for (Subject subject : subjects) {
            System.out.println(" " + subject);
        }

        // Get number of subjects (1-5)
        int subjectCount = 0;
        while(subjectCount == 0) {
            System.out.println("\nEnter number of subjects desired:");
            subjectCount = keyboard.nextInt();
            keyboard.nextLine();
            if (subjectCount >= 6) {
                System.out.println("A Student may enroll for no more than five subjects.\n");
                subjectCount = 0;
            } else if (subjectCount < 1 ) {
                System.out.println("A Student may enroll for at least one subject.\n");
                subjectCount = 0;
            }
        }

        // Initialize collections for selected subjects and exams
        ArrayList<Subject> subjectsSelected = new ArrayList<>();
        ArrayList<Exam> examsSelected = new ArrayList<>();
        HashMap<Integer, String> ordinal = new HashMap<Integer, String>();
        ordinal.put(1, "first");
        ordinal.put(2, "second");
        ordinal.put(3, "third");
        ordinal.put(4, "fourth");
        ordinal.put(5, "fifth");

        // Select subjects and exams
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("\nEnter the" + (subjectCount == 1 ? "":" " + ordinal.get(i+1)) + " Subject ID:");
            String subjectId = keyboard.nextLine();
            Subject subject = studentInfoSystem.findSubject(subjectId);
            if (subject != null) {
                subjectsSelected.add(i, subject);
                System.out.println("Subject " + subject.id + " " + subject.name + " added\n");

                // Select exam time for subject
                while(true) {
                    System.out.println("Exam dates and times for " + subject.name);
                    List<Exam> exams = studentInfoSystem.findExams(subject.id);
                    for (Exam exam : exams) {
                        System.out.println(" " + exam);
                    }
                    System.out.println("Select an exam date and time by exam id");
                    int examId = keyboard.nextInt();
                    keyboard.nextLine();
                    Exam exam = studentInfoSystem.findExam(examId,exams);
                    if (exam != null) {
                        examsSelected.add(exam);
                        System.out.println("\nAdded: " + subject + ", Exam: " + exam.date + " " + exam.time);
                        break;
                    }else{
                        System.out.println("Exam " + examId + " not found. Try again");
                    }
                }

                // Show remaining available subjects
                if(i + 1 < subjectCount){
                    System.out.println("\nAvailable Subjects");
                    subjects.remove(subject);
                    for (Subject sub : subjects) {
                        System.out.println(" " + sub);
                    }
                }
            }else{
                System.out.println("\nInvalid subject ID '"+ subjectId +"'. Please enter a valid subject ID.");
                i--;
            }
        }

        // Create and add new student
        Student studentToAdd = new Student(name, number);
        studentToAdd.addSubjects(subjectsSelected);
        studentToAdd.addExams(examsSelected);
        studentInfoSystem.addStudent(studentToAdd);

        // Display confirmation and details
        System.out.println("\n**********************\n");
        System.out.println("Student \"" + name + "\" has been added");
        System.out.println("Subjects and exams:");
        for (Subject subject : subjectsSelected) {
            Exam examTime = studentToAdd.examsMap.get(subject.id);
            System.out.println(" " + subject + ", Exam: " + examTime.date + " " + examTime.time);
        }
        System.out.println("\n**********************\n");
    }

    /**
     * Removes a student from the system based on student number
     */
    public static void removeStudent(){
        System.out.println("\nEnter student number to remove:");
        int studentNumber = keyboard.nextInt();

        Student studentToRemove =
                studentInfoSystem.findStudent(studentNumber);
        if (studentToRemove != null) {
            studentInfoSystem.removeStudent(studentToRemove);
            System.out.println("\nStudent " + studentNumber + " " +
                    studentToRemove.name + " has been removed");
        }else{
            System.out.println("\nStudent number '" + studentNumber +
                    "' doesn't exist.");
        }
    }

    /**
     * Displays alphabetical list of all students
     */
    public static void viewStudents(){
        System.out.println("\nAlphabetical list of students:");

        List<Student> studentsByName = studentInfoSystem.sortStudentsByName();

        for (Student student : studentsByName) {
            System.out.println(student);
        }
    }

    /**
     * Displays exam schedule for a specific student
     */
    public static void viewExamSchedule(){
        System.out.println("Enter student number to view exam schedule:");
        int studentNumber = keyboard.nextInt();
        Student student = studentInfoSystem.findStudent(studentNumber);
        System.out.println("Exam Schedule for " + student.name + ":");
        List<Exam> exams = student.getExams();
        for(Subject subject : student.subjects) {
            for (Exam exam : exams) {
                if(exam.subjectId.compareTo(subject.id) == 0) {
                    System.out.println(" " + subject.name + ": " + exam.date + " " + exam.time);
                }
            }
        }
    }

    // Stack to track actions for undo functionality
    Stack<String> actions = new Stack<>();;

    /**
     * Undoes the last action performed in the system
     * Currently supports undoing student addition only
     */
    public void undoLastAction() {
        if (!actions.isEmpty()) {
            String lastAction = actions.pop();
            System.out.println("Undoing: " + lastAction);

            if (lastAction.startsWith("Added student: ")) {
                String studentName = lastAction.substring(15);
                Student toRemove = studentInfoSystem.findStudent(studentName);

                if (toRemove != null) {
                    studentInfoSystem.removeStudent(toRemove);
                    System.out.println("Student " + studentName + " has been removed.");
                } else {
                    System.out.println("Student not found.");
                }
            } else if (lastAction.startsWith("Removed student: ")) {
                // Implement logic to re-add the student, if data is available
                System.out.println("Cannot undo removal, student data not saved.");
            }
        } else {
            System.out.println("No actions to undo.");
        }
    }
}