import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Lc739DailyTemperatures {
  // O(n) space and time complexity
  public int[] dailyTemperatures(int[] temps) {
    var result = new int[temps.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < temps.length; i++) {
      while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
        result[stack.peek()] = i - stack.pop();
      }
      stack.push(i);
    }
    return result;
  }

  public static void main(String[] args) {
    test(new TestCase(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }, new int[] { 1, 1, 4, 2, 1, 1, 0, 0 }));
    test(new TestCase(new int[] { 30, 40, 50, 60 }, new int[] { 1, 1, 1, 0 }));
    test(new TestCase(new int[] { 30, 60, 90 }, new int[] { 1, 1, 0 }));
    test(new TestCase(new int[] { 80, 80, 81, 79 }, new int[] { 2, 1, 0, 0 }));
  }

  private record TestCase(int[] temps, int[] expected) {
    @Override
    public final String toString() {
      return "Temperatures:" + Arrays.toString(temps) + " | Expected:" + Arrays.toString(expected);
    }
  }

  public static void test(TestCase tc) {
    var app = new Lc739DailyTemperatures();
    var actual = app.dailyTemperatures(tc.temps);
    System.out.print(Arrays.equals(actual, tc.expected) ? "🟢 " : "🔴 ");
    System.out.println(tc + " Actual:" + Arrays.toString(actual));
  }
}
