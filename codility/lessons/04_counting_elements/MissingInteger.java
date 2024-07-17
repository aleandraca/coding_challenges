import java.util.HashSet;

/**
 * Codility > Lesson 4 > Counting Elements > MissingInteger
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
public class MissingInteger {
  public static void main(String[] args) {
    var a = new int[] { 1, 3, 6, 4, 1, 2 };
    int actual = solution(a);
    int expected = 5;
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " Result " + actual
        + " Expected " + expected);
  }

  // 100%
  public static int solution(int[] a) {
    var set = new HashSet<Integer>();
    int max = Integer.MIN_VALUE;
    for (int num : a) {
      set.add(num);
      max = Math.max(num, max);
    }
    int i = 1;
    for (; i < max; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return i == max ? i + 1 : 1;
  }
}
