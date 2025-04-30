/**
 * Represents a Tesla vehicle that extends the AutonomousVehicle class
 * Includes Tesla-specific features like Autopilot network
 */
class Tesla extends AutonomousVehicle {
    // The autonomous driving network used by Tesla vehicles
    private String network;

    /**
     * Constructs a new Tesla vehicle
     * @param autonomyLevel The level of autonomous driving capability
     * @param model The specific Tesla model
     * @param color The color of the vehicle
     */
    public Tesla(int autonomyLevel, String model, String color) {
        super(autonomyLevel, "Tesla", model, color); // Call parent constructor with autonomy level, manufacturer (Tesla), model and color
        this.network = "Autopilot";
    }

    /**
     * Prints the details of the Tesla vehicle
     * Overrides the parent class method to include network information
     */
    @Override
    public void printVehicleDetails() {
        super.printVehicleDetails(); // Call parent class method to print basic vehicle details
        System.out.println("- Network: " + network + "\n");
    }
}