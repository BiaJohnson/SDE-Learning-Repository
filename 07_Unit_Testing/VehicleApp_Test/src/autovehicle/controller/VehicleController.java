package autovehicle.controller;

import autovehicle.model.AutonomousVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controller component of the MVC pattern for the Autonomous Vehicle System.
 * Manages vehicle data and processes user input for vehicle directions.
 *
 * <p>Features include:
 * <ul>
 *   <li>Strict input validation for turn commands</li>
 *   <li>Turn history tracking for each vehicle</li>
 *   <li>Efficient vehicle data management</li>
 * </ul>
 *
 * @author Shadman
 * @version 1.0
 */
public class VehicleController {
    private final List<AutonomousVehicle> vehicles;
    private final List<List<Character>> vehicleTurnHistory;
    /**
     * Constructs a new vehicle controller with initial capacity for 10 vehicles.
     */
    public VehicleController() {
        vehicles = new ArrayList<>(10);
        vehicleTurnHistory = new ArrayList<>(10);
    }
    /**
     * Adds a vehicle to the controller's managed collection.
     * Also initializes turn history tracking for the vehicle.
     *
     * @param vehicle The vehicle to add
     */
    public void addVehicle(AutonomousVehicle vehicle) {
        vehicles.add(vehicle);
        vehicleTurnHistory.add(new ArrayList<>());
    }

    /**
     * Gets all vehicles managed by this controller.
     *
     * @return A list of all vehicles
     */
    public List<AutonomousVehicle> getAllVehicles() {
        return vehicles;
    }
    /**
     * Gets a specific vehicle by its index.
     *
     * @param index The index of the vehicle to retrieve
     * @return The vehicle at the specified index, or null if the index is invalid
     */
    public AutonomousVehicle getVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            return vehicles.get(index);
        }
        return null;
    }
    /**
     * Gets the turn history for a specific vehicle.
     *
     * @param index The index of the vehicle
     * @return A list of turn commands made by the vehicle, or an empty list if the index is invalid
     */
    public List<Character> getTurnHistory(int index) {
        if (index >= 0 && index < vehicleTurnHistory.size()) {
            return vehicleTurnHistory.get(index);
        }
        return new ArrayList<>();
    }

    /**
     * Processes user direction commands for a vehicle with strict input validation.
     * Only accepts single-character inputs: 'L' for left, 'R' for right, 'S' to stop.
     *
     * @param vehicleIndex The index of the vehicle to process directions for
     * @param scanner Scanner for reading user input
     * @return The final direction after processing all turns
     */
    public char processUserDirections(int vehicleIndex, Scanner scanner) {
        if (vehicleIndex < 0 || vehicleIndex >= vehicles.size()) {
            return 'N'; // Default direction
        }

        AutonomousVehicle vehicle = vehicles.get(vehicleIndex);
        List<Character> turns = new ArrayList<>();

        System.out.println("Enter turns (L for left, R for right, S to stop):");
        System.out.println("Enter one character at a time. Multi-character inputs will be rejected.");

        while (true) {
            String input = scanner.nextLine().trim();

            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Please enter a command (L, R, or S).");
                continue;
            }

            // Check if input is exactly one character
            if (input.length() != 1) {
                System.out.println("Invalid input. Please enter exactly ONE character (L, R, or S).");
                continue;
            }

            // Convert to uppercase for case-insensitive comparison
            char turn = Character.toUpperCase(input.charAt(0));

            if (turn == 'S') {
                break;
            } else if (turn == 'L' || turn == 'R') {
                turns.add(turn);
                System.out.println("Turn added (Press 'S' to Stop): " + turn);
            } else {
                System.out.println("Invalid input. Please enter only L, R, or S.");
            }
        }

        // Store the turn history for this vehicle
        List<Character> history = vehicleTurnHistory.get(vehicleIndex);
        history.clear(); // Clear previous history
        history.addAll(turns); // Add new turns

        // Convert List<Character> to char[]
        char[] turnsArray = new char[turns.size()];
        for (int i = 0; i < turns.size(); i++) {
            turnsArray[i] = turns.get(i);
        }

        // Process the turns and return the final direction
        return vehicle.finalDirection(turnsArray);
    }
}
