import java.util.Arrays;

public class GenomicRangeQuery {
  // O(N + M) time complexity O(N) space complexity
  public int[] solution(String s, int[] p, int[] q) {
    var minFactors = new int[p.length];
    var prefixA = new int[s.length() + 1];
    var prefixC = new int[s.length() + 1];
    var prefixG = new int[s.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      prefixA[i + 1] = prefixA[i] + (s.charAt(i) == 'A' ? 1 : 0);
      prefixC[i + 1] = prefixC[i] + (s.charAt(i) == 'C' ? 1 : 0);
      prefixG[i + 1] = prefixG[i] + (s.charAt(i) == 'G' ? 1 : 0);
    }
    for (int i = 0; i < p.length; i++) {
      if (prefixA[q[i] + 1] - prefixA[p[i]] > 0) {
        minFactors[i] = 1;
      } else if (prefixC[q[i] + 1] - prefixC[p[i]] > 0) {
        minFactors[i] = 2;
      } else if (prefixG[q[i] + 1] - prefixG[p[i]] > 0) {
        minFactors[i] = 3;
      } else {
        minFactors[i] = 4;
      }
    }
    return minFactors;
  }

  public static void main(String[] args) {
    test(new TestCase(
        "CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 },
        new int[] { 2, 4, 1 }));
    test(new TestCase(
        "GATTACA", new int[] { 0, 0, 6, 2, 1 }, new int[] { 0, 6, 6, 4, 2 },
        new int[] { 3, 1, 1, 1, 1 }));

  }

  private record TestCase(String s, int[] p, int[] q, int[] expected) {
  }

  private static void test(TestCase testCase) {
    var app = new GenomicRangeQuery();
    var actual = app.solution(testCase.s, testCase.p, testCase.q);
    System.out.println((Arrays.equals(actual, testCase.expected) ? "🟢 " : "🔴 ")
        + testCase.s + "\n  ↪️"
        + " Out " + Arrays.toString(actual)
        + " | Expected " + Arrays.toString(testCase.expected));
  }

}
