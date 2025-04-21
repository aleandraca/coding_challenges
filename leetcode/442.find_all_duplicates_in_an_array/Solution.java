import java.util.*;

class Solution {
  public static List<Integer> findDuplicates(int[] nums) {
    var dups = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] < 0) {
        dups.add(Math.abs(nums[i]));
      } else {
        nums[index] *= -1;
      }
    }
    return dups;
  }

  public static void main(String[] args) {
    var input = new int[] { 10, 2, 5, 10, 9, 1, 1, 4, 3, 7 };
    var expected = List.of(10, 1);
    var actual = findDuplicates(input);
    System.out.println((expected.equals(actual) ? "🟢" : "🔴")
        + " Input" + Arrays.toString(input) + " -> " + " Result " + actual
        + " Expected " + expected);
  }
}
