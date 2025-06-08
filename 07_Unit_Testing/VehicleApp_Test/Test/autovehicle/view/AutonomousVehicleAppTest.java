package autovehicle.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * Test class for the AutonomousVehicleApp application.
 * Contains test cases for various user interaction scenarios with the autonomous vehicle system.
 */
public class AutonomousVehicleAppTest {
    // Captures console output for verification in tests
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    // Stores reference to standard output stream
    private final PrintStream standardOut = System.out;

    /**
     * Set up method run before each test.
     * Redirects System.out to capture console output.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Tear down method run after each test.
     * Restores System.out and System.in to their original states.
     */
    @After
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(System.in);
    }

    /**
     * Tests the selection and control of multiple vehicles.
     * Verifies that the system correctly handles commands for Tesla, Toyota and GM vehicles.
     */
    @Test
    @DisplayName("Test multiple vehicle selection")
    public void testMainFlow_MultipleVehicleSelections() {
        // Create input string with vehicle selections and directions
        String input = "1\n" +    // Select Tesla
                "L\n" +     // Turn left
                "R\n" +     // Turn right
                "S\n" +     // Stop Tesla directions
                "2\n" +     // Select Toyota
                "L\n" +     // Turn left
                "R\n" +     // Turn right
                "S\n" +     // Stop Toyota directions
                "3\n" +     // Select GM
                "L\n" +     // Turn left
                "L\n" +     // Turn left again
                "S\n" +     // Stop GM directions
                "0\n";      // Exit program

        // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main application
        AutonomousVehicleApp.main(new String[]{});

        // Verify expected output for each vehicle
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Tesla Model S"));
        assertTrue(output.contains("Toyota Prius"));
        assertTrue(output.contains("GM Cruise"));
    }

    /**
     * Tests the selection and control of a single vehicle.
     * Verifies that the system correctly handles multiple commands for a Tesla vehicle.
     */
    @Test
    @DisplayName("Test single vehicle selection")
    public void testMainFlow_SingleVehicleSelection() {
        String input = "1\n" +    // Select Tesla
                "L\n" +     // Turn left
                "R\n" +     // Turn right
                "L\n" +     // Turn left
                "S\n" +     // Stop directions
                "0\n";      // Exit program

        // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main application
        AutonomousVehicleApp.main(new String[]{});

        // Verify Tesla-specific output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Tesla Model S"));
    }

    /**
     * Tests immediate program exit.
     * Verifies that the system handles immediate exit command correctly.
     */
    @Test
    @DisplayName("Test immediate exit")
    public void testMainFlow_ImmediateExit() {
        String input = "0\n";     // Exit immediately

        // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main application
        AutonomousVehicleApp.main(new String[]{});

        // Verify exit message
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Thank you for using the Autonomous Vehicle System"));
    }

    /**
     * Tests system response to invalid user input.
     * Verifies that the system properly handles and recovers from invalid input.
     */
    @Test
    @DisplayName("Test invalid inputs")
    public void testMainFlow_InvalidInput() {
        String input = "invalid\n" +  // Invalid input
                "1\n" +        // Select Tesla
                "L\n" +        // Turn left
                "R\n" +        // Turn right
                "L\n" +        // Turn left
                "S\n" +        // Stop directions
                "0\n";         // Exit program

        // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the main application
        AutonomousVehicleApp.main(new String[]{});

        // Verify error message
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Please enter a valid number"));
    }
}