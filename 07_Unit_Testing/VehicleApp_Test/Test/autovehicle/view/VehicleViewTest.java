package autovehicle.view;

import autovehicle.model.AutonomousVehicle;
import autovehicle.model.TeslaVehicle;
import autovehicle.model.ToyotaVehicle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class VehicleViewTest {
    private VehicleView vehicleView;
    private ByteArrayOutputStream outputStreamCaptor;
    private final PrintStream standardOut = System.out;

    /**
     * Supporting methods to create Tesla, Toyota and GM objects
     */
    public AutonomousVehicle createToyota() {
        return new ToyotaVehicle(3, "Prius", "Blue");
    }


    public AutonomousVehicle createTesla() {
        return new TeslaVehicle(5, "Model S", "Red");
    }
    /**
     * Sets up the test environment before each test method.
     * This method:
     * - Creates a new VehicleView instance
     * - Initializes a ByteArrayOutputStream to capture console output
     * - Redirects System.out to the output stream captor
     */


    @Before
    public void setUp() {
        vehicleView = new VehicleView();
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Cleans up the test environment after each test method.
     * This method restores the standard output stream to its original state
     * to ensure normal console functionality is restored.
     */

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Test display menu with valid selection")
    public void testDisplayMainMenu_ValidSelection() {

        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        AutonomousVehicle toyota = createToyota();
        vehicles.add(tesla);
        vehicles.add(tesla);
        vehicles.add(toyota);

        String input = "1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // Act
        int result = vehicleView.displayMainMenu(vehicles, scanner);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("AUTONOMOUS VEHICLE SYSTEM"));
        assertTrue(output.contains("Model S"));
        assertTrue(output.contains("Prius"));
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test display menu exit")
    public void testDisplayMainMenu_Exit() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        vehicles.add(tesla);

        String input = "0\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // Act
        int result = vehicleView.displayMainMenu(vehicles, scanner);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Test display menu with invalid input")
    public void testDisplayMainMenu_InvalidInput() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        vehicles.add(tesla);

        String input = "invalid\n1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // Act
        int result = vehicleView.displayMainMenu(vehicles, scanner);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Please enter a valid number"));
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test display vehicle details")
    public void testDisplayVehicleDetails() {
        // Arrange
        AutonomousVehicle vehicle = createTesla();

        // Act
        vehicleView.displayVehicleDetails(vehicle);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("SELECTED VEHICLE"));
        assertTrue(output.contains("Model S"));
        assertTrue(output.contains("Red"));
    }

    @Test
    @DisplayName("Test display final direction with turns")
    public void testDisplayFinalDirectionWithTurns_WithTurns() {
        // Arrange
        AutonomousVehicle vehicle = createTesla();
        List<Character> turns = Arrays.asList('L', 'R', 'L');

        // Act
        vehicleView.displayFinalDirectionWithTurns(vehicle, 'N', turns);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("FINAL DIRECTION"));
        assertTrue(output.contains("Model S"));
        assertTrue(output.contains("L, R, L"));
        assertTrue(output.contains("Final Direction: N"));
    }

    @Test
    @DisplayName("Test display final direction  with no turns")
    public void testDisplayFinalDirectionWithTurns_NoTurns() {
        // Arrange
        AutonomousVehicle vehicle = createTesla();
        List<Character> turns = new ArrayList<>();

        // Act
        vehicleView.displayFinalDirectionWithTurns(vehicle, 'N', turns);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("No turns made"));
    }

    @Test
    @DisplayName("Test display summary with multiple vehicles")
    public void testDisplaySummary_WithMultipleVehicles() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        AutonomousVehicle toyota = createToyota();
        vehicles.add(tesla);
        vehicles.add(toyota);

        List<List<Character>> allTurnHistory = new ArrayList<>();
        allTurnHistory.add(Arrays.asList('L', 'R'));
        allTurnHistory.add(Arrays.asList('L'));

        // Act
        vehicleView.displaySummary(vehicles, allTurnHistory);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("FINAL SUMMARY"));
        assertTrue(output.contains("Model S"));
        assertTrue(output.contains("Prius"));
        assertTrue(output.contains("L, R"));
        assertTrue(output.contains("L"));
    }

    @Test
    @DisplayName("Test display summary with no turns history")
    public void testDisplaySummary_EmptyTurnHistory() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        vehicles.add(tesla);

        List<List<Character>> allTurnHistory = new ArrayList<>();
        allTurnHistory.add(new ArrayList<>());

        // Act
        vehicleView.displaySummary(vehicles, allTurnHistory);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("FINAL SUMMARY"));
        assertTrue(output.contains("Model S"));
        assertTrue(output.contains("None"));
    }

    @Test
    @DisplayName("Test display menu with out of range option")
    public void testDisplayMainMenu_OutOfRangeSelection() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        vehicles.add(tesla);

        String input = "99\n1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // Act
        int result = vehicleView.displayMainMenu(vehicles, scanner);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Invalid choice"));
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test display menu with a negative number")
    public void testDisplayMainMenu_NegativeNumberInput() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        AutonomousVehicle toyota = createToyota();
        vehicles.add(tesla);
        vehicles.add(toyota);

        // Input: first try negative number (-1), then valid input (1)
        String input = "-1\n1\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // Act
        int result = vehicleView.displayMainMenu(vehicles, scanner);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Invalid choice. Please try again."));
        assertEquals(0, result); // Should eventually return 0 (first vehicle) after valid input
    }

    @Test
    @DisplayName("Test display summary multiple vehicles with different turns")
    public void testDisplaySummary_MixedTurnLists() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        AutonomousVehicle toyota = createToyota();
        vehicles.add(tesla);
        vehicles.add(toyota);
        vehicles.add(new TeslaVehicle(5, "Model 3", "White")); //create new tesla with different conf.

        List<List<Character>> allTurnHistory = new ArrayList<>();
        allTurnHistory.add(Arrays.asList('L', 'R')); // Non-empty turn list
        allTurnHistory.add(new ArrayList<>()); // Empty turn list
        allTurnHistory.add(Arrays.asList('L')); // Non-empty turn list

        // Act
        vehicleView.displaySummary(vehicles, allTurnHistory);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("FINAL SUMMARY"));
        assertTrue(output.contains("L, R")); // First vehicle's turns
        assertTrue(output.contains("None")); // Second vehicle's turns
        assertTrue(output.contains("L")); // Third vehicle's turns

        // Verify the order and content
        String[] lines = output.split("\n");
        boolean foundEmpty = false;
        for (String line : lines) {
            if (line.contains("Prius")) {
                assertTrue(output.contains("Turns: None"));
                foundEmpty = true;
            }
        }
        assertTrue("Should find the empty turn list", foundEmpty);
    }

    @Test
    @DisplayName("Test display summary for multiple vehicles with no turns")
    public void testDisplaySummary_AllEmptyTurnLists() {
        // Arrange
        List<AutonomousVehicle> vehicles = new ArrayList<>();
        AutonomousVehicle tesla = createTesla();
        AutonomousVehicle toyota = createToyota();
        vehicles.add(tesla);
        vehicles.add(toyota);

        List<List<Character>> allTurnHistory = new ArrayList<>();
        allTurnHistory.add(new ArrayList<>()); // Empty turn list
        allTurnHistory.add(new ArrayList<>()); // Empty turn list

        // Act
        vehicleView.displaySummary(vehicles, allTurnHistory);

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("FINAL SUMMARY"));

        // Count occurrences of "None"
        long noneCount = Arrays.stream(output.split("\n"))
                .filter(line -> line.contains("Turns: None"))
                .count();
        assertEquals(2, noneCount);

        // Verify no commas are present (which would indicate turns)
        assertFalse(output.contains(","));
    }

}
