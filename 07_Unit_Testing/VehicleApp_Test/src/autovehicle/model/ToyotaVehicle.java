package autovehicle.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Toyota-specific implementation of an autonomous vehicle.
 * Includes functionality to determine if the vehicle is a Lyft vehicle based on the day of the week.
 *
 * @author Shadman
 * @version 1.0
 */
public class ToyotaVehicle extends AutonomousVehicle {
    private final boolean isLyft;
    /**
     * Constructs a new Toyota autonomous vehicle with the specified properties.
     * Automatically sets the make to "Toyota" and determines Lyft status based on current day.
     *
     * @param autonomyLevel The level of autonomy (1-5) where 5 is fully autonomous
     * @param model The model name of the Toyota vehicle
     * @param color The color of the vehicle
     */
    public ToyotaVehicle(int autonomyLevel, String model, String color) {
        super(autonomyLevel, "Toyota", model, color);
        // Calculate isLyft once during construction
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        this.isLyft = today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY;
    }

    /**
     * Determines if the vehicle is currently operating as a Lyft vehicle.
     * Toyota vehicles operate as Lyft vehicles on weekends (Saturday and Sunday).
     *
     * @return true if the vehicle is a Lyft vehicle, false otherwise
     */
    public boolean isLyft() {
        return isLyft;
    }
    /**
     * Returns a string representation of the Toyota vehicle including all properties.
     *
     * @return A string containing all Toyota vehicle properties including Lyft status
     */
    @Override
    public String toString() {
        return super.toString() + ", Lyft: " + (isLyft ? "Yes" : "No");
    }
}
