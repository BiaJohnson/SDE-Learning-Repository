import java.util.ArrayList;
import java.util.List;

/**
 * Database class that manages the student registration system.
 * Contains lists of students, subjects and exams and handles initialization of test data.
 */
public class Database {
    // List to store all students in the system
    ArrayList<Student> students = new ArrayList<>();
    // List to store all available subjects
    ArrayList<Subject> subjects = new ArrayList<>();
    // List to store all scheduled exams
    ArrayList<Exam> exams = new ArrayList<>();

    /**
     * Constructor that initializes the database with test data.
     * Creates subjects, exams and students and assigns subjects and exams to students.
     */
    public Database(){

        // populate the subjects list with available courses
        subjects.add(new Subject("100", "Mathematics"));
        subjects.add(new Subject("101", "Physics"));
        subjects.add(new Subject("102", "Chemistry"));
        subjects.add(new Subject("103", "Biology"));
        subjects.add(new Subject("104", "Computer Science"));
        subjects.add(new Subject("105", "History"));
        subjects.add(new Subject("106", "English Literature"));
        subjects.add(new Subject("107", "Philosophy"));
        subjects.add(new Subject("108", "Economics"));
        subjects.add(new Subject("109", "Art"));

        // Create exam schedule - 2 exams per subject on different dates/times
        exams.add(new Exam(2, "101", "2025-12-01", "12:00"));  // Physics exam 1
        exams.add(new Exam(3, "102", "2025-12-01", "15:00"));  // Chemistry exam 1
        exams.add(new Exam(4, "103", "2025-12-02", "09:00"));  // Biology exam 1
        exams.add(new Exam(5, "104", "2025-12-02", "12:00"));  // Computer Science exam 1
        exams.add(new Exam(6, "105", "2025-12-02", "15:00"));  // History exam 1
        exams.add(new Exam(7, "106", "2025-12-03", "09:00"));  // English Literature exam 1
        exams.add(new Exam(8, "107", "2025-12-03", "12:00"));  // Philosophy exam 1
        exams.add(new Exam(9, "108", "2025-12-03", "15:00"));  // Economics exam 1
        exams.add(new Exam(10, "109", "2025-12-04", "09:00")); // Art exam 1
        exams.add(new Exam(11, "100", "2025-12-04", "12:00")); // Mathematics exam 1
        exams.add(new Exam(12, "101", "2025-12-04", "15:00")); // Physics exam 2
        exams.add(new Exam(13, "102", "2025-12-05", "09:00")); // Chemistry exam 2
        exams.add(new Exam(14, "103", "2025-12-05", "12:00")); // Biology exam 2
        exams.add(new Exam(15, "104", "2025-12-05", "15:00")); // Computer Science exam 2
        exams.add(new Exam(16, "105", "2025-12-06", "09:00")); // History exam 2
        exams.add(new Exam(17, "106", "2025-12-06", "12:00")); // English Literature exam 2
        exams.add(new Exam(18, "107", "2025-12-06", "15:00")); // Philosophy exam 2
        exams.add(new Exam(19, "108", "2025-12-07", "09:00")); // Economics exam 2
        exams.add(new Exam(20, "109", "2025-12-07", "12:00")); // Art exam 2
        exams.add(new Exam(21, "100", "2025-12-07", "15:00")); // Mathematics exam 2

        // Create 50 test students with IDs from 1001-1050
        students.add(new Student("Smith, Alice", 1001));
        students.add(new Student("Johnson, Bob", 1002));
        students.add(new Student("Williams, Charlie", 1003));
        students.add(new Student("Brown, David", 1004));
        students.add(new Student("Jones, Eve", 1005));
        students.add(new Student("Garcia, Frank", 1006));
        students.add(new Student("Miller, Grace", 1007));
        students.add(new Student("Davis, Hannah", 1008));
        students.add(new Student("Rodriguez, Ivy", 1009));
        students.add(new Student("Martinez, Jack", 1010));
        students.add(new Student("Hernandez, Kim", 1011));
        students.add(new Student("Lopez, Leo", 1012));
        students.add(new Student("Gonzalez, Mia", 1013));
        students.add(new Student("Wilson, Nina", 1014));
        students.add(new Student("Anderson, Oscar", 1015));
        students.add(new Student("Thomas, Paul", 1016));
        students.add(new Student("Taylor, Quinn", 1017));
        students.add(new Student("Moore, Ruth", 1018));
        students.add(new Student("Jackson, Sam", 1019));
        students.add(new Student("Martin, Tina", 1020));
        students.add(new Student("Lee, Uma", 1021));
        students.add(new Student("Perez, Victor", 1022));
        students.add(new Student("Thompson, Wendy", 1023));
        students.add(new Student("White, Xander", 1024));
        students.add(new Student("Harris, Yara", 1025));
        students.add(new Student("Sanchez, Zane", 1026));
        students.add(new Student("Clark, Amy", 1027));
        students.add(new Student("Ramirez, Brian", 1028));
        students.add(new Student("Lewis, Catherine", 1029));
        students.add(new Student("Robinson, Derek", 1030));
        students.add(new Student("Walker, Elena", 1031));
        students.add(new Student("Young, Felix", 1032));
        students.add(new Student("Allen, Gina", 1033));
        students.add(new Student("King, Harry", 1034));
        students.add(new Student("Wright, Isla", 1035));
        students.add(new Student("Scott, Jason", 1036));
        students.add(new Student("Torres, Katie", 1037));
        students.add(new Student("Nguyen, Liam", 1038));
        students.add(new Student("Hill, Megan", 1039));
        students.add(new Student("Flores, Noah", 1040));
        students.add(new Student("Green, Olivia", 1041));
        students.add(new Student("Adams, Peter", 1042));
        students.add(new Student("Nelson, Quincy", 1043));
        students.add(new Student("Baker, Rachel", 1044));
        students.add(new Student("Hall, Steve", 1045));
        students.add(new Student("Rivera, Tara", 1046));
        students.add(new Student("Campbell, Ulysses", 1047));
        students.add(new Student("Mitchell, Vanessa", 1048));
        students.add(new Student("Carter, Walter", 1049));
        students.add(new Student("Roberts, Zoe", 1050));

        // Assign 3 subjects to each student in a rotating pattern
        for (int i = 0; i < students.size(); i++) {
            // Group 1: Mathematics, Physics, Chemistry
            if (i % 3 == 0) {
                students.get(i).addSubject(subjects.get(0)); // Mathematics
                students.get(i).addSubject(subjects.get(1)); // Physics
                students.get(i).addSubject(subjects.get(2)); // Chemistry
            }
            // Group 2: Biology, Computer Science, History
            else if (i % 3 == 1) {
                students.get(i).addSubject(subjects.get(3)); // Biology
                students.get(i).addSubject(subjects.get(4)); // Computer Science
                students.get(i).addSubject(subjects.get(5)); // History
            }
            // Group 3: English Literature, Philosophy, Economics
            else {
                students.get(i).addSubject(subjects.get(6)); // English Literature
                students.get(i).addSubject(subjects.get(7)); // Philosophy
                students.get(i).addSubject(subjects.get(8)); // Economics
            }

            // Assign exams for each subject the student is enrolled in
            for(Subject subject : students.get(i).getSubjects()) {
                // Find all exams for this subject
                List<Exam> examOptions = new ArrayList<>();
                for(Exam exam : exams) {
                    if(exam.subjectId.compareTo(subject.id) == 0 ) {
                        examOptions.add(exam);
                    }
                }
                // Assign first exam slot to even-numbered students, second slot to odd-numbered
                if(i % 2 == 0) {
                    students.get(i).addExam(examOptions.get(0));
                }else {
                    students.get(i).addExam(examOptions.get(1));
                }
            }
        }
    }
}