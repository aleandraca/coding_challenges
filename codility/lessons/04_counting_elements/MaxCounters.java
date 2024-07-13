import java.util.Arrays;

/**
 * Codility > Lesson 4 > Counting Elements > MaxCounters
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class MaxCounters {
  public static void main(String[] args) {
    var a = new int[] { 1, 2, 3, 4, 4, 4, 4, 5, 1, 1, 1, 1 };
    int n = 4;
    int[] actual = solution(n, a);
    var expected = new int[] { 8, 4, 4, 4 };
    System.out.println((Arrays.equals(actual, expected) ? "🟢" : "🔴")
        + " Result " + Arrays.toString(actual)
        + " Expected " + Arrays.toString(expected));
  }

  // 100% O(n + m)
  public static int[] solution(int n, int[] a) {
    var counters = new int[n];
    int maxCount = 0;
    int currentMax = 0;
    for (int num : a) {
      if (num <= n) {
        counters[num - 1] = Math.max(maxCount, counters[num - 1]);
        currentMax = Math.max(++counters[num - 1], currentMax);
      } else {
        maxCount = currentMax;
      }
    }
    for (int i = 0; i < n; i++) {
      counters[i] = Math.max(counters[i], maxCount);
    }
    return counters;
  }

  // 77% in codility due timeouts, the worst case is O(n * m)
  public static int[] slowSolution(int n, int[] a) {
    var counters = new int[n];
    int max = 0;
    for (int num : a) {
      if (num <= n) {
        max = Math.max(max, ++counters[num - 1]);
      } else {
        Arrays.fill(counters, max);
      }
    }
    return counters;
  }
}
