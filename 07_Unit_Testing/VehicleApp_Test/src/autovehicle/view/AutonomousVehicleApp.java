package autovehicle.view;

import autovehicle.controller.VehicleController;
import autovehicle.model.GMVehicle;
import autovehicle.model.TeslaVehicle;
import autovehicle.model.ToyotaVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main application class that implements the Autonomous Vehicle System using the MVC pattern.
 * This class coordinates the interaction between the controller, view, and model components.
 *
 * <p>The application allows users to:
 * <ul>
 *   <li>Select from multiple autonomous vehicles</li>
 *   <li>Input directional commands (L for left, R for right)</li>
 *   <li>View the final direction and turn history for each vehicle</li>
 *   <li>See a summary of all vehicles and their directions upon exit</li>
 * </ul>
 *
 * @author Shadman
 * @version 1.0
 */
public class AutonomousVehicleApp {
    /**
     * The main entry point for the Autonomous Vehicle System application.
     * Initializes the MVC components, creates vehicle instances, and manages the
     * main interaction loop.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize MVC components
        VehicleController controller = new VehicleController();
        VehicleView view = new VehicleView();
        Scanner scanner = new Scanner(System.in);

        // Create vehicles
        TeslaVehicle car1 = new TeslaVehicle(5, "Model S", "Red");
        ToyotaVehicle car2 = new ToyotaVehicle(3, "Prius", "Blue");
        GMVehicle car3 = new GMVehicle(4, "Cruise", "Silver", "robotaxi");

        // Add vehicles to controller
        controller.addVehicle(car1);
        controller.addVehicle(car2);
        controller.addVehicle(car3);

        // Main application loop
        while (true) {
            // Display menu and get user choice
            int selectedIndex = view.displayMainMenu(controller.getAllVehicles(), scanner);

            // Exit if user chose to exit
            if (selectedIndex == -1) {
                break;
            }

            // Get the selected vehicle
            var selectedVehicle = controller.getVehicle(selectedIndex);

            // Display vehicle details
            view.displayVehicleDetails(selectedVehicle);

            // Process user directions
            char finalDirection = controller.processUserDirections(selectedIndex, scanner);

            // Display the final direction with turn history
            view.displayFinalDirectionWithTurns(
                    selectedVehicle,
                    finalDirection,
                    controller.getTurnHistory(selectedIndex)
            );
        }

        // Collect all turn histories for the summary
        List<List<Character>> allTurnHistories = new ArrayList<>();
        for (int i = 0; i < controller.getAllVehicles().size(); i++) {
            allTurnHistories.add(controller.getTurnHistory(i));
        }

        // Display summary before exiting
        view.displaySummary(controller.getAllVehicles(), allTurnHistories);

        // Close resources
        scanner.close();
        System.out.println("Thank you for using the Autonomous Vehicle System!");
    }
}
