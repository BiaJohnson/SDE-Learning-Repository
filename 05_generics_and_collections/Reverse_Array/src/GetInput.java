import java.util.Scanner;

//Class responsible for user input
public class GetInput {
    private Scanner scanner;

    public GetInput() {
        scanner = new Scanner(System.in);
    }

    public int[] getInputArray(int size) {
        int[] values = new int[size];
        System.out.println("Enter " + size + " integer values...");

        for (int i = 0; i < size; i++) {
            System.out.print("Value: ");
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public void close() {
        scanner.close();
    }
}
