// Import required date/time utilities for handling day of week operations
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Toyota vehicle class that extends the AutonomousVehicle base class.
 * Represents a Toyota autonomous vehicle that can be used for Lyft service on weekends.
 */
class Toyota extends AutonomousVehicle {
    private boolean isLyft; // Flag to track if vehicle is currently being used for Lyft service

    /**
     * Constructor to initialize a new Toyota autonomous vehicle
     * @param autonomyLevel The level of autonomy (1-5) of the vehicle
     * @param model The specific Toyota model name
     * @param color The color of the vehicle
     */
    public Toyota(int autonomyLevel, String model, String color) {
        super(autonomyLevel, "Toyota", model, color); // Call parent constructor with autonomy level, manufacturer (Toyota), model and color
        this.isLyft = isLyft(); // Call method to determine if is the weekend to determine whether it is Lyft or not.
    }

    /**
     * Determines if the vehicle is currently being used for Lyft service
     * Vehicle is only used for Lyft service on Saturdays and Sundays
     * @return true if the current day is a weekend, false otherwise
     */
    private boolean isLyft(){
        // Get the current day of week from system clock
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        // Check if today is Saturday or Sunday
        isLyft = today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY;
        return isLyft;
    }

    /**
     * Prints detailed information about the vehicle
     * Overrides the base class method to include Lyft service status
     */
    @Override
    public void printVehicleDetails() {
        super.printVehicleDetails(); // Print basic vehicle details from parent class
        System.out.println("- Is Lyft Vehicle: " + isLyft + "\n");
    }
}