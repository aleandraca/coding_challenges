import java.util.HashSet;

/**
 * Codility > Lesson 4 > Counting Elements > MissingInteger
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
public class MissingInteger {
  public static void main(String[] args) {
    var a = new int[] { 1, 3, 6, 4, 1, 2 };
    int actual = solution2(a);
    int expected = 5;
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " Result " + actual
        + " Expected " + expected);
  }

  // 100%
  public static int solution(int[] nums) {
    var set = new HashSet<Integer>();
    for (int num : nums) {
      set.add(num);
    }
    for (int i = 1; i <= nums.length; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return nums.length + 1;
  }

  // Array solution 100%
  public static int solution2(int[] nums) {
    boolean[] seen = new boolean[nums.length + 1];
    for (int num : nums) {
      if (num > 0 && num <= nums.length) {
        seen[num] = true;
      }
    }
    for (int i = 1; i <= nums.length; i++) {
      if (!seen[i]) {
        return i;
      }
    }
    return nums.length + 1;
  }
}
