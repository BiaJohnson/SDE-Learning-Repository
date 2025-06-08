package com.NumberProcessorApp.model;

/**
 * Model class to store the results of number processing
 */
public class ProcessingResult {
    private final int[] evenNumbers;
    private final int evenSum;
    private final int[] oddNumbersReversed;
    private final int oddSum;

    /**
     * Constructs a new ProcessingResult with the given data
     *
     * @param evenNumbers Even numbers in original order
     * @param evenSum Sum of even numbers
     * @param oddNumbersReversed Odd numbers in reverse order
     * @param oddSum Sum of odd numbers
     */
    public ProcessingResult(int[] evenNumbers, int evenSum, int[] oddNumbersReversed, int oddSum) {
        this.evenNumbers = evenNumbers;
        this.evenSum = evenSum;
        this.oddNumbersReversed = oddNumbersReversed;
        this.oddSum = oddSum;
    }

    /**
     * @return Array of even numbers in original order
     */
    public int[] getEvenNumbers() {
        return evenNumbers;
    }

    /**
     * @return Sum of all even numbers
     */
    public int getEvenSum() {
        return evenSum;
    }

    /**
     * @return Array of odd numbers in reverse order
     */
    public int[] getOddNumbersReversed() {
        return oddNumbersReversed;
    }

    /**
     * @return Sum of all odd numbers
     */
    public int getOddSum() {
        return oddSum;
    }
}
