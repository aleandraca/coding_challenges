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

  // O(n) array-based | 100%
  public static int arraySolution(int x, int[] a) {
    var leaves = new boolean[x + 1];
    int uniqueLeaves = 0;
    for (int i = 0; i < a.length; i++) {
      if (!leaves[a[i]] && ++uniqueLeaves == x) {
        return i;
      }
      leaves[a[i]] = true;
    }
    return -1;
  }

  // O(n) set-based | 100%
  public static int setSolution(int x, int[] a) {
    var set = new HashSet<Integer>();
    for (int i = 0; i < a.length; i++) {
      set.add(a[i]);
      if (set.size() == x) {
        return i;
      }
    }
    return -1;
  }
}
