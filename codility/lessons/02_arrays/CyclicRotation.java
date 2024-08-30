import java.util.Arrays;

/**
 * Codility Lesson 2 / Arrays / CyclicRotation
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * The simplest O(n) solution is to use modular arithmetic so we can wrap around
 * when we reach the length of the array, especially useful when k > n.
 * I also included another less performant solution O(n*k).
 */
public class CyclicRotation {
  public static void main(String[] args) {
    // A tricky scenario when k > length of the array.
    var a = new int[] { 8, 5, 2 };
    int k = 4;
    System.out.println(Arrays.toString(a) + " -> "
        + Arrays.toString(solution1(a, k)));
  }

  // 100% O(n) Making use of modular arithmetic
  public static int[] solution1(int[] a, int k) {
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
  public static int[] solution2(int[] a, int k) {
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
}
