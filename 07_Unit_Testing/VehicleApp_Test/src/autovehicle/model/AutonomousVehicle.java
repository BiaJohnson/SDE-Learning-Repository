package autovehicle.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class representing an autonomous vehicle with common properties and behaviors.
 * This class serves as the parent for specific vehicle manufacturer implementations.
 *
 * <p>Features include:
 * <ul>
 *   <li>Efficient direction calculation using O(1) lookups</li>
 *   <li>Memory-optimized data structures</li>
 *   <li>Support for multiple direction command formats</li>
 * </ul>
 *
 * @author Shadman
 * @version 1.0
 */
public class AutonomousVehicle {
    // Constants for direction mapping to improve performance
    private static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char EAST = 'E';
    private static final char WEST = 'W';

    // Lookup map for direction transitions (more efficient than array traversal)
    private static final Map<Character, Map<Character, Character>> DIRECTION_MAP = new HashMap<>();

    static {
        // Initialize direction transition map
        Map<Character, Character> northMap = new HashMap<>();
        northMap.put('L', WEST);
        northMap.put('R', EAST);
        DIRECTION_MAP.put(NORTH, northMap);

        Map<Character, Character> eastMap = new HashMap<>();
        eastMap.put('L', NORTH);
        eastMap.put('R', SOUTH);
        DIRECTION_MAP.put(EAST, eastMap);

        Map<Character, Character> southMap = new HashMap<>();
        southMap.put('L', EAST);
        southMap.put('R', WEST);
        DIRECTION_MAP.put(SOUTH, southMap);

        Map<Character, Character> westMap = new HashMap<>();
        westMap.put('L', SOUTH);
        westMap.put('R', NORTH);
        DIRECTION_MAP.put(WEST, westMap);
    }

    // Using primitives where possible for better memory efficiency
    private final byte autonomyLevel; // 1 to 5
    private final String make;
    private final String model;
    private final String color;
    private char direction;
    /**
     * Constructs a new autonomous vehicle with the specified properties.
     *
     * @param autonomyLevel The level of autonomy (1-5) where 5 is fully autonomous
     * @param make The manufacturer of the vehicle
     * @param model The model name of the vehicle
     * @param color The color of the vehicle
     * @throws IllegalArgumentException if autonomy level is not between 1 and 5
     */
    public AutonomousVehicle(int autonomyLevel, String make, String model, String color) {
        if (autonomyLevel < 1 || autonomyLevel > 5) {
            throw new IllegalArgumentException("Autonomy level must be between 1 and 5");
        }
        this.autonomyLevel = (byte)autonomyLevel; // Cast to byte to save memory
        this.make = make;
        this.model = model;
        this.color = color;
        this.direction = NORTH;
    }

    /**
     * Gets the autonomy level of the vehicle.
     *
     * @return The autonomy level (1-5)
     */
    public int getAutonomyLevel() {
        return autonomyLevel;
    }
    /**
     * Gets the manufacturer of the vehicle.
     *
     * @return The manufacturer name
     */
    public String getMake() {
        return make;
    }
    /**
     * Gets the model name of the vehicle.
     *
     * @return The model name
     */
    public String getModel() {
        return model;
    }
    /**
     * Gets the color of the vehicle.
     *
     * @return The color
     */
    public String getColor() {
        return color;
    }
    /**
     * Gets the current direction of the vehicle.
     *
     * @return The direction as a character (N, S, E, or W)
     */
    public char getDirection() {
        return direction;
    }

    /**
     * Calculates the final direction after a series of turns.
     * Uses an efficient O(n) algorithm with constant space complexity.
     *
     * @param turns Array of turn commands ('L' for left, 'R' for right)
     * @return The final direction as a character (N, S, E, or W)
     */
    public char finalDirection(char[] turns) {
        char currentDir = NORTH;

        for (char turn : turns) {
            currentDir = DIRECTION_MAP.get(currentDir).get(turn);
        }

        this.direction = currentDir;
        return currentDir;
    }
    /**
     * Overloaded method for calculating final direction from string commands.
     *
     * @param turns Array of turn commands as strings ("L" for left, "R" for right)
     * @return The final direction as a character (N, S, E, or W)
     */
    public char finalDirection(String[] turns) {
        char[] charTurns = new char[turns.length];
        for (int i = 0; i < turns.length; i++) {
            charTurns[i] = turns[i].charAt(0);
        }
        return finalDirection(charTurns);
    }
    /**
     * Returns a string representation of the autonomous vehicle.
     *
     * @return A formatted string with vehicle details
     */
    @Override
    public String toString() {
        return String.format("%s: %s %s (Level %d), Color: %s, Direction: %c",
                getClass().getSimpleName(), make, model, autonomyLevel, color, direction);
    }


}
