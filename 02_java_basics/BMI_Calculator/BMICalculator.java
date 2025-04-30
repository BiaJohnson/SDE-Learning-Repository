/**
 The BMICalculator class provides methods to calculate Body Mass Index (BMI)
 using both Imperial and Metric measurement systems.
 */
public class BMICalculator {
    /** Weight in pounds (used for Imperial system). */
    double weightInPounds;
    /** Height in inches (used for Imperial system). */
    double heightInInches;
    /** Weight in kilograms (used for Metric system). */
    double weightInKilos;
    /** Height in meters (used for Metric system). */
    double heightInMeters;
    /**
     Default constructor for BMICalculator.
     */
    public BMICalculator() {
    }
    /**
     Calculates BMI using the Imperial system.
     *
     @param weightInPounds The weight of the individual in pounds.
     @param heightInInches The height of the individual in inches.
     @return The calculated BMI value.
     */
    public double calculateBmiImperial(double weightInPounds, double heightInInches) {
        return weightInPounds / (heightInInches * heightInInches) * 703;
    }
    /**
     Calculates BMI using the Metric system.
     *
     @param weightInKilos The weight of the individual in kilograms.
     @param heightInMeters The height of the individual in meters.
     @return The calculated BMI value.
     */
    public double calculateBmiMetric(double weightInKilos, double heightInMeters) {
        this.weightInKilos = weightInKilos;
        this.heightInMeters = heightInMeters;
        return weightInKilos / (heightInMeters * heightInMeters);
    }
    /**
     Determines the BMI category based on the BMI value.
     *
     @param bmi The calculated BMI value.
     @return A string representing the BMI category.
     */
    public String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}