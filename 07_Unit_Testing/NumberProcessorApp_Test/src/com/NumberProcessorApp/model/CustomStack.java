package com.NumberProcessorApp.model;

import java.util.Arrays;

/**
 * Optimized implementation of a Stack data structure using an array
 * with efficient growth strategy for maximum performance
 */
public class CustomStack {
    private int[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final float GROWTH_FACTOR = 1.5f;

    /**
     * Constructs a new empty stack with optimal initial capacity
     */
    public CustomStack() {
        elements = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Pushes a new element onto the top of the stack
     *
     * @param value The value to be pushed onto the stack
     */
    public void push(int value) {
        ensureCapacity(size + 1);
        elements[size++] = value;
    }

    /**
     * Ensures that the internal array has enough capacity for the specified
     * minimum size. If not, it grows the array using an optimal growth factor.
     *
     * @param minCapacity The minimum capacity needed
     */
    private void ensureCapacity(int minCapacity) {
        // If current array size is sufficient, return early
        if (minCapacity <= elements.length) {
            return;
        }

        // Calculate new capacity using growth factor
        int newCapacity = Math.max(minCapacity, (int)(elements.length * GROWTH_FACTOR));

        // Create new array and copy elements
        elements = Arrays.copyOf(elements, newCapacity);
    }

    /**
     * Returns all elements in the stack in reverse order (LIFO)
     *
     * @return Array containing all elements in reverse order
     */
    public int[] getAllElementsReversed() {
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[i] = elements[size - 1 - i];
        }
        return reversed;
    }

    /**
     * Returns the current number of elements in the stack
     *
     * @return The size of the stack
     */
    public int getSize() {
        return size;
    }
}
