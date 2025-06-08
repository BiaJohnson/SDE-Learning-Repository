package autovehicle.controller;

import autovehicle.model.AutonomousVehicle;
import autovehicle.model.TeslaVehicle;
import autovehicle.model.ToyotaVehicle;
import autovehicle.model.GMVehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for VehicleController functionality.
 * Tests vehicle management and direction processing capabilities.
 */
public class VehicleControllerTest {

    /** The controller instance used for testing */
    private VehicleController controller;

    /**
     * Sets up a new VehicleController instance before each test.
     */
    @BeforeEach
    public void setUp() {
        controller = new VehicleController();
    }

    /**
     * Tests adding multiple vehicles of different types to the controller.
     * Verifies that vehicles are properly added and can be retrieved.
     */
    @Test
    @DisplayName("Test adding multiple vehicles")
    public void testAddMultipleVehicles() {

        // Create and add vehicles
        TeslaVehicle tesla = new TeslaVehicle(5, "Model S", "Red");
        ToyotaVehicle toyota = new ToyotaVehicle(3, "Prius", "Blue");
        GMVehicle gm = new GMVehicle(4, "Cruise", "Silver", "robotaxi");

        controller.addVehicle(tesla);
        controller.addVehicle(toyota);
        controller.addVehicle(gm);

        // Get and verify vehicles
        List<AutonomousVehicle> vehicles = controller.getAllVehicles();
        assertEquals(3, vehicles.size(), "Should have added 3 vehicles");
        assertTrue(vehicles.contains(tesla), "Should contain Tesla vehicle");
        assertTrue(vehicles.contains(toyota), "Should contain Toyota vehicle");
        assertTrue(vehicles.contains(gm), "Should contain GM vehicle");
    }

    /**
     * Tests retrieving all vehicles from the controller.
     * Verifies correct order and content of the returned list.
     */
    @Test
    @DisplayName("Test getting all vehicles")
    public void testGetAllVehicles() {
        TeslaVehicle tesla1 = new TeslaVehicle(5, "Model S", "Red");
        TeslaVehicle tesla2 = new TeslaVehicle(5, "Model 3", "White");
        ToyotaVehicle toyota = new ToyotaVehicle(3, "Prius", "Blue");

        controller.addVehicle(tesla1);
        controller.addVehicle(tesla2);
        controller.addVehicle(toyota);

        List<AutonomousVehicle> vehicles = controller.getAllVehicles();
        assertEquals(3, vehicles.size());
        assertEquals(tesla1, vehicles.get(0));
        assertEquals(tesla2, vehicles.get(1));
        assertEquals(toyota, vehicles.get(2));
    }

    /**
     * Tests getting all vehicles when the controller is empty.
     * Should return an empty list.
     */
    @Test
    @DisplayName("Test getting all vehicles when empty")
    public void testGetAllVehiclesEmptyList() {
        List<AutonomousVehicle> vehicles = controller.getAllVehicles();
        assertTrue(vehicles.isEmpty());
    }

    /**
     * Tests retrieving specific vehicles by index.
     * Verifies correct vehicles are returned at their respective indices.
     */
    @Test
    @DisplayName("Test get specific vehicle")
    public void testGetVehicle() {
        TeslaVehicle tesla = new TeslaVehicle(5, "Model S", "Red");
        ToyotaVehicle toyota = new ToyotaVehicle(3, "Prius", "Blue");

        controller.addVehicle(tesla);
        controller.addVehicle(toyota);

        assertEquals(tesla, controller.getVehicle(0));
        assertEquals(toyota, controller.getVehicle(1));
    }

    /**
     * Tests getting a vehicle with an invalid index.
     * Should return null.
     */
    @Test
    @DisplayName("Test get vehicle with invalid index")
    public void testGetVehicleInvalidIndex() {
        assertNull(controller.getVehicle(0),
                "Should return null when accessing invalid index");
    }

