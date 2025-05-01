/**
 * A queue implementation specifically for even numbers.
 * This class manages two arrays - one for initial storage and another for resized operations.
 */
public class EvenQueue {

    /** Array to store the initial even numbers */
    int[] evenNumbers;
    /** Array used for queue operations after resizing */
    int[] evenNumbersResized;

    /**
     * Constructs an EvenQueue with specified size
     * @param size The initial size of the queue
     */
    public EvenQueue(int size) {
        this.evenNumbers = new int[size];
        this.evenNumbersResized = new int[size];
    }

    /**
     * Adds a number to the queue at specified index
     * @param number The number to be added
     * @param index The position where number should be added
     */
    public void enqueu(int number, int index) {
        evenNumbers[index] = number;
    }

    /**
     * Resizes the queue to a new size and copies elements
     * @param arraysize The new size for the queue
     */
    public void evenResized(int arraysize){
        this.evenNumbersResized = new int[arraysize];

        // Copy elements from original array to resized array
        for (int i = 0; i < arraysize; i++){
            evenNumbersResized[i]=evenNumbers[i];
        }
    }

    /**
     * Removes and returns the first element from the queue
     * Shifts remaining elements to the left
     * Note: this method is not used in the main program, but is included for completeness
     */
    public void pop(){
        if (!isEmpty()) {
            int removedNumber = evenNumbersResized[0];  // Get first element
            // Shift all elements left by one position
            for (int i = 0; i < evenNumbersResized.length - 1; i++) {
                evenNumbersResized[i] = evenNumbersResized[i + 1];
            }
            evenNumbersResized[evenNumbersResized.length - 1] = 0;  // Clear last element
            System.out.println("Dequeued: " + removedNumber);
        } else {
            System.out.println("Queue is empty");
        }
    }

    /**
     * Returns the first element in the queue without removing it
     * Note: this method is not used in the main program, but is included for completeness
     * @return The first element or -1 if queue is empty
     */
    public int peek(){
        if (!isEmpty()) {
            return evenNumbersResized[0];
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    /**
     * Checks if the queue is empty
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return evenNumbersResized.length == 0;
    }

    /**
     * Prints all numbers in the queue
     */
    public void printEvenNumbers(){
        System.out.println("*****************************************");
        System.out.println("- Processing Queue with even number: ");
        // Iterate through all numbers and print them
        for (int number : evenNumbersResized){
            System.out.println(number + " ");
        }
    }

    /**
     * Calculates and prints the sum of all numbers in the queue
     */
    public void sumEvenNumbers(){
        int sum = 0;
        // Add up all numbers in the queue
        for (int number : evenNumbersResized){
            sum += number;
        }
        System.out.println("- Sum of even numbers: " + sum);
    }
}
