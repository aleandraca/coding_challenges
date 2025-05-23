import java.util.*;

// ### 🟢 Easy —  [136. Single Number](https://leetcode.com/problems/single-number/)
public class _136SingleNumber {

  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    test(new TestCase(new int[] { 2, 2, 1 }, 1));
    test(new TestCase(new int[] { 4, 1, 2, 1, 2 }, 4));
    test(new TestCase(new int[] { 1 }, 1));
    test(new TestCase(new int[] { 9, 3, 9, 3, 9, 7, 9 }, 7));
  }

  private record TestCase(int[] nums, int expected) {
  }

  public static void test(TestCase testCase) {
    var app = new _136SingleNumber();
    var actual = app.singleNumber(testCase.nums);
    System.out.println((testCase.expected == actual ? "🟢 " : "🔴 ")
        + Arrays.toString(testCase.nums) + "\n  ↪️"
        + " Out " + actual + " | Expected " + testCase.expected);
  }

}
