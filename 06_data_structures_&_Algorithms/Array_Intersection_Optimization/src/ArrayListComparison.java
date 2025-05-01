import java.util.*;

public class ArrayListComparison {
    public static class ComparisonResult {
        private final List<Integer> uniqueToList1;
        private final List<Integer> uniqueToList2;
        private final List<Integer> intersection;

        public ComparisonResult(List<Integer> uniqueToList1, List<Integer> uniqueToList2, List<Integer> intersection) {
            this.uniqueToList1 = uniqueToList1;
            this.uniqueToList2 = uniqueToList2;
            this.intersection = intersection;
        }
        public List<Integer> getUniqueToList1() {
            return uniqueToList1;
        }
        public List<Integer> getUniqueToList2() {
            return uniqueToList2;
        }
        public void printResults() {
            System.out.println("\nComparison Results:");
            System.out.println("Elements unique to List 1: " + uniqueToList1);
            System.out.println("Elements unique to List 2: " + uniqueToList2);
            System.out.println("Intersection: " + intersection);
            System.out.println("Number of intersected elements: " + intersection.size());
        }
    }

    public static ArrayList<Integer> generateRandomList(int size, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }
        return list;
    }

    public static ComparisonResult compareLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // Create frequency maps for both lists

        // Count frequencies in first list
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);


        // Find intersections and unique elements

        Set<Integer> intersection = new HashSet<>();

        for (int num : list2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        set1.removeAll(intersection);
        set2.removeAll(intersection);
        // Sort results for better readability
        List<Integer> uniqueToList1 = new ArrayList<>(set1);
        List<Integer> uniqueToList2 = new ArrayList<>(set2);
        List<Integer> intersectionList = new ArrayList<>(intersection);
        Collections.sort(uniqueToList1);
        Collections.sort(uniqueToList2);
        Collections.sort(intersectionList);

        return new ComparisonResult(uniqueToList1, uniqueToList2, intersectionList);
    }
    public static void main(String[] args) {
        // Generate random lists
        Random random = new Random();
        int size1 = random.nextInt(10) + 5; // Random size between 5 and 14
        int size2 = random.nextInt(10) + 5;
        int maxValue = 20; // Maximum value for random numbers

        ArrayList<Integer> list1 = generateRandomList(size1, maxValue);
        ArrayList<Integer> list2 = generateRandomList(size2, maxValue);

        // Print original lists
        System.out.println("List 1 (size=" + size1 + "): " + list1);
        System.out.println("List 2 (size=" + size2 + "): " + list2);

        ComparisonResult result = compareLists(list1, list2);
        result.printResults();
        System.out.println("\nStatistics:");
        System.out.println("List 1 size: " + result.getUniqueToList1().size());
        System.out.println("List 2 size: " + result.getUniqueToList2().size());
        System.out.println("Unique elements in List 1: " + result.uniqueToList1.size());
        System.out.println("Unique elements in List 2: " + result.uniqueToList2.size());

    }
}
