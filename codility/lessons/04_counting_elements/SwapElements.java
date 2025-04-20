import java.util.*;

public class SwapElements {
  public static void main(String[] args) {
    var a = new int[] { 6, 7, 1, 0 };
    var b = new int[] { 1, 2, 3, 4 };
    int m = 7;
    var actual = solution(a, b, m);
    var expected = true;
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " a" + Arrays.toString(a)
        + " b" + Arrays.toString(b)
        + " m " + m
        + " Result " + actual
        + " Expected " + expected);
  }

  public static boolean solution(int[] a, int[] b, int m) {
    var sumA = Arrays.stream(a).sum();
    var sumB = Arrays.stream(b).sum();
    var diff = sumA - sumB;
    if (diff % 2 == 1)
      return false;
    var targetDiff = diff / 2;
    var setA = new HashSet<Integer>();
    for (int num : a) {
      setA.add(num);
    }
    for (int bNum : b) {
      if (setA.contains(bNum + targetDiff)) {
        return true;
      }
    }
    return false;
  }
}
