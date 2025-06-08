package autovehicle.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for AutonomousVehicle and its subclasses.
 * Tests constructors, direction changes, and validation logic.
 */
public class AutonomousVehicleTest {

    /**
     * Helper method to create an AutonomousVehicle instance
     * @param autonomyLevel The autonomy level (1-5)
     * @param make The vehicle manufacturer
     * @param model The vehicle model
     * @param color The vehicle color
     * @return A new AutonomousVehicle instance
     */
    private AutonomousVehicle createVehicle(int autonomyLevel, String make, String model, String color) {
        return new AutonomousVehicle(autonomyLevel, make, model, color);
    }

    /**
     * Helper method to create a GMVehicle instance
     * @param autonomyLevel The autonomy level (1-5)
     * @param model The vehicle model
     * @param color The vehicle color
     * @param vehicleType The type of vehicle (robotaxi or delivery)
     * @return A new GMVehicle instance
     */
    private GMVehicle createGMVehicle(int autonomyLevel, String model, String color, String vehicleType) {
        return new GMVehicle(autonomyLevel, model, color, vehicleType);
    }

    /**
     * Helper method to create a ToyotaVehicle instance
     * @param autonomyLevel The autonomy level (1-5)
     * @param model The vehicle model
     * @param color The vehicle color
     * @return A new ToyotaVehicle instance
     */
    private ToyotaVehicle createToyotaVehicle(int autonomyLevel, String model, String color) {
        return new ToyotaVehicle(autonomyLevel, model, color);
    }

