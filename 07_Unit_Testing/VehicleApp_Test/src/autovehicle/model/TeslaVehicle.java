package autovehicle.model;
/**
 * Tesla-specific implementation of an autonomous vehicle.
 * Includes Tesla's proprietary network "Autopilot" for holistic vehicle data management.
 *
 * @author Shadman
 * @version 1.0
 */
public class TeslaVehicle extends AutonomousVehicle {
    private static final String network = "Autopilot";

    /**
     * Constructs a new Tesla autonomous vehicle with the specified properties.
     * Automatically sets the make to "Tesla".
     *
     * @param autonomyLevel The level of autonomy (1-5) where 5 is fully autonomous
     * @param model The model name of the Tesla vehicle (e.g., "Model S", "Model 3")
     * @param color The color of the vehicle
     */
    public TeslaVehicle(int autonomyLevel, String model, String color) {
        super(autonomyLevel, "Tesla", model, color);
    }

    /**
     * Gets the name of Tesla's proprietary network.
     *
     * @return The network name ("Autopilot")
     */
    public String getNetwork() {
        return network;
    }
    /**
     * Returns a string representation of the Tesla vehicle including all properties.
     *
     * @return A string containing all Tesla vehicle properties
     */
    @Override
    public String toString() {
        return super.toString() + ", Network: " + network;
    }
}
