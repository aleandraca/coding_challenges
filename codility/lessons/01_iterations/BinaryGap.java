/**
 * Codility > Lesson 1 > Iterations > BinaryGap
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap {
  public static void main(String[] args) {
    int n = 72; // in binary: 1001000
    int actual = solution(n);
    var expected = 2;
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " Result " + actual
        + " Expected " + expected);
  }

  public static int solution(int n) {
    var bin = Integer.toBinaryString(n).toCharArray();
    int gap = 0;
    int maxGap = 0;
    for (var bit : bin) {
      if (bit == '0') {
        gap++;
      } else {
        maxGap = Math.max(gap, maxGap);
        gap = 0;
      }
    }
    return maxGap;
  }

  public static int bitwiseSolution(int n) {
    int gap = -1;
    int maxGap = 0;
    while (n > 0) {
      if ((n & 1) == 1) { // Checking if the left most bit is 1 with AND
        maxGap = Math.max(gap, maxGap);
        gap = 0;
      } else if (gap != -1) {
        gap++;
      }
      n >>= 1;
    }
    return maxGap;
  }
}
