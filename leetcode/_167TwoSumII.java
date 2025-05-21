import java.util.*;

public class _167TwoSumII {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int currentSum = numbers[left] + numbers[right];
      if (currentSum == target) {
        return new int[] {left + 1, right + 1};
      } else if (currentSum > target) {
        right--;
      } else {
        left++;
      }
    }
    throw new IllegalStateException("No solution found!");
  }

  public static void main(String[] args) {
    test(new Inputs(new int[]{2,7,11,15}, 9), new int[]{1,2});
    test(new Inputs(new int[]{2,3,4}, 6), new int[]{1,3});
    test(new Inputs(new int[]{-6,-3,-2,0,10,11,20}, 9), new int[]{3,6});
  }

  private record Inputs(int[] numbers, int target) {}

  public static void test(Inputs input, int[] expected) {
    var app = new _167TwoSumII();
    var actual = app.twoSum(input.numbers, input.target);
    var result = Arrays.equals(actual, expected) ? "🟢" : "🔴";
    System.out.println(result + " IN " + "numbers=" + Arrays.toString(input.numbers)
        + ", target=" + input.target
        + "\n  ↪️ OUT " + Arrays.toString(actual) + " | Expected " + Arrays.toString(expected));
  }
}
