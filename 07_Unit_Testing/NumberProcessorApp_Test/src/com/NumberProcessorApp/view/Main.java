package com.NumberProcessorApp.view;

import com.NumberProcessorApp.model.NumberProcessor;
import com.NumberProcessorApp.model.ProcessingResult;

/*
 * @author: Shadman Rabbi
 * Date: 04
 * Project Name: Number Processor App
 * Main application class that coordinates the MVC components
 */
public class Main {
    public static void main(String[] args) {
        // Create MVC components
        ConsoleView view = new ConsoleView();
        NumberProcessor processor = new NumberProcessor();

        try {
            // Get input numbers from user
            int[] numbers = view.getInputNumbers();

            // Process numbers and get results
            ProcessingResult result = processor.processNumbers(numbers);

            // Display results
            view.displayResults(result);
        } finally {
            // Ensure resources are properly closed
            view.close();
        }
    }
}
