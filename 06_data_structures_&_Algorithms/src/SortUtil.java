import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Utility class providing various sorting algorithms for Book collections.
 */
public class SortUtil {
    /**
     * Sorts a list of books using the bubble sort algorithm.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param books List of books to be sorted
     * @param comparator Comparator to determine the ordering of books
     */
    public static void bubbleSort(List<Book> books, Comparator<Book> comparator) {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (comparator.compare(books.get(j), books.get(j + 1)) > 0) {
                    Collections.swap(books, j, j + 1);
                }
            }
        }
    }
    /**
     * Sorts a list of books using the insertion sort algorithm.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param books List of books to be sorted
     * @param comparator Comparator to determine the ordering of books
     */
    public static void insertionSort(List<Book> books, Comparator<Book> comparator) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            // Move elements that are greater than key to one position ahead
            while (j >= 0 && comparator.compare(books.get(j), key) > 0) {
                books.set(j + 1, books.get(j));
                j = j - 1;
            }
            books.set(j + 1, key);
        }
    }
    /**
     * Sorts a list of books using the quicksort algorithm.
     * Time Complexity: O(n log n) average case, O(n^2) worst case
     * Space Complexity: O(log n)
     * @param books List of books to be sorted
     * @param comparator Comparator to determine the ordering of books
     * @param low Starting index of the subarray
     * @param high Ending index of the subarray
     */
    public static void quickSort(List<Book> books, Comparator<Book> comparator, int low, int high) {
        if (low < high) {
            // Find the partition index
            int pi = partition(books, comparator, low, high);
            // Recursively sort elements before and after partition
            quickSort(books, comparator, low, pi - 1);
            quickSort(books, comparator, pi + 1, high);
        }
    }
    /**
     * Helper method for quicksort that partitions the array around a pivot.
     * @param books List of books to be partitioned
     * @param comparator Comparator to determine the ordering of books
     * @param low Starting index of the subarray
     * @param high Ending index of the subarray
     * @return The position of the pivot element
     */
    private static int partition(List<Book> books, Comparator<Book> comparator, int low, int high) {
        Book pivot = books.get(high);
        int i = (low - 1); // Index of smaller element

        // Traverse through all elements
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (comparator.compare(books.get(j), pivot) <= 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}