import java.util.*;

/**
 * Codility's First Unique excersice. 100% java 11
 * https://app.codility.com/programmers/trainings/4/first_unique/
 */
public class FirstUnique {
  public static void main(String[] args) {
    var a = new int[] { 4, 10, 5, 4, 2, 10 };
    System.out.println(Arrays.toString(a) + " -> " + solution(a));
    var b = new int[] { 1, 4, 3, 3, 1, 2 };
    System.out.println(Arrays.toString(b) + " -> " + solution(b));
    var c = new int[] { 6, 4, 4, 6 };
    System.out.println(Arrays.toString(c) + " -> " + solution(c));
  }

  public static int solution(int[] a) {
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
