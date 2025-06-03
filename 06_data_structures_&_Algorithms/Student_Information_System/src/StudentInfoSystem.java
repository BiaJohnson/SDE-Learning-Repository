import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * A system for managing student information, subjects, and exams.
 * This class provides functionality for sorting and searching student records,
 * managing subjects and handling exam information.
 */
public class StudentInfoSystem {

    /** Database instance to store all records */
    private Database db = new Database();

    /*******************************************************
     *
     *  METHODS THAT NEED IMPROVEMENT
     *
     *******************************************************/

    /**
     * Sorts all subjects by name using bubble sort algorithm
     * @return List of subjects sorted alphabetically by name
     */
    public List<Subject> sortSubjectsByName() {
        List<Subject> subjectsByName =
                (List<Subject>) db.subjects.clone();

        /* Bubble sort implementation to sort Subject objects by name */
        int n = subjectsByName.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (subjectsByName.get(j).name.compareTo(subjectsByName.get(j+1).name) > 0) {
                    // Swap elements
                    Subject temp = subjectsByName.get(j);
                    subjectsByName.set(j, subjectsByName.get(j+1));
                    subjectsByName.set(j+1, temp);
                }
            }
        }

        return subjectsByName;
    }

    /**
     * Sorts all students by name using insertion sort algorithm
     * @return List of students sorted alphabetically by name
     */
    public List<Student> sortStudentsByName(){
        List<Student> students = (List<Student>) db.students.clone();

        /* Insertion sort implementation to sort Student objects by name */
        int n = students.size();
        for (int i = 1; i < n; i++) {
            Student key = students.get(i);
            int j = i - 1;

            while (j >= 0 && students.get(j).name.compareTo(key.name) > 0) {
                students.set(j + 1, students.get(j));
                j = j - 1;
            }
            students.set(j + 1, key);
        }
        return students;
    }

    /**
     * Finds a student by their student number using binary search
     * @param studentNumber The student number to search for
     * @return The matching Student object, or null if not found
     */
    public Student findStudent(Integer studentNumber) {

        List<Student> students = this.sortStudentsByNumber();

        /* Binary search implementation to find student by student number */
        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = students.get(mid).getStudentNumber().compareTo(studentNumber);
            if (comparison == 0) {
                return students.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    /*******************************************************
     *
     *  METHODS THAT DO NOT NEED IMPROVEMENT
     *
     *******************************************************/

    /**
     * Finds a student by their name using binary search
     * @param name The name to search for
     * @return The matching Student object, or null if not found
     */
    public Student findStudent(String name){
        List<Student> students = this.sortStudentsByName();
        int left = 0; // Start at the beginning of the list
        int right = students.size() - 1; // Start at the end of the list
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparitor = students.get(mid).name.compareTo(name);
            if (comparitor == 0){
                return students.get(mid); // its a match!
            }else if (comparitor < 0){
                left = mid + 1; // Ignore the left half and look in the right half
            }else {
                right = mid - 1; // Ignore the right half and look in the left half
            }
        }
        return null; // If we never find the license
    }

    /**
     * Finds exams for a given subject ID
     * @param subjectId The subject ID to search for
     * @return List of up to 2 matching Exam objects
     */
    public List<Exam> findExams(String subjectId){
        List<Exam> sortedExams = this.sortExamsBySubjectId();
        ArrayList<Exam> foundExams = new ArrayList<>();
        for (Exam exam : sortedExams) {
            if (exam.getSubjectId().equals(subjectId)){
                foundExams.add(exam);
                if(foundExams.size() == 2){
                    break;
                }
            }
        }
        return foundExams;
    }

    /**
     * Finds an exam by ID from a list of exams
     * @param examId The exam ID to search for
     * @param inExams The list of exams to search in
     * @return The matching Exam object, or null if not found
     */
    public Exam findExam(int examId, List<Exam> inExams) {
        for (Exam exam : inExams) {
            if (exam.examId == examId) {
                return exam;
            }
        }
        return null;
    }

    /**
     * Finds a subject by ID using linear search
     * @param subjectId The subject ID to search for
     * @return The matching Subject object, or null if not found
     */
    public Subject findSubject(String subjectId){
        List<Subject> subjects = this.sortSubjectsById();
        for (Subject subject : subjects) {
            if(subject.id.equals(subjectId)){
                return subject;
            }
        }
        return null;
    }

    /**
     * Returns a copy of students sorted by student number
     * @return List of students sorted by student number
     */
    public List<Student> sortStudentsByNumber() {
        List<Student> studentsById =
                (List<Student>) db.students.clone();
        return studentsById;
    }

    /**
     * Returns a copy of subjects sorted by ID
     * @return List of subjects sorted by ID
     */
    public List<Subject> sortSubjectsById(){
        List<Subject> subjectsById =
                (List<Subject>) db.subjects.clone();
        return subjectsById;
    }

    /**
     * Sorts exams by subject ID using insertion sort
     * @return List of exams sorted by subject ID
     */
    public List<Exam> sortExamsBySubjectId(){
        List<Exam> examsToSort = (List<Exam>) db.exams.clone();
        int regCount = examsToSort.size();
        for (int unsorted_Indx = 1; unsorted_Indx < regCount; unsorted_Indx++) {
            Exam unsortedReg =
                    (Exam)examsToSort.get(unsorted_Indx);
            int sorted_Indx = unsorted_Indx - 1;
            while (sorted_Indx >= 0) {
                Exam sortedReg =
                        (Exam)examsToSort.get(sorted_Indx);
                if (sortedReg.subjectId.compareTo(unsortedReg.subjectId) > 0) {
                    examsToSort.set(sorted_Indx + 1, sortedReg);
                    sorted_Indx--; // Move to the next element to the left
                } else {
                    break;
                }
            }
            examsToSort.set(sorted_Indx + 1, unsortedReg);
        }
        return examsToSort;
    }

    /**
     * Adds a new student to the database
     * @param student The Student object to add
     */
    public void addStudent(Student student) {
        db.students.add(student);
    }

    /**
     * Removes a student from the database
     * @param student The Student object to remove
     */
    public void removeStudent(Student student) {
        db.students.remove(student);
    }

    /**
     * Generates a new student number based on the last student number
     * @return New student number
     */
    public int newStudentNumber() {
        List<Student> students = this.sortStudentsByNumber();
        Student lastStudent = students.get(students.size() - 1);
        int lastId = lastStudent.getStudentNumber();
        return lastId++;
    }

    /**
     * Main method to demonstrate sorting functionality
     * @param args Command line arguments (not used)
     */
    public static void main(String [] args){
        StudentInfoSystem studentInfoSystem = new StudentInfoSystem();

         System.out.println("\n\nSORT SUBJECTS BY NAME\n");
         List<Subject> subjects = studentInfoSystem.sortSubjectsByName();
         for (Subject subject : subjects) {
         System.out.println(subject);
         }

         System.out.println("\n\nSORT STUDENTS BY NAME\n");
         List<Student> students = studentInfoSystem.sortStudentsByName();
         for (Student student : students) {
         System.out.println(student);
         }
    }
}