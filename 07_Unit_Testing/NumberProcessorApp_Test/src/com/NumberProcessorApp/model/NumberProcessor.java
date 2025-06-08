package com.NumberProcessorApp.model;

/**
 * Controller class that processes numbers and separates them into even and odd
 */
public class NumberProcessor {

    /**
     * Processes an array of numbers, separating them into even and odd,
     * calculating their sums, and returning the results
     *
     * @param numbers Array of numbers to process
     * @return ProcessingResult containing even numbers, odd numbers, and their sums
     */
    public ProcessingResult processNumbers(int[] numbers) {
        CustomQueue evenQueue = new CustomQueue();
        CustomStack oddStack = new CustomStack();

        int evenSum = 0;
        int oddSum = 0;

        // Process each number
        for (int num : numbers) {
            if (num % 2 == 0) {
                // Even number (including 0)
                evenQueue.enqueue(num);
                evenSum += num;
            } else {
                // Odd number
                oddStack.push(num);
                oddSum += num;
            }
        }

        return new ProcessingResult(
                evenQueue.getAllElements(),
                evenSum,
                oddStack.getAllElementsReversed(),
                oddSum
        );
    }
}