    /**
     * Tests processing of vehicle direction commands and history tracking.
     * Verifies correct final direction and turn history recording.
     */
    @Test
    @DisplayName("Test process vehicle direction history")
    public void testProcessUserDirectionsAndHistory() {
        // Setup
        TeslaVehicle tesla = new TeslaVehicle(5, "Model S", "Red");
        controller.addVehicle(tesla);

        // Create input with multiple turns and a stop command
        String input = "L\nR\nL\nS\n";
        Scanner scanner = new Scanner(input);

        // Process the directions
        char finalDirection = controller.processUserDirections(0, scanner);

        // Test the final direction
        assertEquals('W', finalDirection, "Final direction should be West after LRL sequence");

        // Test the turn history
        List<Character> history = controller.getTurnHistory(0);
        assertNotNull(history, "Turn history should not be null");
        assertEquals(3, history.size(), "Should have recorded 3 turns");
        assertEquals('L', history.get(0), "First turn should be Left");
        assertEquals('R', history.get(1), "Second turn should be Right");
        assertEquals('L', history.get(2), "Third turn should be Left");
    }

    /**
     * Tests getting turn history with an invalid vehicle index.
     * Should return an empty list.
     */
    @Test
    @DisplayName("Test get turn history with invalid index")
    public void testGetTurnHistoryInvalidIndex() {
        List<Character> history = controller.getTurnHistory(999);
        assertNotNull(history, "Should return empty list for invalid index");
        assertTrue(history.isEmpty(), "Should return empty list for invalid index");
    }

    /**
     * Tests processing directions for an invalid vehicle index.
     * Should return 'N' as default direction.
     */
    @Test
    @DisplayName("Test process vehicle direction with invalid index")
    public void testProcessUserDirectionsInvalidIndex() {
        Scanner scanner = new Scanner("L\nS\n");
        char result = controller.processUserDirections(999, scanner);
        assertEquals('N', result, "Should return 'N' for invalid vehicle index");
    }

    /**
     * Tests case-insensitive processing of direction commands.
     * Verifies that lowercase commands are handled correctly.
     */
    @Test
    @DisplayName("Test process vehicle directions case insensitive")
    public void testProcessUserDirectionsCaseInsensitive() {
        // Setup
        TeslaVehicle tesla = new TeslaVehicle(5, "Model S", "Red");
        controller.addVehicle(tesla);

        // Test lowercase inputs
        String input = "l\nr\ns\n";
        Scanner scanner = new Scanner(input);

        char finalDirection = controller.processUserDirections(0, scanner);

        // Check turn history
        List<Character> history = controller.getTurnHistory(0);
        assertEquals(2, history.size(), "Should record 2 turns regardless of case");
        assertEquals('L', history.get(0), "First turn should be recorded as uppercase L");
        assertEquals('R', history.get(1), "Second turn should be recorded as uppercase R");
    }

    /**
     * Tests getting a vehicle with negative indices.
     * Verifies null is returned for negative indices.
     */
    @Test
    @DisplayName("Test get vehicle with a negative index")
    public void testGetVehicleNegativeIndex() {
        // Test with negative index
        assertNull(controller.getVehicle(-1),
                "Should return null when accessing negative index");

        // Add a vehicle to ensure the method still works with valid indices
        TeslaVehicle tesla = new TeslaVehicle(5, "Model S", "Red");
        controller.addVehicle(tesla);

        // Test negative index again with non-empty list
        assertNull(controller.getVehicle(-5),
                "Should return null when accessing negative index even with vehicles in list");

        // Verify that valid index still works
        assertNotNull(controller.getVehicle(0),
                "Should return vehicle for valid index");
    }

    /**
     * Tests getting turn history with negative indices.
     * Verifies empty list is returned for negative indices.
     */
    @Test
    @DisplayName("Test get turn history with a negative index")
    public void testGetTurnHistoryNegativeIndex() {
        // Test with negative index on empty list
        List<Character> historyEmpty = controller.getTurnHistory(-1);
        assertNotNull(historyEmpty, "Should return empty list for negative index");
        assertTrue(historyEmpty.isEmpty(), "Should return empty list for negative index");

        // Add a vehicle and make some turns
        TeslaVehicle tesla = new TeslaVehicle(5, "Model S", "Red");
        controller.addVehicle(tesla);
        controller.processUserDirections(0, new Scanner("L\nR\nS\n"));

        // Test with negative index when history exists
        List<Character> historyWithData = controller.getTurnHistory(-1);
        assertNotNull(historyWithData, "Should return empty list for negative index even with existing history");
        assertTrue(historyWithData.isEmpty(), "Should return empty list for negative index even with existing history");

        // Test with different negative values
        List<Character> historyNegativeFive = controller.getTurnHistory(-5);
        assertTrue(historyNegativeFive.isEmpty(), "Should return empty list for any negative index");
    }
}