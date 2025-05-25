import java.util.*;

public class Solution {
  // O(n) space and time complexity.
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    int maxFrequency = 0;
    for (int num : nums) {
      frequencyMap.merge(num, 1, Integer::sum);
      maxFrequency = Math.max(maxFrequency, frequencyMap.get(num));
    }
    List<List<Integer>> buckets = new ArrayList<>(maxFrequency);
    for (int i = 0; i < maxFrequency; i++) {
      buckets.add(new ArrayList<>());
    }
    frequencyMap.forEach((num, frequency) -> {
      buckets.get(frequency - 1).add(num);
    });
    var topKResult = new int[k];
    int resultIndex = 0;
    for (int i = maxFrequency - 1; i >= 0; i--) {
      for (int num : buckets.get(i)) {
        topKResult[resultIndex++] = num;
        if (resultIndex == k) {
          return topKResult;
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    var nums = new int[] { 5, 3, 1, 1, 1, 3, 73, 1 };
    int[] actual = topKFrequent(nums, 2);
    var expected = new int[] { 1, 3 };
    System.out.println((Arrays.equals(actual, expected) ? "🟢" : "🔴")
        + " Input" + Arrays.toString(nums) + " -> "
        + " Result " + Arrays.toString(actual)
        + " Expected " + Arrays.toString(expected));
  }
}
