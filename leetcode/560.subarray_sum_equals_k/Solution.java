import java.util.*;

class Solution {
  // Sub-optimal O(n^2) time complexity
  public static int subarraySum1(int[] nums, int k) {
    var prefixSum = new int[nums.length + 1];
    int matches = 0;
    for (int i = 0; i < nums.length; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    for (int i = 0; i < prefixSum.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int rangeSum = prefixSum[j + 1] - prefixSum[i];
        if (rangeSum == k) {
          matches++;
        }
      }
    }
    return matches;
  }

  // Optimal solution O(n) time complexity.
  public static int subarraySum(int[] nums, int k) {
    int matches = 0;
    int currentSum = 0;
    var sumFreqs = new HashMap<Integer, Integer>();
    sumFreqs.put(0, 1);
    for (int num : nums) {
      currentSum += num;
      int target = currentSum - k;
      matches += sumFreqs.getOrDefault(target, 0);
      sumFreqs.merge(currentSum, 1, Integer::sum);
    }
    return matches;
  }

  public static void main(String[] args) {
    var input = new int[] { 5, 2, 3, 1 };
    int expected = 2;
    var actual = subarraySum1(input, 5);
    System.out.println((expected == actual ? "🟢" : "🔴")
        + " Input" + Arrays.toString(input) + " -> " + " Result " + actual
        + " Expected " + expected);
  }
}
