import java.util.Arrays;
import java.util.List;

/**
 * Represents a GM autonomous vehicle that extends the base AutonomousVehicle class.
 * Adds vehicle type functionality specific to GM vehicles.
 */
class GM extends AutonomousVehicle {
    private String vehicleType;  // The type of GM vehicle - pod, robotaxi, or car

    // List of valid vehicle types that can be assigned: pod, robotaxi, or car
    private static final List<String> validVehicleTypes = Arrays.asList("pod", "robotaxi", "car");

    /**
     * Constructs a new GM vehicle with the specified parameters.
     * @param autonomyLevel The level of autonomy (0-5)
     * @param model The model name of the vehicle
     * @param color The color of the vehicle
     * @param vehicleType The type of vehicle - must be pod, robotaxi, or car
     */
    public GM(int autonomyLevel, String model, String color, String vehicleType) {
        super(autonomyLevel, "GM", model, color); // Call parent constructor with autonomy level, manufacturer (GM), model and color
        setVehicleType(vehicleType); // Set the vehicle type after validating it is a valid type - pod, robotaxi, or car
    }

    /**
     * Sets the vehicle type after validating it is an allowed type.
     * @param type The type to set
     * @throws IllegalArgumentException if the type is not valid
     */
    public void setVehicleType(String type) {
        if (!getValidVehicleType(type)) {
            throw new IllegalArgumentException("Invalid vehicle type. Must be pod, robotaxi, or car");
        }
        this.vehicleType = type;
    }

    /**
     * Validates if a given vehicle type is allowed.
     * @param type The type to validate
     * @return true if the type is valid, false otherwise
     */
    private boolean getValidVehicleType(String type) {
        return validVehicleTypes.contains(type.toLowerCase());
    }

    /**
     * Prints the vehicle details including the vehicle type.
     * Overrides the parent class printVehicleDetails method.
     */
    @Override
    public void printVehicleDetails() {
        super.printVehicleDetails(); // Print basic vehicle details from parent class
        System.out.println("- Vehicle Type: " + vehicleType + "\n");
    }
}