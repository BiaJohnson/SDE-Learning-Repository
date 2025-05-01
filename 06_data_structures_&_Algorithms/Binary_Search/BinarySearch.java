import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A class that implements binary search algorithm on a sorted array of integers.
 * Includes functionality to read input numbers and search for a target value.
 */
public class BinarySearch {
   // Counter for number of recursive calls made
   static int recursions = 0;
   // Counter for number of comparisons made during search
   static int comparisons = 0;

   /**
    * Reads integers from user input and stores them in an ArrayList.
    * Ensures numbers are entered in non-decreasing order.
    *
    * @param scnr Scanner object for reading user input
    * @return ArrayList containing the entered integers in sorted order
    */
   private static ArrayList<Integer> readNums(Scanner scnr) {
      ArrayList<Integer> nums = new ArrayList<Integer>();
      int size = 0;
      int numInput = 0;

      // Track previous number to ensure non-decreasing order
      Integer previous = null;

      System.out.println("Please enter the number of elements the array will hold:  ");
      // Get valid size input from user
      while (true){
         try {
            size = scnr.nextInt();
            break;
         }catch (Exception e){
            System.out.println("Invalid input. Please enter a whole number.");
            scnr.nextLine();
         }
      }

      // Read numbers from user input
      for (int i = 0; i < size; i++){
         while(true){
            try {
               System.out.print("Enter a number "+ (i + 1) + " :");
               numInput = scnr.nextInt();

               // Verify number is not less than previous (maintains sorted order)
               if (previous != null && numInput < previous){
                  System.out.println("Error: The numbers must be entered in non-decreasing order.");
               }
               else{
                  nums.add(i, numInput);
                  previous = numInput;
                  break;
               }
            } catch (InputMismatchException e) {
               System.out.println("Invalid input. Please enter an integer.");
               scnr.nextLine(); //clear buffer
            }
         }
      }
     return nums;
   }

   /**
    * Performs binary search recursively on a sorted ArrayList to find target value.
    * Tracks number of recursions and comparisons made during search.
    *
    * @param target value to search for
    * @param integers sorted ArrayList to search in
    * @param lower lower bound of current search range
    * @param upper upper bound of current search range
    * @return index of target if found, -1 if not found
    */
   static public int binarySearch(int target, ArrayList<Integer> integers, int lower, int upper) {
      recursions++;

      // Base case: if left(lower) pointer exceeds right(upper) pointer, element not found
      if (lower > upper) {
         return -1;
      }

      // Calculate middle point
      int mid = lower + (upper - lower) / 2;

      comparisons++;
      // If element is found at middle point, return its index
      if (integers.get(mid) == target) {
         return mid;
      }

      comparisons++;
      // If element is smaller than middle point, search in left(lower) half
      if (integers.get(mid) > target) {
         return binarySearch(target, integers, lower, mid - 1);
      }

      // If element is larger than middle point, search in right(upper) half
      return binarySearch(target, integers, mid + 1, upper);
   }

   /**
    * Main method that handles user input and executes binary search.
    * Prints results including search outcome and performance metrics.
    *
    * @param args command line arguments (not used)
    */
   public static void main(String [] args) {
      Scanner scnr = new Scanner(System.in);
      // Input a list of integers
      ArrayList<Integer> integers = readNums(scnr);
      int target = 0;

      System.out.println("Enter a target value to search for: ");
      // Input a target value for the search
      while (true){
         try {
            target = scnr.nextInt();
            break;
         }catch (Exception e){
            System.out.println("Invalid input. Please enter an integer.");
            scnr.nextLine();
         }
      }
      scnr.close();

      // Reset counters before search
      recursions=0;
      comparisons=0;

      // Perform binary search
      int index = binarySearch(target, integers, 0, integers.size() - 1);

      // Output results
      if (index != -1){
         System.out.println("Element found at index: " + index);
      } else {
         System.out.println("Element not found in the list");
      }

      // Print performance metrics
      System.out.printf("index: %d, recursions: %d, comparisons: %d\n", index, recursions, comparisons);
   }
}
