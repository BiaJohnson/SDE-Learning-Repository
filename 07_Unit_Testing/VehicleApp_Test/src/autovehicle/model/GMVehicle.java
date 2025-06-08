package autovehicle.model;

import java.util.Set;

/**
 * GM-specific implementation of an autonomous vehicle.
 * Includes vehicle type validation for GM's specific autonomous vehicle categories.
 *
 * @author Shadman
 * @version 1.0
 */
public class GMVehicle extends AutonomousVehicle {
    // Using Set for O(1) lookup performance
    private static final Set<String> VALID_TYPES = Set.of("pod", "robotaxi", "car");

    private final String vehicleType;
    /**
     * Constructs a new GM autonomous vehicle with the specified properties.
     * Automatically sets the make to "GM" and validates the vehicle type.
     *
     * @param autonomyLevel The level of autonomy (1-5) where 5 is fully autonomous
     * @param model The model name of the GM vehicle
     * @param color The color of the vehicle
     * @param vehicleType The type of vehicle (must be one of: "pod", "robotaxi", "car")
     * @throws IllegalArgumentException if the vehicle type is invalid
     */
    public GMVehicle(int autonomyLevel, String model, String color, String vehicleType) {
        super(autonomyLevel, "GM", model, color);

        String normalizedType = vehicleType.toLowerCase();
        if (!VALID_TYPES.contains(normalizedType)) {
            throw new IllegalArgumentException("Invalid vehicle type. Must be one of: " + VALID_TYPES);
        }
        this.vehicleType = normalizedType;
    }
    /**
     * Gets the type of the GM vehicle.
     *
     * @return The vehicle type (one of: "pod", "robotaxi", "car")
     */
    public String getVehicleType() {
        return vehicleType;
    }
    /**
     * Returns a string representation of the GM vehicle including all properties.
     *
     * @return A string containing all GM vehicle properties including vehicle type
     */
    @Override
    public String toString() {
        return super.toString() + ", Type: " + vehicleType;
    }
}
