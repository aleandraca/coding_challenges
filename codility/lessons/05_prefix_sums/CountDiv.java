public class CountDiv {
  public static int solution(int a, int b, int k) {
    return Math.floorDiv(b, k) - Math.floorDiv(a - 1, k);
  }

  // Brute force solution O(n)
  public static int solution2(int a, int b, int k) {
    int counter = 0;
    for (int i = a; i <= b; i++) {
      if (i % k == 0) {
        counter++;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    var expected = 3;
    var actual = solution(6, 11, 2);
    System.out.println((expected == actual ? "🟢" : "🔴")
        + " Result " + actual + " Expected " + expected);
  }
}
