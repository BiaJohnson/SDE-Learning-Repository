import java.util.Scanner;

/**
 The Main class simulates a simple car dashboard where the user can
 turn the engine on/off, change gears, accelerate, and brake.
 */

public class Main {
    /**
     The main method is the entry point of the program.
     It provides a menu-driven system for controlling a simulated car.
     */
    public static void main(String[] args) {

        /** Indicates whether the engine is on or off. */
        boolean isEngineOn = false;
        /** Represents the current gear of the car. */
        String gear = "P";
        /** Stores the current speed of the car. */
        int speed = 0;
        /** Stores the user's menu choice. */
        int choice = 0;
        /** Scanner object for reading user input. */
        Scanner keyBoard = new Scanner(System.in);
        // Display the initial dashboard status
        System.out.println("------ Car Dashboard ------");
        System.out.println("Speed: " + speed);
        System.out.println("Gear: " + gear);
        System.out.println("Is engine on: " + isEngineOn);
        // Display menu options
        System.out.println("Menu:");
        System.out.println("1. Turn on/off the engine");
        System.out.println("2. Change gear (P, D, R)");
        System.out.println("3. Accelerate.");
        System.out.println("4. Brake.");
        System.out.println("5. Exit.");
        // Prompt user for input
        System.out.print("Enter your choice: ");
        choice = keyBoard.nextInt();
        // Loop until the user chooses to exit
        while (choice != 5) {
            switch (choice) {
                case 1:
                    // Toggle engine state
                    isEngineOn = !isEngineOn;
                    if (isEngineOn) {
                        System.out.print("The engine is now: on \n");
                    } else {
                        System.out.print("The engine is now: off \n");
                    }
                    break;
                case 2:
                    // Change gear
                    System.out.print("Enter gear (P, D, R): ");
                    gear = keyBoard.next();
                    System.out.print("The gear is now: " + gear + "\n");
                    break;
                case 3:
                    // Increase speed only if the engine is on and the car is not in Park (P)
                    if (isEngineOn && !gear.equals("P")) {
                        speed += 10; // speed = speed + 10
                        System.out.print("The speed is now: " + speed + "\n");
                    } else {
                        System.out.println("Cannot accelerate while engine is off or in Park (P) gear.");
                    }
                    break;
                case 4:
                    // Reduce speed only if the engine is on and the car is moving
                    if (isEngineOn && speed != 0) {
                        speed -= 10;
                        System.out.print("The speed is now: " + speed + "\n");
                    } else {
                        System.out.println("Cannot brake while engine is off or speed is zero.");
                    }
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid input");
            }
            // Prompt user for the next choice
            System.out.print("Enter your choice: ");
            choice = keyBoard.nextInt();
        }
        // Exit message
        System.out.println("Thank you, bye!");
    }
}
