package autovehicle.view;

import autovehicle.model.AutonomousVehicle;

import java.util.List;
import java.util.Scanner;

/**
 * View component of the MVC pattern for the Autonomous Vehicle System.
 * Handles all user interface display and formatting.
 *
 * <p>Features include:
 * <ul>
 *   <li>Main menu display and user selection</li>
 *   <li>Vehicle details display</li>
 *   <li>Turn history visualization</li>
 *   <li>Summary reports</li>
 * </ul>
 *
 * @author Shadman
 * @version 1.0
 */
public class VehicleView {

    /**
     * Displays the main menu and gets the user's vehicle selection.
     *
     * @param vehicles List of available vehicles
     * @param scanner Scanner for reading user input
     * @return The index of the selected vehicle, or -1 to exit
     */
    public int displayMainMenu(List<AutonomousVehicle> vehicles, Scanner scanner) {
        while (true) {
            System.out.println("\n=== AUTONOMOUS VEHICLE SYSTEM ===");
            System.out.println("Select a vehicle to control:");

            for (int i = 0; i < vehicles.size(); i++) {
                AutonomousVehicle vehicle = vehicles.get(i);
                System.out.printf("%d. %s %s (%s)\n",
                        i + 1, vehicle.getMake(), vehicle.getModel(), vehicle.getColor());
            }

            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 0) {
                    return -1; // Exit
                } else if (choice >= 1 && choice <= vehicles.size()) {
                    return choice - 1; // Convert to zero-based index
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Displays detailed information about a specific vehicle.
     *
     * @param vehicle The vehicle to display details for
     */
    public void displayVehicleDetails(AutonomousVehicle vehicle) {
        System.out.println("\n=== SELECTED VEHICLE ===");
        System.out.println(vehicle);
    }
    /**
     * Displays the final direction and turn history after processing turns.
     *
     * @param vehicle The vehicle that was controlled
     * @param direction The final direction of the vehicle
     * @param turns The list of turns made by the vehicle
     */
    public void displayFinalDirectionWithTurns(AutonomousVehicle vehicle, char direction, List<Character> turns) {
        System.out.println("\n=== FINAL DIRECTION ===");
        System.out.printf("Vehicle: %s %s\n", vehicle.getMake(), vehicle.getModel());
        System.out.printf("Final Direction: %c\n", direction);

        // Display the turn history
        System.out.println("Turn History: ");
        if (turns.isEmpty()) {
            System.out.println("No turns made.");
        } else {
            StringBuilder turnList = new StringBuilder();
            for (Character turn : turns) {
                turnList.append(turn).append(", ");
            }
            // Remove the trailing comma and space
            if (turnList.length() > 0) {
                turnList.setLength(turnList.length() - 2);
            }
            System.out.println(turnList.toString());
        }
    }

    /**
     * Displays a summary of all vehicles, their final directions, and turn histories.
     * Used when exiting the application.
     *
     * @param vehicles List of all vehicles
     * @param allTurnHistory List of turn histories for all vehicles
     */
    public void displaySummary(List<AutonomousVehicle> vehicles, List<List<Character>> allTurnHistory) {
        System.out.println("\n=== FINAL SUMMARY ===");

        for (int i = 0; i < vehicles.size(); i++) {
            AutonomousVehicle vehicle = vehicles.get(i);
            List<Character> turns = allTurnHistory.get(i);

            System.out.printf("%s %s: Final Direction %c\n",
                    vehicle.getMake(), vehicle.getModel(), vehicle.getDirection());

            // Display turn history for this vehicle
            System.out.print("  Turns: ");
            if (turns.isEmpty()) {
                System.out.println("None");
            } else {
                StringBuilder turnList = new StringBuilder();
                for (Character turn : turns) {
                    turnList.append(turn).append(", ");
                }
                // Remove the trailing comma and space
                if (turnList.length() > 0) {
                    turnList.setLength(turnList.length() - 2);
                }
                System.out.println(turnList.toString());
            }
        }
    }
}
