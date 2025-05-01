/**
 * A class that processes even and odd numbers using Queue and Stack data structures.
 * The program takes user input for a series of numbers and separates them into even and odd numbers.
 * Note: used array as per instruction: "please write methods to manipulate arrays instead."
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class SumOddEvenNumbers {
    /**
     * The main method that handles user input and program execution.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int amount= 0;
        int[] numbers;

        // Get valid input for array size from user
        while (true) {
            System.out.println("How many numbers would you like to add to the Queue/Stack? ");
            try {
                String input = scanner.nextLine();
                amount = Integer.parseInt(input);

                // Validate that input is positive
                if (amount <= 0) {
                    if (amount == 0) {
                        System.out.println("Zero is not valid. Please enter a positive integer.");
                    } else {
                        System.out.println("Negative numbers are not valid. Please enter a positive integer.");
                    }
                } else {
                    numbers = new int[amount];
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }

        // Get numbers from user and store in array
        for (int i = 0; i < amount; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            try {
                int number = scanner.nextInt();
                numbers[i] = number;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer number: ");
                scanner.next();
                i--; // Decrement counter to retry current position
            }
        }
        scanner.close();
        processEvenOddNumbers(numbers);
    }

    /**
     * Processes an array of numbers by separating even and odd numbers into respective data structures.
     * Even numbers are stored in a Queue while odd numbers are stored in a Stack.
     * @param numbers The array of integers to process
     */
    public static void processEvenOddNumbers(int[] numbers){
        EvenQueue evenQueue = new EvenQueue(numbers.length);
        OddStack oddStack = new OddStack(numbers.length);
        int oddIterator = 0;
        int evenIterator = 0;

        // Separate numbers into even and odd
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenQueue.enqueu(number, evenIterator);
                evenIterator++;
            } else {
                oddStack.push(number, oddIterator);
                oddIterator++;
            }
        }

        // Process and display even numbers
        evenQueue.evenResized(evenIterator);
        evenQueue.printEvenNumbers();
        evenQueue.sumEvenNumbers();

        // Process and display odd numbers
        oddStack.oddResized(oddIterator);
        oddStack.printOddNumbers();
        oddStack.sumOddNumbers();
    }
}
