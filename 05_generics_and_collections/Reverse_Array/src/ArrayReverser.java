// Class responsible for array operations

public class ArrayReverser {
    private int[] array;

    public ArrayReverser(int[] array) {
        this.array = array;
    }

    public void reverse() {
        for (int i = 0; i < array.length / 2; i++) {
            int temporaryHolder = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temporaryHolder;
        }
    }

    public int[] getArray() {
        return array;
    }
}
