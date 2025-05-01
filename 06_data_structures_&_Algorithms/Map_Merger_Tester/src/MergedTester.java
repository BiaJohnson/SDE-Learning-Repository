import java.util.Map;
import java.util.HashMap;

public class MergedTester
{
   public static void main(String[] args)
   {
      Map<String, Integer> a = new HashMap<>();
      Map<String, Integer> b = new HashMap<>();
      Map<String, Integer> c = new HashMap<>();
      a.put("Jack", 1234);
      a.put("Jill", 4567);
      a.put("Alice", 1222);
      b.put("Jack", 777);
      b.put("Jill", 4567);
      b.put("Alice", 122);
      c.put("Rodney", 4567);
      c.put("Alice", 1222);
      c.put("Jack", 777);
      c.put("Jill", 4567);

      System.out.println(Maps.merge(a, b));
      System.out.println(
         "Expected: {Alice=[122, 1222], Jack=[777, 1234], Jill=[4567]}");
      System.out.println(Maps.merge(a, c));
      System.out.println(
         "Expected: {Alice=[1222], Jack=[777, 1234], Jill=[4567], Rodney=[4567]}");
      System.out.println(Maps.merge(c, b));
      System.out.println(
         "Expected: {Alice=[122, 1222], Jack=[777], Jill=[4567], Rodney=[4567]}");
   }
}
