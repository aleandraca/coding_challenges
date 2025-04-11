import java.util.stream.*;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class TapeEquilibrium {
  public static void main(String[] args) {
    var a = new int[] { -1000, 1000 };
    int actual = solution(a);
    int ex = 2000;
    System.out.println((ex == actual ? "🟢" : "🔴") + " Result " + actual + " Expected " + ex);
  }

  // O(n) | 100%
  public static int solution(int[] a) {
    int total = IntStream.of(a).sum();
    int sumLeft = 0;
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < a.length - 1; i++) {
      sumLeft += a[i];
      int sumRight = total - sumLeft;
      minDiff = min(abs(sumLeft - sumRight), minDiff);
    }
    return minDiff;
  }
}
