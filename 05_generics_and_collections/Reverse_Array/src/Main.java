// Main class that uses the other classes
public class Main {
    public static void main(String[] args) {
        final int NUM_ELEMENTS = 8;

        // Create instances of our classes
        GetInput inputHandler = new GetInput();
        PrintArray printer = new PrintArray();

        // Get input from user
        int[] userVals = inputHandler.getInputArray(NUM_ELEMENTS);

        // Create reverser and reverse the array
        ArrayReverser reverser = new ArrayReverser(userVals);
        reverser.reverse();

        // Print the reversed array
        printer.printArray(reverser.getArray());

        // Clean up
        inputHandler.close();
    }
}
