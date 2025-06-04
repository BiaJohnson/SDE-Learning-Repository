import java.util.Arrays;

/**
 * Implementation of the Bubble Sort algorithm with two different variations
 */
public class BubbleSort {

    /**
     * Basic implementation of bubble sort algorithm
     * Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order
     *
     * @param numbers Array to be sorted
     */
    public void sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                // Compare adjacent elements and swap if first is greater than second
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Improved implementation of bubble sort that stops early if array becomes sorted
     * Also keeps track of last unsorted element to reduce comparisons
     *
     * @param numbers Array to be sorted
     */
    public void sortImprovement2(int[] numbers) {
        boolean swapped;  // Flag to track if any swaps occurred in pass
        int lastUnsorted = numbers.length - 1;  // Index of last unsorted element

        do {
            swapped = false;
            // Iterate through unsorted portion of array
            for (int i = 0; i < lastUnsorted; i++) {
                // Compare adjacent elements and swap if first is greater than second
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i, i + 1);
                    swapped = true;
                }
            }
            lastUnsorted--;  // Reduce size of unsorted portion
        } while (swapped);  // Continue until no swaps needed
    }

    /**
     * Helper method to swap two elements in an array
     *
     * @param arr Array containing elements to swap
     * @param i Index of first element
     * @param j Index of second element
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Main method to demonstrate both sorting implementations
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        // Create and sort same array using both implementations
        int[] numbers = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0};
        int[] numbers2 = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0};
        bubbleSort.sort(numbers);
        bubbleSort.sortImprovement2(numbers2);

        // Print sorted arrays
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbers2));
    }
}