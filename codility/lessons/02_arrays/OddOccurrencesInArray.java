import java.util.*;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 * Codility > Lesson 2 Arrays > Odd Occurrences In Array
 * The most performant solution uses bitwise operator xor.
 */
public class OddOccurrencesInArray {
  public static void main(String[] args) {
    var a = new int[] { 9, 3, 9, 3, 9, 7, 9 };
    int ex = 7;
    int ac = functionalSolution(a);
    System.out.println((ex == ac ? "🟢" : "🔴") + " Result -> " + ac);
    ;
    ac = imperativeSolution(a);
    System.out.println((ex == ac ? "🟢" : "🔴") + " Result -> " + ac);
    ac = setSolution(a);
    System.out.println((ex == ac ? "🟢" : "🔴") + " Result -> " + ac);
  }

  public static int functionalSolution(int[] a) {
    return Arrays.stream(a).reduce(0, (acc, curr) -> acc ^ curr);
  }

  public static int imperativeSolution(int[] a) {
    int result = 0;
    for (int num : a) {
      result ^= num;
    }
    return result;
  }

  public static int setSolution(int[] a) {
    var set = new HashSet<Integer>();
    for (int num : a) {
      if (set.contains(num)) {
        set.remove(num);
      } else {
        set.add(num);
      }
    }
    return set.iterator().next();
  }
}
