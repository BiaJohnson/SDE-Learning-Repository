package com.NumberProcessorApp.model;

import java.util.Arrays;

/**
 * Optimized implementation of a Queue data structure using an array
 * with efficient growth strategy for maximum performance
 */
public class CustomQueue {
    private int[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final float GROWTH_FACTOR = 1.5f;

    /**
     * Constructs a new empty queue with optimal initial capacity
     */
    public CustomQueue() {
        elements = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds a new element to the end of the queue
     *
     * @param value The value to be added to the queue
     */
    public void enqueue(int value) {
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
     * Returns all elements in the queue in FIFO order
     *
     * @return Array containing all elements in the queue
     */
    public int[] getAllElements() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Returns the current number of elements in the queue
     *
     * @return The size of the queue
     */
    public int getSize() {
        return size;
    }
}
