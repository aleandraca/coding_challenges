import java.util.HashSet;

/**
 * Codility's
 * [FrogRiverOne](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one)
 * Easy
 */
public class FrogRiverOne {
  public static void main(String[] args) {
    var a = new int[] { 1, 3, 1, 4, 2, 3, 5, 4 };
    int actual = arraySolution(5, a);
    int ex = 6;
    System.out.println((ex == actual ? "🟢" : "🔴") + " Result " + actual + " Expected " + ex);
  }

  // O(n) | 100%
  public static int arraySolution(int x, int[] a) {
    var freqs = new int[x + 1];
    var uniqueCount = 0;
    for (int i = 0; i < a.length; i++) {
      if (freqs[a[i]] == 0 && ++uniqueCount == x) {
        return i;
      }
      freqs[a[i]] = 1;
    }
    return -1;
  }

  // O(n) | 100%
  public static int setSolution(int x, int[] a) {
    var set = new HashSet<Integer>();
    int uniqueCount = 0;
    for (int i = 0; i < a.length; i++) {
      if (set.add(a[i]) && ++uniqueCount == x) {
        return i;
      }
    }
    return -1;
  }
}
