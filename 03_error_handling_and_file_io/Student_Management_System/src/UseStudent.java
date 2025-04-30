/**
 The UseStudent class demonstrates exception handling by performing operations
 on Student objects, including printing student details, listing students,
 and handling risky operations.
 */
public class UseStudent {
    /**
     The main method serves as the entry point of the program.
     It creates and manipulates Student objects while demonstrating error handling.
     */
    public static void main(String[] args) {
        // Attempting to print a null student object
        Student s = null;
        printStudent(s);
        // Creating an array of Student objects
        Student[] students = new Student[2];
        Student s1 = new Student("Student1", 20);
        Student s2 = new Student("Student2", 21);
        students[0] = s1;
        students[1] = s2;
        // Listing students from the array
        listStudents(students);
        // Performing a risky operation that may cause an exception
        thisIsRisky();
    }
    /**
     Prints the details of a given student.
     Handles NullPointerException if the student object is null.
     *
     @param student The Student object to print.
     */
    private static void printStudent(Student student) {
        try {
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
        } catch (NullPointerException e) {
            System.out.println("Error: Attempted to access properties of a null object.");
            System.out.println(e.getMessage());
        }
    }
    /**
     Lists all students in the given array.
     Handles ArrayIndexOutOfBoundsException if an invalid index is accessed.
     *
     @param students An array of Student objects.
     */
    private static void listStudents(Student[] students) {
        try {
            // Loop through the student array and print details
            for (int i = 0; i <= students.length; i++) { // Bug: 'i <= students.length' causes an exception
                System.out.println(students[i].getName() + " " + students[i].getAge());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds.");
            System.out.println(e.getMessage());
        }
    }
    /**
     Demonstrates division by zero, which triggers an ArithmeticException.
     Handles the exception and prints an appropriate error message.
     */
    private static void thisIsRisky() {
        try {
            int priceTag = 50;
            int discount = 0; // Risky operation: Division by zero
            System.out.println("Total = " + (priceTag / discount));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
            System.out.println(e.getMessage());
        }
    }
}