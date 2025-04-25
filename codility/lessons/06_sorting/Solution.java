import java.util.*;

public class Solution {
  public static int solution(int[] nums) {
    var set = new HashSet<Integer>();
    for (int num : nums) {
      set.add(num);
    }
    return set.size();
  }

  public static void main(String[] args) {
    var input = new int[] { 2, 1, 1, 2, 3, 1 };
    int expected = 3;
    var actual = solution(input);
    System.out.println((expected == actual ? "🟢" : "🔴")
        + " Input" + Arrays.toString(input) + " -> " + " Result " + actual
        + " Result " + actual
        + " Expected " + expected);
  }
}
