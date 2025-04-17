import java.util.*;

public class TwoSum {
  public static void main(String[] args) {
    var input = new int[] { 2, 7, 11, 15 };
    int target = 9;
    var expected = new int[] { 1, 0 };
    var actual = solution(input, target);
    System.out.println((Arrays.equals(actual, expected) ? "🟢" : "🔴")
        + " Input" + Arrays.toString(input) + " -> "
        + " Result " + Arrays.toString(actual)
        + " Expected " + Arrays.toString(expected));
  }

  public static int[] solution(int[] nums, int target) {
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] { i, map.get(target - nums[i]) };
      }
      map.put(nums[i], i);
    }
    return null;
  }
}
