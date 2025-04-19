import java.util.*;

public class ArrListLen {
  public static void main(String[] args) {
    var input = new int[] { 1, 4, -1, 3, 2 };
    int expected = 4;
    int actual = solution(input);
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " Input " + Arrays.toString(input) + " -> "
        + " Result " + actual
        + " Expected " + expected);
  }

  public static int solution(int[] nums) {
    int i = 1;
    int next = 0;
    while (nums[next] != -1) {
      next = nums[next];
      i++;
    }
    return i;
  }
}
