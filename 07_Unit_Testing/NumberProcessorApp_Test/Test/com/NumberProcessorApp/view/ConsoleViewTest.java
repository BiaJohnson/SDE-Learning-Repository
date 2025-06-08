package com.NumberProcessorApp.view;

import com.NumberProcessorApp.model.ProcessingResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Test class for ConsoleView functionality
 * Tests input handling and result display methods
 */
public class ConsoleViewTest {
    // Captures console output for verification
    private ConsoleView consoleView;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    /**
     * Set up test environment before each test
     * Redirects System.out to capture console output
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Clean up after each test
     * Restores original System.out
     */
    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    /**
     * Tests input of multiple valid numbers
     * Verifies correct array creation and output messages
     */
    @Test
    public void testGetInputNumbers_MultipleValidInputs() {

        String input = "1\n2\n3\nx\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        consoleView = new ConsoleView();

        int[] result = consoleView.getInputNumbers();

        assertArrayEquals(new int[]{1, 2, 3}, result);
        assertTrue(outputStreamCaptor.toString().contains("Added: 1"));
        assertTrue(outputStreamCaptor.toString().contains("Added: 2"));
        assertTrue(outputStreamCaptor.toString().contains("Added: 3"));
        assertTrue(outputStreamCaptor.toString().contains("Processing 3 numbers"));
    }

    /**
     * Tests handling of empty input
     * Verifies empty array creation and appropriate message
     */
    @Test
    public void testGetInputNumbers_EmptyInput() {

        String input = "x\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        consoleView = new ConsoleView();

        int[] result = consoleView.getInputNumbers();

        assertEquals(0, result.length);
        assertTrue(outputStreamCaptor.toString().contains("Processing 0 numbers"));
    }

    /**
     * Tests display of results with both even and odd numbers
     * Verifies correct output formatting and sums
     */
    @Test
    public void testDisplayResults_WithMixedNumbers() {

        consoleView = new ConsoleView();
        int[] evenNums = {2, 4, 6};
        int[] oddNums = {5, 3, 1};
        ProcessingResult result = new ProcessingResult(evenNums, 12, oddNums, 9);

        consoleView.displayResults(result);
        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("Even numbers in the order they were entered:"));
        assertTrue(output.contains("2, 4, 6"));
        assertTrue(output.contains("Sum of even numbers: 12"));
        assertTrue(output.contains("Odd numbers in the reverse order they were entered:"));
        assertTrue(output.contains("5, 3, 1"));
        assertTrue(output.contains("Sum of odd numbers: 9"));
    }

    /**
     * Tests display of results with no numbers
     * Verifies correct handling of empty arrays
     */
    @Test
    public void testDisplayResults_WithEmptyArrays() {

        consoleView = new ConsoleView();
        ProcessingResult result = new ProcessingResult(new int[]{}, 0, new int[]{}, 0);

        consoleView.displayResults(result);
        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("Even numbers in the order they were entered:"));
        assertTrue(output.contains("None"));
        assertTrue(output.contains("Sum of even numbers: 0"));
        assertTrue(output.contains("Odd numbers in the reverse order they were entered:"));
        assertTrue(output.contains("None"));
        assertTrue(output.contains("Sum of odd numbers: 0"));
    }

    /**
     * Tests display of results with only even numbers
     * Verifies correct handling when odd number array is empty
     */
    @Test
    public void testDisplayResults_WithOnlyEvenNumbers() {

        consoleView = new ConsoleView();
        int[] evenNums = {2, 4, 6};
        ProcessingResult result = new ProcessingResult(evenNums, 12, new int[]{}, 0);

        consoleView.displayResults(result);
        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("Even numbers in the order they were entered:"));
        assertTrue(output.contains("2, 4, 6"));
        assertTrue(output.contains("Sum of even numbers: 12"));
        assertTrue(output.contains("Odd numbers in the reverse order they were entered:"));
        assertTrue(output.contains("None"));
        assertTrue(output.contains("Sum of odd numbers: 0"));
    }

    /**
     * Tests display of results with only odd numbers
     * Verifies correct handling when even number array is empty
     */
    @Test
    public void testDisplayResults_WithOnlyOddNumbers() {

        consoleView = new ConsoleView();
        int[] oddNums = {5, 3, 1};
        ProcessingResult result = new ProcessingResult(new int[]{}, 0, oddNums, 9);

        consoleView.displayResults(result);
        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("Even numbers in the order they were entered:"));
        assertTrue(output.contains("None"));
        assertTrue(output.contains("Sum of even numbers: 0"));
        assertTrue(output.contains("Odd numbers in the reverse order they were entered:"));
        assertTrue(output.contains("5, 3, 1"));
        assertTrue(output.contains("Sum of odd numbers: 9"));
    }

    /**
     * Tests input handling of negative numbers
     * Verifies correct array creation and output messages
     */
    @Test
    public void testGetInputNumbers_WithNegativeNumbers() {

        String input = "-1\n-2\n-3\nx\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        consoleView = new ConsoleView();

        int[] result = consoleView.getInputNumbers();

        assertArrayEquals(new int[]{-1, -2, -3}, result);
        assertTrue(outputStreamCaptor.toString().contains("Added: -1"));
        assertTrue(outputStreamCaptor.toString().contains("Added: -2"));
        assertTrue(outputStreamCaptor.toString().contains("Added: -3"));
    }

    /**
     * Tests handling of mixed valid and invalid input
     * Verifies that processing stops at invalid input
     */
    @Test
    public void testGetInputNumbers_WithMixedValidAndInvalidInput() {

        String input = "1\nabc\n2\n3\nx\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        consoleView = new ConsoleView();

        int[] result = consoleView.getInputNumbers();


        assertArrayEquals(new int[]{1}, result);
        assertTrue(outputStreamCaptor.toString().contains("Added: 1"));
    }
}