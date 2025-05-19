public class StrSymmetryPoint {
  // Time complexity O(n) Space complexity O(1)
  public static int solution(String s) {
    int n = s.length();
    if (n % 2 == 0) {
      return -1;
    }
    for (int l = 0, r = n - 1; l != r; l++, r--) {
      if (s.charAt(l) != s.charAt(r)) {
        return -1;
      }
    }
    return n / 2;
  }

  public static void main(String[] args) {
    var input = "racxcar";
    var actual = solution(input);
    var expected = 3;
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " In " + input + " Out " + actual + " Expected " + expected);
  }
}
