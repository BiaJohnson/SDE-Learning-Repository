package com.NumberProcessorApp.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.NumberProcessorApp.model.ProcessingResult;

/**
 * View class that handles user interaction through the console
 */
public class ConsoleView {
    private final Scanner scanner;

    /**
     * Constructs a new ConsoleView with a Scanner for user input
     */
    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Gets input numbers from the user until they choose to stop
     *
     * @return Array of numbers entered by the user
     */
    public int[] getInputNumbers() {
        ArrayList<Integer> numbersList = new ArrayList<>();

        System.out.println("Enter numbers one by one. Enter any non-numeric input to stop.");

        while (true) {
            System.out.print("Enter a number (or any non-numeric input to finish): ");

            // Check if the next input is an integer
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                numbersList.add(number);
                System.out.println("Added: " + number);
            } else {
                // User entered non-numeric input, break the loop
                scanner.next(); // consume the non-numeric input
                break;
            }
        }

        // Convert ArrayList to array
        int[] numbers = new int[numbersList.size()];
        for (int i = 0; i < numbersList.size(); i++) {
            numbers[i] = numbersList.get(i);
        }

        System.out.println("\nProcessing " + numbers.length + " numbers...");
        return numbers;
    }


    /**
     * Displays the processing results to the console
     *
     * @param result The ProcessingResult to display
     */
    public void displayResults(ProcessingResult result) {
        // Display even numbers
        System.out.println("\nEven numbers in the order they were entered:");
        displayArray(result.getEvenNumbers());

        // Display sum of even numbers
        System.out.println("\nSum of even numbers: " + result.getEvenSum());

        // Display odd numbers in reverse order
        System.out.println("\nOdd numbers in the reverse order they were entered:");
        displayArray(result.getOddNumbersReversed());

        // Display sum of odd numbers
        System.out.println("\nSum of odd numbers: " + result.getOddSum());
    }

    /**
     * Helper method to display an array of integers
     *
     * @param array The array to display
     */
    private void displayArray(int[] array) {
        if (array.length == 0) {
            System.out.println("None");
            return;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Closes the scanner when the application is done
     */
    public void close() {
        scanner.close();
    }
}
