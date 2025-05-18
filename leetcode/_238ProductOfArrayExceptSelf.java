import java.util.*;

public class _238ProductOfArrayExceptSelf {
  public static int[] solution(int[] nums) {
    var prefix = new int[nums.length + 1];
    var suffix = new int[nums.length + 1];
    prefix[0] = 1;
    suffix[suffix.length - 1] = 1;
    for (int i = 0, j = suffix.length - 2; i < nums.length; i++, j--) {
      prefix[i + 1] = prefix[i] * nums[i];
      suffix[j] = suffix[j + 1] * nums[j];
    }
    var output = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      output[i] = prefix[i] * suffix[i + 1];
    }
    return output;
  }

  public static void main(String[] args) {
    var input = new int[] { 1, 2, 3, 4 };
    var expected = new int[] { 24, 12, 8, 6 };
    var actual = solution(input);
    System.out.println((Arrays.equals(expected, actual) ? "🟢" : "🔴")
        + " Input" + Arrays.toString(input) + " -> "
        + " Result " + Arrays.toString(actual)
        + " Expected " + Arrays.toString(expected));
  }
}
