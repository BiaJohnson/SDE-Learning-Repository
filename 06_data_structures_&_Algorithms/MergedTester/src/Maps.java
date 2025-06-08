
import java.util.*;

public class Maps
{
   /**
      Returns a new map with merged key-value pairs.
      @param map1 the first map to compare
      @param map2 the second map to compare
      @return a map containing a set of entries in each map
   */
   public static Map<String, Set<Integer>> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
     // Create a new TreeMap to store the merged results
     Map<String, Set<Integer>> merged = new TreeMap<>();

      // Process both maps using the helper method
      addToMergedMap(merged, map1);
      addToMergedMap(merged, map2);

      // Return the merged map containing all entries
      return merged;
   }

   /**
    * Helper method that processes a map and adds its entries to the merged result map
    * @param merged The destination map to add entries to
    * @param mapToAdd The source map containing entries to be added
    */
   private static void addToMergedMap(Map<String, Set<Integer>> merged, Map<String, Integer> mapToAdd) {
      // Iterate through all entries in the source map
      for (Map.Entry<String, Integer> entry : mapToAdd.entrySet()) {
         String key = entry.getKey();
         Integer value = entry.getValue();
         // Create a new TreeSet for the key if it doesn't exist
         merged.putIfAbsent(key, new TreeSet<>()); // TreeSet to maintain natural order
         // Add the value to the set associated with the key
         merged.get(key).add(value);
      }
   }
}
