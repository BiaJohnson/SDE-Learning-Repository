import java.util.Scanner;
/**
 * The WaitingList class manages a student waiting list system with various operations
 * for managing student records.
 */
public class WaitingList {
    /**
     * The main method that runs the waiting list management system.
     * It provides a menu-driven interface for various student management operations.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create and initialize array of students with sample data
        Student [] students = new Student[6];
        students[0] = new Student(1, "Bill", "Jones", "UNDER-REVIEW");
        students[1] = new Student(2, "John", "Smith", "UNDER-REVIEW");
        students[2] = new Student(3, "Wally", "Wiggles", "ENROLLED");
        students[3] = new Student(4, "May", "Hanks", "UNDER-REVIEW");
        students[4] = new Student(5, "Jane", "Carson", "UNDER-REVIEW");
        students[5] = new Student(6, "Lori", "Random", "UNDER-REVIEW");

        // Create list manager instance to handle student operations
        ListManager listManager = new ListManager(students);

        // Variables for menu operation
        int choice = 0;
        String studentLastName = null;

        // Main program loop
        do {
            // Display menu
            System.out.println("\nPlease select an operation (1-8):");
            System.out.println("1. List all Students.");
            System.out.println("2. Find Student by lastname.");
            System.out.println("3. Change Student status.");
            System.out.println("4. Remove Student.");
            System.out.println("5. List first Student.");
            System.out.println("6. List last Student.");
            System.out.println("7. Find Next Student (Find the student after a given last name).");
            System.out.println("8. Find Previous Student (Find the student before a given last name).");
            System.out.println("9. Exit Program");

            // Handle user input with error checking
            try {
                System.out.print("Enter your choice (1-8): ");
                choice = scanner.nextInt();

                if (choice < 1 || choice > 9) {
                    System.out.println("Invalid input! Please enter a number between 1 and 8.");
                    continue;
                }
                // Process user choice
                switch (choice) {
                    case 1:
                        listManager.listStudents();
                        break;
                    case 2:
                        System.out.print("Enter student's last name: ");
                        scanner.nextLine(); // Clear the buffer
                        studentLastName = scanner.nextLine();
                        // transform the first letter to uppercase
                        studentLastName = studentLastName.substring(0, 1).toUpperCase() + studentLastName.substring(1).toLowerCase();

                        // Input validation for last name
                        if (studentLastName == null || studentLastName.trim().isEmpty()) {
                            System.out.println("Last name cannot be empty. Please try again.");
                        } else {
                            System.out.println("Find Student: ");
                            listManager.findStudent(studentLastName);
                        }
                        break;
                    case 3:
                        System.out.print("Enter student's last name: ");
                        scanner.nextLine(); // Clear the buffer
                        studentLastName = scanner.nextLine();

                        // Input validation for last name
                        if (studentLastName == null || studentLastName.trim().isEmpty()) {
                            System.out.println("Last name cannot be empty. Please try again.");
                        } else {
                            System.out.println("Changing Student Status: ");
                            listManager.updateStudentStatus(studentLastName, "ENROLLED");
                        }
                        break;
                    case 4:
                        System.out.print("Enter student's last name: ");
                        scanner.nextLine(); // Clear the buffer
                        studentLastName = scanner.nextLine();

                        // Input validation for last name
                        if (studentLastName == null || studentLastName.trim().isEmpty()) {
                            System.out.println("Last name cannot be empty. Please try again.");
                        } else {
                            System.out.println("Removing Student: ");
                            listManager.removeStudent(studentLastName);
                        }
                        break;
                    case 5:
                        listManager.findFirstStudent();
                        break;
                    case 6:
                        listManager.findLastStudent();
                        break;
                    case 7:
                        System.out.print("Enter student's last name: ");
                        scanner.nextLine(); // Clear the buffer
                        studentLastName = scanner.nextLine();

                        // Input validation for last name
                        if (studentLastName == null || studentLastName.trim().isEmpty()) {
                            System.out.println("Last name cannot be empty. Please try again.");
                        } else {
                            listManager.findNextStudent(studentLastName);
                        }
                        break;
                    case 8:
                        System.out.print("Enter student's last name: ");
                        scanner.nextLine(); // Clear the buffer
                        studentLastName = scanner.nextLine();

                        // Input validation for last name
                        if (studentLastName == null || studentLastName.trim().isEmpty()) {
                            System.out.println("Last name cannot be empty. Please try again.");
                        } else {
                            listManager.findPreviousStudent(studentLastName);
                        }
                        break;
                    case 9:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("\nInvalid option selected.\n");
                }
                // Handle invalid input type
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        } while (choice != 9);// Continue until user chooses to exit

        scanner.close();// Close scanner to prevent resource leak
    }
}

