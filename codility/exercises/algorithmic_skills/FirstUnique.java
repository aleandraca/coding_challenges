import java.util.*;

/**
 * Codility's First Unique excersice. 100% java 11
 * https://app.codility.com/programmers/trainings/4/first_unique/
 * In this exercise the key concept is using a **LinkedHashMap**
 * which ensures insertion order. I included 2 versions of the solution.
 */
public class FirstUnique {
  public static void main(String[] args) {
    var a = new int[] { 4, 10, 5, 4, 2, 10 };
    System.out.println(Arrays.toString(a) + " -> " + simpleSolution(a));
    var b = new int[] { 1, 4, 3, 3, 1, 2 };
    System.out.println(Arrays.toString(b) + " -> " + simpleSolution(b));
    var c = new int[] { 6, 4, 4, 6 };
    System.out.println(Arrays.toString(c) + " -> " + simpleSolution(c));
  }

  public static int simpleSolution(int[] a) {
    var map = new HashMap<Integer, Integer>();
    for (int num : a) {
      map.merge(num, 1, Integer::sum);
    }
    for (int num : a) {
      if (map.get(num) == 1) {
        return num;
      }
    }
    return -1;
  }

  // Functional approach with streams
  public static int solution1(int[] a) {
    var map = new LinkedHashMap<Integer, Integer>();
    Arrays.stream(a).forEach(n -> map.merge(n, 1, Integer::sum));
    return map.entrySet().stream()
        .filter(e -> e.getValue() == 1)
        .map(e -> e.getKey())
        .findFirst()
        .orElse(-1);
  }

  public static int solution2(int[] a) {
    var map = new LinkedHashMap<Integer, Integer>();
    for (int n : a) {
      map.merge(n, 1, Integer::sum);
    }
    for (var entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return -1;
  }
}
