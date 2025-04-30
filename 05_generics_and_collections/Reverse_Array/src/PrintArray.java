//Class responsible for output
public class PrintArray {
    public void printArray(int[] array) {
        System.out.print("\nArray values: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
