import java.util.*;

public class Solution {
  public static int solution(int[] nums) {
    return 0;
  }

  public static void main(String[] args) {
    var input = new int[] { 7 };
    int expected = 5;
    var actual = solution(input);
    System.out.println((expected == actual ? "🟢" : "🔴")
        + " In " + Arrays.toString(input) + " ->"
        + " Out " + actual
        + " ▫️Expected " + expected);
  }
}
