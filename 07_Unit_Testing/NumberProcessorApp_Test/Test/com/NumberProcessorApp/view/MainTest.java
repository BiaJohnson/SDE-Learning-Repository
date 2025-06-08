package com.NumberProcessorApp.view;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * Test class for the Main class which processes number input and performs calculations
 * on even and odd numbers.
 */
public class MainTest {
    // Captures the output stream for testing console output
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    // Stores the original standard output stream
    private final PrintStream standardOut = System.out;
    // Stores the original standard input stream
    private final ByteArrayInputStream standardIn = null;

    /**
     * Sets up the test environment by redirecting System.out to a capturable stream
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Restores the original System.out and System.in after each test
     */
    @After
    public void tearDown() {
        System.setOut(standardOut);
        if (standardIn != null) {
            System.setIn(System.in);
        }
    }

    /**
     * Tests the main method with valid even numbers as input
     * Verifies correct processing of even numbers and their sum
     */
    @Test
    public void testMain_WithValidInput() {
        // Arrange
        String input = "2\n4\n6\nx\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Act
        Main.main(new String[]{});

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Enter numbers one by one"));
        assertTrue(output.contains("Added: 2"));
        assertTrue(output.contains("Added: 4"));
        assertTrue(output.contains("Added: 6"));
        assertTrue(output.contains("Even numbers in the order they were entered:"));
        assertTrue(output.contains("2, 4, 6"));
        assertTrue(output.contains("Sum of even numbers: 12"));
    }

    /**
     * Tests the main method with empty input (immediate termination)
     * Verifies correct handling of empty input and zero sums
     */
    @Test
    public void testMain_WithEmptyInput() {
        // Arrange
        String input = "x\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Act
        Main.main(new String[]{});

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Processing 0 numbers"));
        assertTrue(output.contains("None")); // For empty arrays
        assertTrue(output.contains("Sum of even numbers: 0"));
        assertTrue(output.contains("Sum of odd numbers: 0"));
    }

    /**
     * Tests the main method with a mix of even and odd numbers
     * Verifies correct processing of both number types and their sums
     */
    @Test
    public void testMain_WithMixedNumbers() {
        // Arrange
        String input = "1\n2\n3\n4\n5\nx\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Act
        Main.main(new String[]{});

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Added: 1"));
        assertTrue(output.contains("Added: 2"));
        assertTrue(output.contains("Added: 3"));
        assertTrue(output.contains("Added: 4"));
        assertTrue(output.contains("Added: 5"));
        assertTrue(output.contains("Even numbers in the order they were entered:"));
        assertTrue(output.contains("2, 4"));
        assertTrue(output.contains("Sum of even numbers: 6"));
        assertTrue(output.contains("Odd numbers in the reverse order they were entered:"));
        assertTrue(output.contains("5, 3, 1"));
        assertTrue(output.contains("Sum of odd numbers: 9"));
    }

    /**
     * Tests the main method with invalid input (non-numeric values)
     * Verifies graceful handling of invalid input and continued processing
     */
    @Test
    public void testMain_WithInvalidInput() {
        // Arrange
        String input = "1\nabc\n2\nx\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Act
        Main.main(new String[]{});

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Added: 1"));
        assertTrue(output.contains("Processing 1 numbers"));
        assertTrue(output.contains("Odd numbers in the reverse order they were entered:"));
        assertTrue(output.contains("1"));
        assertTrue(output.contains("Sum of odd numbers: 1"));
    }

    /**
     * Tests the main method with negative numbers as input
     * Verifies correct processing of negative even and odd numbers
     */
    @Test
    public void testMain_WithNegativeNumbers() {
        // Arrange
        String input = "-1\n-2\n-3\nx\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Act
        Main.main(new String[]{});

        // Assert
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Added: -1"));
        assertTrue(output.contains("Added: -2"));
        assertTrue(output.contains("Added: -3"));
        assertTrue(output.contains("Even numbers in the order they were entered:"));
        assertTrue(output.contains("-2"));
        assertTrue(output.contains("Sum of even numbers: -2"));
        assertTrue(output.contains("Odd numbers in the reverse order they were entered:"));
        assertTrue(output.contains("-3, -1"));
        assertTrue(output.contains("Sum of odd numbers: -4"));
    }
}