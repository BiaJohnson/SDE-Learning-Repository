import java.util.Scanner;
/**
 The UserInput class handles user input for selecting a BMI system,
 as well as obtaining weight and height values based on the chosen system.
 */
public class UserInput {
    /**
     Prompts the user to select a BMI measurement system (Imperial or Metric).
     *
     @return A string representing the chosen BMI system ("Imperial" or "Metric").
     If an invalid system is entered, an empty string is returned.
     */
    public String obtainBMISystem() {
        System.out.println("Welcome to the BMI calculator app!");
        System.out.print("Please select the preferred BMI calculation system (Imperial/Metric): ");
        Scanner input = new Scanner(System.in);
        String bmiSystem = input.next();
        // Validate user input
        if (!(bmiSystem.equalsIgnoreCase("Imperial") ||
                bmiSystem.equalsIgnoreCase("Metric"))) {
            return "";
        }
        return bmiSystem;
    }
    /**
     Prompts the user to enter their weight based on the selected BMI system.
     Ensures that the input is a valid numeric value.
     *
     @param bmiSystem The chosen BMI system ("Imperial" or "Metric").
     @return The weight value entered by the user.
     */
    public double obtainWeight(String bmiSystem) {
        double weight = 0;
        boolean isInvalidInput = true;
        while (isInvalidInput) {
            Scanner input = new Scanner(System.in);
            switch (bmiSystem.toUpperCase()) {
                case "IMPERIAL":
                    System.out.print("Enter weight in Pounds: ");
                    break;
                case "METRIC":
                    System.out.print("Enter weight in Kilos: ");
                    break;
                case "":
                    System.out.println("Please enter a valid BMI system as input.");
                    return 0;
            }
            // Validate user input
            if (input.hasNextDouble()) {
                weight = input.nextDouble();
                isInvalidInput = false;
            } else {
                System.out.println("Please enter a valid weight.");
            }
        }
        return weight;
    }
    /**
     Prompts the user to enter their height based on the selected BMI system.
     Ensures that the input is a valid numeric value.
     *
     @param bmiSystem The chosen BMI system ("Imperial" or "Metric").
     @return The height value entered by the user.
     */
    public double obtainHeight(String bmiSystem) {
        double height = 0;
        boolean isInvalidInput = true;
        while (isInvalidInput) {
            Scanner input = new Scanner(System.in);
            switch (bmiSystem.toUpperCase()) {          case "IMPERIAL":
                System.out.print("Enter height in inches: ");
                break;
                case "METRIC":
                    System.out.print("Enter height in meters: ");
                    break;
                case "":
                    System.out.println("Please enter a valid BMI system as input.");
                    return 0;
            }
            // Validate user input
            if (input.hasNextDouble()) {
                height = input.nextDouble();
                isInvalidInput = false;
            } else {
                System.out.println("Please enter a valid height.");
            }
        }
        return height;
    }
}
