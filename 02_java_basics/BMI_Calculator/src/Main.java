/**
 The Main class is responsible for handling user input and calculating BMI
 based on the chosen system (Imperial or Metric).
 */
public class Main {
    /**
     The main method serves as the entry point of the program.
     It gathers user input, calculates BMI, and determines the BMI category.
     */
    public static void main(String[] args) {
        /** Stores the weight input by the user. */
        double weight;
        /** Stores the height input by the user. */
        double height;
        /** Stores the calculated Body Mass Index (BMI). */
        double bmi = 0;
        /** Stores the selected BMI measurement system (IMPERIAL/METRIC). */
        String bmiSystem;
        /** Stores the BMI category based on the calculated BMI value. */
        String bmiCategory;
        /** Instance of UserInput class for handling user input. */
        UserInput userInput = new UserInput();
        /** Instance of BMICalculator class for performing BMI calculations. */

        BMICalculator bmiCalculator = new BMICalculator();
        // Prompt the user to select the BMI measurement system.
        bmiSystem = userInput.obtainBMISystem();
        // Determine the BMI calculation based on the chosen system.
        switch (bmiSystem.toUpperCase()) {
            case "IMPERIAL":
                weight = userInput.obtainWeight(bmiSystem);
                height = userInput.obtainHeight(bmiSystem);
                bmi = bmiCalculator.calculateBmiImperial(weight, height);
                break;
            case "METRIC":
                weight = userInput.obtainWeight(bmiSystem);
                height = userInput.obtainHeight(bmiSystem);
                bmi = bmiCalculator.calculateBmiMetric(weight, height);
                break;
            case "":
                System.out.println("Please enter a valid BMI System as input.");
                return; // Exit early if no valid input is provided.
        }
        // Display the calculated BMI.
        System.out.println("Your BMI is: " + bmi);
        // Determine and display the BMI category.
        bmiCategory = bmiCalculator.getBMICategory(bmi);
        System.out.println("Your BMI category is: " + bmiCategory);
    }
}