    /**
     * Helper method to set a fixed date for testing
     * @param date The LocalDate to set as current
     */
    private void setFixedDate(LocalDate date) {
        Clock fixedClock = Clock.fixed(date.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        LocalDate.now(fixedClock);
    }

    /**
     * Tests the Tesla vehicle constructor and basic property getters
     */
    @Test
    @DisplayName("Test Tesla constructor")
    public void TeslaConstructorTest() {
        AutonomousVehicle vehicle = createVehicle(3, "Tesla", "Model S", "Red");
        assertEquals(3, vehicle.getAutonomyLevel());
        assertEquals("Tesla", vehicle.getMake());
        assertEquals("Model S", vehicle.getModel());
        assertEquals("Red", vehicle.getColor());
        assertEquals('N', vehicle.getDirection());
    }

    /**
     * Tests the GM vehicle constructor and basic property getters
     */
    @Test
    @DisplayName("Test GM constructor")
    public void GMTConstructorTest() {
        GMVehicle vehicle = createGMVehicle(3, "Prius", "Blue", "robotaxi");
        assertEquals(3, vehicle.getAutonomyLevel());
        assertEquals("GM", vehicle.getMake()); // GM is set automatically in GMVehicle constructor
        assertEquals("Prius", vehicle.getModel());
        assertEquals("Blue", vehicle.getColor());
        assertEquals('N', vehicle.getDirection());
        assertEquals("robotaxi", vehicle.getVehicleType());
    }

    /**
     * Tests Toyota vehicle constructor on a weekday when isLyft should be false
     */
    @Test
    @DisplayName("Test Toyota constructor for a weekday - is lyft (False)")
    public void ToyotaConstructorWeekdayTest() {
        // Set date to a Monday
        setFixedDate(LocalDate.of(2023, 5, 15)); // A Monday

        ToyotaVehicle vehicle = createToyotaVehicle(3, "Prius", "Silver");
        assertEquals(3, vehicle.getAutonomyLevel());
        assertEquals("Toyota", vehicle.getMake());
        assertEquals("Prius", vehicle.getModel());
        assertEquals("Silver", vehicle.getColor());
        assertEquals('N', vehicle.getDirection());
        assertTrue(vehicle.isLyft());
    }

    /**
     * Tests Toyota vehicle constructor on a Sunday when isLyft should be true
     */
    @Test
    @DisplayName("Test Toyota constructor for Sunday - is lyft (True)")
    public void ToyotaConstructorSundayTest() {
        LocalDate sunday = LocalDate.of(2023, 5, 21); // A Sunday
        try (MockedStatic<LocalDate> mockedStatic = Mockito.mockStatic(LocalDate.class)) {
            mockedStatic.when(LocalDate::now).thenReturn(sunday);

            ToyotaVehicle vehicle = createToyotaVehicle(3, "Prius", "Silver");
            assertEquals(3, vehicle.getAutonomyLevel());
            assertEquals("Toyota", vehicle.getMake());
            assertEquals("Prius", vehicle.getModel());
            assertEquals("Silver", vehicle.getColor());
            assertEquals('N', vehicle.getDirection());
            assertTrue(vehicle.isLyft());
        }
    }

    /**
     * Tests that constructor throws exception for autonomy level below minimum
     */
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test Tesla constructor for low invalid autonomy level.")
    public void TeslaConstructorInvalidAutonomyLevelLowTest() {
        new AutonomousVehicle(0, "Tesla", "Model S", "Red");
    }

    /**
     * Tests that constructor throws exception for autonomy level above maximum
     */
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test Tesla constructor for high invalid autonomy level.")
    public void TeslaConstructorInvalidAutonomyLevelHighTest() {
        new AutonomousVehicle(0, "Tesla", "Model S", "Red");
    }

    /**
     * Tests that GM constructor throws exception for autonomy level below minimum
     */
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test GM constructor for low invalid autonomy level.")
    public void GMTConstructorInvalidAutonomyLevelLowTest() {
        GMVehicle vehicle = createGMVehicle(0, "Prius", "Blue", "robotaxi");
    }

    /**
     * Tests that GM constructor throws exception for autonomy level above maximum
     */
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test GM constructor for high invalid autonomy level.")
    public void GMTConstructorInvalidAutonomyLevelHighTest() {
        GMVehicle vehicle = createGMVehicle(6, "Prius", "Blue", "robotaxi");
    }

    /**
     * Tests that Toyota constructor throws exception for autonomy level below minimum
     */
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test GM constructor for low invalid autonomy level.")
    public void ToyotaConstructorInvalidAutonomyLevelLowTest() {
        new AutonomousVehicle(0, "Toyota", "Cruise", "Silver");
    }

    /**
     * Tests that Toyota constructor throws exception for autonomy level above maximum
     */
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test Toyota constructor for high invalid autonomy level.")
    public void ToyotaConstructorInvalidAutonomyLevelHighTest() {
        new AutonomousVehicle(0, "Toyota", "Cruise", "Silver");
    }

    /**
     * Tests final direction calculation using char array input
     */
    @Test
    @DisplayName("Test final direction char")
    public void FinalDirectionCharArrayTest() {
        AutonomousVehicle vehicle = createVehicle(3, "Tesla", "Model S", "Red");
        char[] turns = {'L', 'L', 'R'};
        assertEquals('W', vehicle.finalDirection(turns));
        assertEquals('W', vehicle.getDirection());
    }

    /**
     * Tests final direction calculation using String array input
     */
    @Test
    @DisplayName("Test final direction String array")
    public void FinalDirectionStringArrayTest() {
        String[] turns = {"L", "L", "R"};
        AutonomousVehicle vehicle = createVehicle(3, "Tesla", "Model S", "Red");
        assertEquals('W', vehicle.finalDirection(turns));
        assertEquals('W', vehicle.getDirection());
    }

    /**
     * Tests that a full circle of turns returns to starting direction
     */
    @Test
    @DisplayName("Test final direction for a full circle direction")
    public void FinalDirectionFullCircleTest() {
        char[] turns = {'L', 'L', 'L', 'L'};
        AutonomousVehicle vehicle = createVehicle(3, "Tesla", "Model S", "Red");
        assertEquals('N', vehicle.finalDirection(turns));
    }

    /**
     * Tests that empty array of turns maintains starting direction
     */
    @Test
    @DisplayName("Test final direction with an empty array")
    public void FinalDirectionEmptyArrayTest() {
        AutonomousVehicle vehicle = createVehicle(3, "Tesla", "Model S", "Red");
        char[] turns = {};
        assertEquals('N', vehicle.finalDirection(turns));
    }

    /**
     * Tests multiple sequences of turns for correct final directions
     */
    @Test
    @DisplayName("Test final direction for multiple turns")
    public void FinalDirectionMultipleTurnsTest() {
        // Starting from NORTH (default direction)
        AutonomousVehicle vehicle = createVehicle(3, "Tesla", "Model S", "Red");

        // Test case 1: Two left turns (L, L)
        // NORTH -> LEFT -> WEST -> LEFT -> SOUTH
        char[] turns1 = {'L', 'L'};
        assertEquals('S', vehicle.finalDirection(turns1),
                "Two left turns from NORTH should result in SOUTH");

        // Test case 2: Three right turns (R, R, R)
        // NORTH -> RIGHT -> EAST -> RIGHT -> SOUTH -> RIGHT -> WEST
        char[] turns2 = {'R', 'R', 'R'};
        assertEquals('W', vehicle.finalDirection(turns2),
                "Three right turns from NORTH should result in WEST");
    }

    /**
     * Tests that GM constructor throws exception for invalid vehicle type
     */
    @Test(expected = IllegalArgumentException.class)
    @DisplayName("Test GM constructor with an invalid vehicle type parameter")
    public void GMTestConstructorInvalidVehicleType() {
        createGMVehicle(3, "Prius", "Blue", "invalidType");
    }

}