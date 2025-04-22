import java.util.*;

public class PassingCars {
  // O(1) space complexity
  public static int solution(int[] cars) {
    long pairs = 0;
    int eastCars = 0;
    for (int car : cars) {
      if (car == 0) {
        eastCars++;
      } else {
        pairs += eastCars;
        if (pairs > 1_000_000_000) {
          return -1;
        }
      }
    }
    return (int) pairs;
  }

  public static int solution1(int[] a) {
    int pairs = 0;
    var sum = new int[a.length + 1];
    for (int i = a.length - 1; i >= 0; i--) {
      sum[i] = sum[i + 1] + a[i];
    }
    for (int i = 0; i < a.length; i++) {
      if (pairs > 1_000_000_000) {
        return -1;
      }
      if (a[i] == 0) {
        pairs += sum[i];
      }
    }
    return pairs;
  }

  public static void main(String[] args) {
    var input = new int[] { 0, 1, 0, 1, 1 };
    var expected = 5;
    var actual = solution(input);
    System.out.println((expected == actual ? "🟢" : "🔴")
        + " Input" + Arrays.toString(input) + " -> " + " Result " + actual
        + " Expected " + expected);
  }
}
