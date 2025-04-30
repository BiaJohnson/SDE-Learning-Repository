import java.util.Scanner;
/**
 The {@code IdeaTracker} class provides a simple console-based application
 that allows users to read and write idea descriptions to files.
 */
public class IdeaTracker {
    /**
     The main method serves as the entry point for the Idea Tracker application.
     It presents a menu to the user for selecting an operation: reading a file,
     writing a file, or exiting the program.
     *
     @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            // Display a menu to the user for easy interaction
            System.out.println("\nWelcome to the Idea Tracker!");
            System.out.println("Select an option to continue:");
            System.out.println("1. Read a file");
            System.out.println("2. Write a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1, 2, or 3): ");
            // Read the user's menu choice
            int choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    // Consume the leftover newline character
                    keyboard.nextLine();
                    // Initialize an IdeaReader object
                    IdeaReader ideaReader = new IdeaReader();
                    // Prompt the user for the file path to read
                    System.out.print("Please enter the file path to read: ");
                    String filePath = keyboard.nextLine();
                    // Call the readIdea() method to read the file and store its contents
                    String contentsReadFromFile = ideaReader.readIdea(filePath);
                    // Display the file contents
                    System.out.println("--------------------------------------------------");
                    System.out.println(contentsReadFromFile);
                    System.out.println("--------------------------------------------------");
                    break;
                case 2:
                    // Consume the leftover newline character from the previous input
                    keyboard.nextLine();
                    // Initialize an IdeaWriter object
                    IdeaWriter ideaWriter = new IdeaWriter();
                    // Prompt the user for the name of the idea
                    System.out.println("Please enter the name of the idea: ");
                    String ideaName = keyboard.nextLine();
                    // Construct the file path by prepending "src/" and appending ".txt"
                    String ideaFilePath = "src/" + ideaName + ".txt";
                    // Prompt the user for a description of the project
                    System.out.println("Please enter some description for the project: ");
                    String ideaDescription = keyboard.nextLine();
                    // Call the writeIdea() method to write the content to the new file
                    ideaWriter.writeIdea(ideaFilePath, ideaDescription);
                    break;
                case 3:
                    // Exit the program
                    System.out.println("Thank you for using the Idea Tracker!");
                    keyboard.close(); // Close the scanner before exiting
                    return;
                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
