import java.util.Arrays;
import java.util.function.*;

/**
 * Codility Lesson 2 / Arrays / CyclicRotation
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * The simplest O(n) solution is to use modular arithmetic so we can wrap around
 * when we reach the length of the array, especially useful when k > n.
 * I also included another less performant solution O(n*k).
 */
public class CyclicRotation {

  // 100% O(n) time complexity O(1) space complexity
  // Using the reversal algorithm to achieve constant space complexity
  public int[] solution(int[] nums, int k) {
    int n = nums.length;
    if (n == 0 || k % n == 0) {
      return nums;
    }
    k %= n;
    BiConsumer<Integer, Integer> reverseSubArray = (start, end) -> {
      while (start < end) {
        int lastElem = nums[end];
        nums[end] = nums[start];
        nums[start] = lastElem;
        start++;
        end--;
      }
    };
    reverseSubArray.accept(n - k, n - 1);
    reverseSubArray.accept(0, n - 1 - k);
    reverseSubArray.accept(0, n - 1);
    return nums;
  }

  // 100% O(n) Making use of modular arithmetic
  // O(n) space complexity
  public int[] solution2(int[] a, int k) {
    int n = a.length;
    if (n < 2 || k % n == 0) {
      return a;
    }
    var b = new int[n];
    for (int i = 0; i < n; i++) {
      b[(i + k) % n] = a[i];
    }
    return b;
  }

  // 100% O(k*n) we rotate the array step by step.
  public int[] solution3(int[] a, int k) {
    int n = a.length;
    if (n == 0 || k % n == 0) {
      return a;
    }
    var b = new int[n];
    for (int i = 0; i < k; i++) {
      for (int j = 1; j <= n; j++) {
        if (j == n) {
          b[0] = a[n - 1];
        } else {
          b[j] = a[j - 1];
        }
      }
    }
    return b;
  }

  public static void main(String[] args) {
    test(new TestCase(new int[] { 8, 5, 2 }, 4, new int[] { 2, 8, 5 }));
    test(new TestCase(new int[] { 3, 8, 9, 7, 6 }, 3, new int[] { 9, 7, 6, 3, 8 }));
    test(new TestCase(new int[] {}, 1, new int[] {}));
    test(new TestCase(new int[] { 1 }, 0, new int[] { 1 }));
    test(new TestCase(new int[] { 1, 2, 3, 4 }, 8, new int[] { 1, 2, 3, 4 }));
  }

  private record TestCase(int[] nums, int k, int[] expected) {
  }

  private static void test(TestCase testCase) {
    var app = new CyclicRotation();
    var actual = app.solution(testCase.nums, testCase.k);
    System.out.println((Arrays.equals(actual, testCase.expected) ? "🟢 " : "🔴 ")
        + Arrays.toString(testCase.nums) + " k: " + testCase.k + "\n  ↪️"
        + " Out " + Arrays.toString(actual)
        + " | Expected " + Arrays.toString(testCase.expected));
  }
}
