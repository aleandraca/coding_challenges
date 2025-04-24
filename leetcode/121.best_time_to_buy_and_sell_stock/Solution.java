import java.util.*;

public class Solution {
  public static int solution(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int price : prices) {
      minPrice = Math.min(price, minPrice);
      maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    var input = new int[] { 7, 1, 5, 3, 6, 4 };
    int expected = 5;
    var actual = solution(input);
    System.out.println((expected == actual ? "🟢" : "🔴")
        + " Input" + Arrays.toString(input) + " -> " + " Result " + actual
        + " Result " + actual
        + " Expected " + expected);
  }
}
