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
    int index = 0;
    int length = 0;
    while (index != -1) {
      index = nums[index];
      length++;
    }
    return length;
  }
}
