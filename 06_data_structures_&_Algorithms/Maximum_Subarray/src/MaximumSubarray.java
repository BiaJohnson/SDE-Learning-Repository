/**
 * A class that implements different algorithms to find the maximum subarray sum in an array.
 * Contains both divide-and-conquer and linear time solutions.
 */
public class MaximumSubarray {
    /**
     * Helper method that finds the maximum subarray sum that crosses the midpoint
     * in a divide-and-conquer approach.
     *
     * @param a The input array
     * @param l The left boundary index
     * @param m The middle index
     * @param h The right boundary index
     * @return The maximum sum of a subarray that crosses the midpoint
     */
    public int maxSubarrayCross(int[] a, int l, int m, int h) {
        // Find maximum sum of the left half, starting from middle and going left
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        System.out.println("l: " + l + " m: " + m + " h: " + h);
        for (int i = m; i >= l; i--) {
            sum += a[i];
            if (sum > leftSum)
                leftSum = sum;
        }

        // Find maximum sum of the right half, starting from middle+1 and going right
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = m + 1; i <= h; i++) {
            sum += a[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        System.out.println("Left: " + leftSum);
        System.out.println("Right: " + rightSum);
        return leftSum + rightSum;
    }

    /**
     * Recursive helper method for the divide-and-conquer approach to find maximum subarray sum.
     * Divides the array into two halves and finds the maximum of:
     * 1. Maximum subarray sum in left half
     * 2. Maximum subarray sum in right half
     * 3. Maximum subarray sum crossing the middle
     *
     * @param a The input array
     * @param l The left boundary index
     * @param h The right boundary index
     * @return The maximum subarray sum in the range [l,h]
     */
    public int maxSubarrayAux(int[] a, int l, int h) {
        // Base case: single element
        if (l == h)
            return a[l];
        else {
            int m = (l + h) / 2;
            int bl = maxSubarrayAux(a, l, m);      // Find max sum in left half
            int br = maxSubarrayAux(a, m + 1, h);  // Find max sum in right half
            int bc = maxSubarrayCross(a, l, m, h); // Find max sum crossing middle
            int best = Math.max(Math.max(bl, br), bc);
            return best;
        }
    }

    /**
     * Finds the maximum subarray sum using Kadane's algorithm in O(n) time.
     * For each position, maintains the maximum sum ending at that position and
     * the maximum sum found so far.
     *
     * @param a The input array
     * @return The maximum subarray sum, or null if array is empty/null
     */
    public Integer maxSubarray(int[] a) {
        // Handle edge cases
        if (a == null || a.length == 0) {
            return null;
        }

        int maxSoFar = a[0];    // keeps track of maximum sum found so far
        int maxEnding = a[0];    // keeps track of maximum sum ending at current position

        // Start from the second element
        for (int i = 1; i < a.length; i++) {
            // Calculate maximum sum ending at current position
            maxEnding = Math.max(a[i], maxEnding + a[i]);
            // Update maximum sum if current maximum sum is greater
            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        return maxSoFar;
    }

    /**
     * Main method to test the maximum subarray algorithms
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test array with positive and negative numbers
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        //int[] a = {1,7,6,5,4,3,2,8};
        MaximumSubarray maxSubarray = new MaximumSubarray();
        System.out.println("Maximum subarray = " + maxSubarray.maxSubarray(a));
    }
}