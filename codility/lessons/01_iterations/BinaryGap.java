public class BinaryGap {
  public static void main(String[] args) {
    // n=561892=10001001001011100100_2
    var n = 561892;
    var solution = solution(n);
    System.out.println("Solution: " + solution + " when n = " + n);
    assert solution == 3;
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
}
