/**
 * A stack implementation specifically for handling odd numbers.
 * This class provides basic stack operations and additional functionality
 * for processing odd numbers.
 */
public class OddStack {

    /** Array to store the initial odd numbers */
    int[] oddNumbers;
    /** Array to store the resized odd numbers stack */
    int[] oddNumbersResized;

    /**
     * Constructs an OddStack with the specified size.
     * @param size The initial size of the stack
     */
    public OddStack(int size) {
        this.oddNumbers = new int[size];
        this.oddNumbersResized = new int[size];
    }

    /**
     * Pushes a number onto the stack at the specified index.
     * @param number The number to push
     * @param index The index where the number should be stored
     */
    public void push(int number, int index){
        oddNumbers[index] = number;
    }

    /**
     * Resizes the stack to a new size and copies existing elements.
     * @param arraysize The new size for the stack
     */
    public void oddResized(int arraysize){
        this.oddNumbersResized = new int[arraysize];

        // Copy elements from original array to resized array
        for (int i = 0; i < arraysize; i++){
            oddNumbersResized[i]=oddNumbers[i];
        }
    }

    /**
     * Removes and returns the top element from the stack.
     * Note: this method is not used in the main program, but is included for completeness
     * Shifts remaining elements up and clears the bottom element.
     */
    public void pop(){
        if (!isEmpty()) {
            int removedNumber = oddNumbersResized[oddNumbersResized.length - 1];
            // Shift all elements up by one position
            for (int i = oddNumbersResized.length - 1; i > 0; i--) {
                oddNumbersResized[i] = oddNumbersResized[i - 1];
            }
            oddNumbersResized[0] = 0;  // Clear first element
            System.out.println("Popped: " + removedNumber);
        } else {
            System.out.println("Stack is empty");
        }
    }

    /**
     * Returns the top element of the stack without removing it.
     * Note: this method is not used in the main program, but is included for completeness
     * @return The top element, or -1 if the stack is empty
     */
    public int peek(){
        if (!isEmpty()) {
            return oddNumbersResized[oddNumbersResized.length - 1];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return oddNumbersResized.length == 0;
    }

    /**
     * Prints all numbers in the stack from top to bottom.
     */
    public void printOddNumbers(){
        System.out.println("*****************************************");
        System.out.println("- Processing stack with odd numbers: ");
        // Iterate through the list from end to start
        for (int i = oddNumbersResized.length - 1; i >= 0; i--) {
            System.out.println(oddNumbersResized[i]);
        }
    }

    /**
     * Calculates and prints the sum of all numbers in the stack.
     */
    public void sumOddNumbers(){
        int sum = 0;
        // Add each number to the running sum
        for (int number : oddNumbersResized){
            sum += number;
        }
        System.out.println("- Sum of odd numbers: " + sum);
    }

}
