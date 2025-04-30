// SwapProcessor.java
public class SwapProcessor<T> {
    
    /**
     * Processes a pair of values by displaying them, swapping them, and displaying again
     * @param pair The pair of values to process
     */
    public void processAndSwap(Pair<T> pair) {
        System.out.println("Original values: " + pair.getFirst() + ", " + pair.getSecond());
        swapValues(pair);
        System.out.println("Swapped values: " + pair.getFirst() + ", " + pair.getSecond());
    }
    
    /**
     * Swaps the values in the pair
     * @param pair The pair of values to swap
     */
    private void swapValues(Pair<T> pair) {
        T temp = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(temp);
    }
}
