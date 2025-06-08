import java.util.*;

public class GoldenLeader {

  public int solution(int[] nums) {
    int count = 0;
    int candidate = -1;
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += num == candidate ? 1 : -1;
    }
    count = 0;
    for (int num : nums) {
      count += num == candidate ? 1 : 0;
    }
    return count > nums.length / 2 ? candidate : -1;
  }

  public static void main(String[] args) {
    System.out.println("Running tests for ArrayLeader...");

    // Test cases based on the problem description and common scenarios
    test(new TestCase(new int[] { 6, 8, 4, 6, 8, 6, 6 }, 6)); // From PDF example
    test(new TestCase(new int[] { 1, 2, 3, 4, 5 }, -1)); // No leader
    test(new TestCase(new int[] { 1, 1, 2, 2 }, -1)); // Tie at n/2, no leader
    test(new TestCase(new int[] { 4, 4, 4, 4 }, 4)); // All same elements
    test(new TestCase(new int[] { 100 }, 100)); // Single element is always a leader
    test(new TestCase(new int[] { 1, 2, 1, 2, 1 }, 1)); // Leader exists
    test(new TestCase(new int[] { 1, 2, 1, 2, 3 }, -1)); // Candidate (3) exists but is not a leader

    System.out.println("Tests finished.");
  }

  // Private record for holding test case data
  private record TestCase(int[] input, int expected) {
  }

  // Test utility method
  public static void test(TestCase tc) {
    var solution = new GoldenLeader();
    int actual = solution.solution(tc.input);
    System.out.print(actual == tc.expected ? "🟢 " : "🔴 ");
    System.out.println("Input: " + Arrays.toString(tc.input) + "\t| Expected: " + tc.expected + " | Actual: " + actual);
  }
}
