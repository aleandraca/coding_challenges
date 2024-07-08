import java.util.stream.*;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class TapeEquilibrium {
  public static void main(String[] args) {
    var a = new int[] { 3, 1, 2, 4, 3 };
    int actual = solution(a);
    int ex = 1;
    System.out.println((ex == actual ? "🟢" : "🔴") + " Result " + actual + " Expected " + ex);
  }

  // O(n) | 100%
  public static int solution(int[] a) {
    int total = IntStream.of(a).sum();
    int sumLeft = 0;
    int minDiff = Integer.MAX_VALUE;
    for (int num : a) {
      sumLeft += num;
      int sumRight = total - sumLeft;
      minDiff = min(abs(sumLeft - sumRight), minDiff);
    }
    return minDiff;
  }
}
