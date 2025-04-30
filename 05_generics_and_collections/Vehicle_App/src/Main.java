/**
 * Main class that handles vehicle simulation and user input processing.
 * This class creates instances of different car types and processes their turning sequences.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
/**
 * Main method that runs the autonomous vehicle simulation program.
 * Initializes different types of autonomous vehicles (Tesla, Toyota, GM),
 * processes user input for turning sequences, and displays final vehicle states.
 * @param args Command line arguments (not used in this implementation)
 */
    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // ArrayList to store vehicles to make it easier to add more vehicles in the future.
        ArrayList<AutonomousVehicle> vehicles = new ArrayList<>();

        // Create car instances and add them to ArrayList
        vehicles.add(new Tesla(5, "Model S", "Red"));
        vehicles.add(new Toyota(4, "Prius", "Silver"));
        vehicles.add(new GM(3, "Cruise", "White", "robotaxi"));

        System.out.println("=======================================\n" +
                           "Welcome to Autonomous Vehicle Program\n" +
                           "=======================================" );
        System.out.println("\nAll the vehicles starts at direction: NORTH.");

        // Loop through vehicles to process turns for each vehicle and display the vehicle details
        for (AutonomousVehicle vehicle : vehicles) {
            // Get the simple class name of the vehicle object to display the vehicle type
            String vehicleType = vehicle.getClass().getSimpleName();
            System.out.println("Please Enter the turns, one at a time, for " + vehicleType + " ('L' for left, 'R' for right, 'done' when finished): ");
            String[] turns = GetTurns.getTurnsFromUser(scanner);
            vehicle.final_direction(turns);
            vehicle.printVehicleDetails();
        }
        scanner.close();
    }
}
