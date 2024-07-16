import java.util.HashSet;

/**
 * Codility > Lesson 4 > Counting Elements > PermCheck
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_co
 */
public class PermCheck {
  public static void main(String[] args) {
    var a = new int[] { 4, 1, 3, 2 };
    int actual = arraySolution(a);
    var expected = 1;
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " Result " + actual
        + " Expected " + expected);

  }

  // 100% | time: O(n) | space: O(1)
  public static int xorSolution(int[] a) {
    int result = 0;
    for (int i = 1; i <= a.length; i++) {
      result ^= i ^ a[i - 1];
    }
    return result == 0 ? 1 : 0;
  }

  // 100% | time: O(n) | space: O(n)
  public static int solution(int[] a) {
    var set = new HashSet<Integer>();
    long sum = 0;
    for (int num : a) {
      if (!set.add(num)) {
        return 0;
      }
      sum += num;
    }
    long total = a.length * (a.length + 1L) / 2;
    return total - sum == 0 ? 1 : 0;
  }

  // 100% | time: O(n) | space: O(n)
  public static int arraySolution(int[] a) {
    var b = new int[a.length];
    for (int num : a) {
      if (b[num - 1] > a.length || b[num - 1] == 1) {
        return 0;
      }
      b[num - 1] = 1;
    }
    return 1;
  }
}
