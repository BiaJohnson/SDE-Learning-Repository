package com.NumberProcessorApp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for NumberProcessor functionality.
 * Tests various scenarios of number processing including even/odd number handling,
 * custom queue and stack operations, and large input processing.
 */
public class NumberProcessorTest {

    private NumberProcessor processor;

    /**
     * Sets up the test environment before each test case.
     * Initializes a new NumberProcessor instance.
     */
    @Before
    public void setUp() {
        processor = new NumberProcessor();
    }

    /**
     * Tests processing of an array containing only even numbers.
     * Verifies that even numbers are stored correctly and odd number arrays are empty.
     */
    @Test
    public void testProcessingResult_WhenOnlyEvenNumbers() {
        // Arrange - Create input array with only even numbers
        int[] input = {2, 4, 6, 8, 0};

        // Act - Process the numbers
        ProcessingResult result = processor.processNumbers(input);

        // Assert - Verify even numbers are stored and processed correctly
        assertArrayEquals("ProcessingResult should store even numbers in original order",
                new int[]{2, 4, 6, 8, 0}, result.getEvenNumbers());
        assertEquals("ProcessingResult should calculate correct even sum",
                20, result.getEvenSum());
        assertArrayEquals("ProcessingResult should have empty odd numbers array",
                new int[]{}, result.getOddNumbersReversed());
        assertEquals("ProcessingResult should have zero odd sum",
                0, result.getOddSum());
    }

    /**
     * Tests processing of an array containing only odd numbers.
     * Verifies that odd numbers are stored in reverse order and even number arrays are empty.
     */
    @Test
    public void testProcessingResult_WhenOnlyOddNumbers() {
        // Arrange - Create input array with only odd numbers
        int[] input = {1, 3, 5, 7, 9};

        // Act - Process the numbers
        ProcessingResult result = processor.processNumbers(input);

        // Assert - Verify odd numbers are stored and processed correctly
        assertArrayEquals("ProcessingResult should have empty even numbers array",
                new int[]{}, result.getEvenNumbers());
        assertEquals("ProcessingResult should have zero even sum",
                0, result.getEvenSum());
        assertArrayEquals("ProcessingResult should store odd numbers in reverse order",
                new int[]{9, 7, 5, 3, 1}, result.getOddNumbersReversed());
        assertEquals("ProcessingResult should calculate correct odd sum",
                25, result.getOddSum());
    }

    /**
     * Tests processing of an array containing both even and odd numbers.
     * Verifies correct separation and processing of even and odd numbers.
     */
    @Test
    public void testProcessingResult_WhenMixedNumbers() {
        // Arrange - Create input array with mixed numbers
        int[] input = {1, 2, 3, 4, 5};

        // Act - Process the numbers
        ProcessingResult result = processor.processNumbers(input);

        // Assert - Verify both even and odd numbers are processed correctly
        assertArrayEquals("ProcessingResult should store even numbers correctly",
                new int[]{2, 4}, result.getEvenNumbers());
        assertEquals("ProcessingResult should calculate correct even sum",
                6, result.getEvenSum());
        assertArrayEquals("ProcessingResult should store odd numbers in reverse order",
                new int[]{5, 3, 1}, result.getOddNumbersReversed());
        assertEquals("ProcessingResult should calculate correct odd sum",
                9, result.getOddSum());
    }

    /**
     * Tests processing of an empty array.
     * Verifies that all result arrays are empty and sums are zero.
     */
    @Test
    public void testProcessingResult_WhenEmptyArray() {
        // Arrange - Create empty input array
        int[] input = {};

        // Act - Process the empty array
        ProcessingResult result = processor.processNumbers(input);

        // Assert - Verify empty results
        assertArrayEquals("ProcessingResult should have empty even numbers array",
                new int[]{}, result.getEvenNumbers());
        assertEquals("ProcessingResult should have zero even sum",
                0, result.getEvenSum());
        assertArrayEquals("ProcessingResult should have empty odd numbers array",
                new int[]{}, result.getOddNumbersReversed());
        assertEquals("ProcessingResult should have zero odd sum",
                0, result.getOddSum());
    }

    /**
     * Tests the capacity expansion of CustomQueue implementation.
     * Verifies that the queue properly handles growth and maintains element order.
     */
    @Test
    public void testEnsureCapacity_WithCustomQueue() {
        // Arrange - Initialize queue
        CustomQueue queue = new CustomQueue();
        int initialSize = queue.getSize();

        // Act - Add elements to trigger capacity increase
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        // Assert - Verify queue size and elements
        assertTrue("Queue size should have increased", queue.getSize() > initialSize);

        // Verify all elements are present in correct order
        int[] allElements = queue.getAllElements();
        assertEquals("Queue should contain 20 elements", 20, allElements.length);
        for (int i = 0; i < 20; i++) {
            assertEquals("Element at index " + i + " should be " + i, i, allElements[i]);
        }
    }

    /**
     * Tests the capacity expansion of CustomStack implementation.
     * Verifies that the stack properly handles growth and maintains LIFO order.
     */
    @Test
    public void testEnsureCapacity_WithCustomStack() {
        // Arrange - Initialize stack
        CustomStack stack = new CustomStack();
        int initialSize = stack.getSize();

        // Act - Add elements to trigger capacity increase
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        // Assert - Verify stack size and elements
        assertTrue("Stack size should have increased", stack.getSize() > initialSize);

        // Verify all elements are present in reverse order
        int[] allElements = stack.getAllElementsReversed();
        assertEquals("Stack should contain 20 elements", 20, allElements.length);
        for (int i = 0; i < 20; i++) {
            assertEquals("Element at index " + i + " should be " + (19 - i), 19 - i, allElements[i]);
        }
    }

    /**
     * Tests the size tracking functionality of CustomQueue through multiple operations.
     * Verifies that the size is correctly updated after various queue operations.
     */
    @Test
    public void testGetSize_WithMultipleOperations() {
        // Arrange - Initialize queue
        CustomQueue queue = new CustomQueue();

        // Act & Assert - Test size after various operations
        assertEquals("Initial size should be 0", 0, queue.getSize());

        queue.enqueue(1);
        assertEquals("Size after one enqueue should be 1", 1, queue.getSize());

        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals("Size after three enqueues should be 3", 3, queue.getSize());

        // Test size after multiple enqueue operations
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals("Size after adding 10 more elements should be 13", 13, queue.getSize());
    }

    /**
     * Tests processing of a large input array.
     * Verifies correct handling of large datasets and proper separation of even/odd numbers.
     */
    @Test
    public void testProcessingResult_WithLargeInput() {
        // Arrange - Create large input array
        int[] largeInput = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeInput[i] = i;
        }

        // Act - Process large input
        ProcessingResult result = processor.processNumbers(largeInput);

        // Assert - Verify correct processing of large dataset
        assertEquals("Even numbers count should be 500",
                500,
                result.getEvenNumbers().length);

        assertEquals("Odd numbers count should be 500",
                500,
                result.getOddNumbersReversed().length);

        assertEquals("Last even number should be 998",
                998,
                result.getEvenNumbers()[499]);

        assertEquals("First odd number (reversed) should be 999",
                999,
                result.getOddNumbersReversed()[0]);
    }
}
