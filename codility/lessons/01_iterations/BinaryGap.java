public class BinaryGap {
  public static void main(String[] args) {
    // n=561892=10001001001011100100_2
    var n = 561892;
    var solution = solution(n);
    System.out.println("Solution: " + solution + " when n = " + n);
    assert bitwiseSolution(n) == 3;
  }

  public static int solution(int n) {
    var bin = Integer.toBinaryString(n).toCharArray();
    int gap = 0;
    int maxGap = 0;
    for (var bit : bin) {
      if (bit == '0') {
        gap++;
      } else {
        maxGap = gap > maxGap ? gap : maxGap;
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
