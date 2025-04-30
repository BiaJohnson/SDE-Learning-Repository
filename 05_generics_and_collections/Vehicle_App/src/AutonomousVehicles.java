/**
 * Abstract class representing an autonomous vehicle with basic properties and functionality
 */
abstract class AutonomousVehicle {
    protected int autonomyLevel; // Level of autonomy from 1 to 5
    protected String make;       // Vehicle manufacturer
    protected String model;      // Vehicle model name
    protected String color;      // Vehicle color
    protected String direction;  // Current direction vehicle is facing

    /**
     * Constructor to initialize an autonomous vehicle
     * @param autonomyLevel Level of autonomy (1-5)
     * @param make Vehicle manufacturer
     * @param model Vehicle model
     * @param color Vehicle color
     * @throws IllegalArgumentException if autonomy level is not between 1 and 5
     */
    public AutonomousVehicle(int autonomyLevel, String make, String model, String color) {
        if (autonomyLevel < 1 || autonomyLevel > 5) {
            throw new IllegalArgumentException("Invalid! Autonomy level must be between 1 and 5.");
        }
        this.autonomyLevel = autonomyLevel;
        this.make = make;
        this.model = model;
        this.color = color;
        this.direction = "N"; // Default direction is North
    }

    /**
     * Calculates final direction after a series of turns that the user enters
     * @param turns Array of turns where "R" = right turn and "L" = left turn
     */
    public void final_direction(String[] turns) {
        String[] directions = {"N", "E", "S", "W"}; // Compass directions in clockwise order
        int index = 0; // Start facing North - index 0

        // Process each turn and update direction index
        for (String turn : turns) {
            if (turn.equals("R")) {
                index = (index + 1) % 4; // Rotate clockwise
            } else if (turn.equals("L")) {
                index = (index - 1 + 4) % 4; // Rotate counter-clockwise
            }
        }
        this.direction = directions[index];
    }

    /**
     * Prints all vehicle details
     */
    void printVehicleDetails() {
        System.out.println("\n******* " + make + " Vehicle Details *******");
        System.out.println("- Make: " + make);
        System.out.println("- Model: " + model);
        System.out.println("- Color: " + color);
        System.out.println("- Autonomy Level: " + autonomyLevel);
        System.out.println("- Final Direction: " + direction);
    }
}