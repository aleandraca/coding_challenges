/**
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable
 */
public class NumArray {
  private int[] prefixSum;

  public NumArray(int[] nums) {
    prefixSum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      prefixSum[i + 1] = nums[i] + prefixSum[i];
    }
  }

  public int sumRange(int left, int right) {
    return prefixSum[right + 1] - prefixSum[left];
  }

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    var obj = new NumArray(nums);

    assertThat(obj.sumRange(0, 2), 1);
    assertThat(obj.sumRange(2, 5), -1);
    assertThat(obj.sumRange(0, 5), -3);
  }

  private static void assertThat(int actual, int expected){
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " Result " + actual
        + " Expected " + expected);

  }
}
