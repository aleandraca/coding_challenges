import java.util.*;
import java.util.stream.*;

public class PermMissingElem {
  public static void main(String[] args) {
    test_solution_with(50_000);
  }

  // O(n) | 100%
  // With this sum approach the main issue is the int overflow
  // That's why we use long because the sum of 1..50,000 is more
  // than an int can hold, since the max for the problem is 100,000
  public static int solution(int[] a) {
    int n = a.length + 1;
    long total = n * (n + 1L) / 2; // Gauss's formula
    long sum = Arrays.stream(a).asLongStream().sum();
    return (int) (total - sum);
  }

  // O(n) | 100%
  // Using xor completely avoids the int overflow
  // Basically we xor the nummbers on the array and the sequence 1..n+1
  // at the end of adding/subtracting with xor the remaind is the one left.
  public static int xorSolution(int[] a) {
    int result = 0;
    for (int i = 0; i < a.length; i++) {
      result = result ^ a[i] ^ (i + 1);
    }
    return result ^ (a.length + 1);
  }

  public static int loopSolution(int[] a) {
    long total = 0;
    for (int i = 0; i <= a.length + 1; i++) {
      total += i;
    }
    for (int num : a) {
      total -= num;
    }
    return (int) total;
  }

  public static int compactSolution(int[] a) {
    long n = a.length + 1;
    return (int) (n * (n + 1) / 2) - IntStream.of(a).sum();
  }

  public static int arraySolution(int[] a) {
    var b = new boolean[a.length + 1];
    for (int num : a) {
      b[num - 1] = true;
    }
    for (int i = 0; i < b.length; i++) {
      if (!b[i]) {
        return i + 1;
      }
    }
    return 0;
  }

  public static void test_solution_with(int n) {
    List<Integer> a = IntStream.rangeClosed(1, n).boxed()
        .collect(Collectors.toCollection(LinkedList::new));
    int removed = new Random().nextInt(n);
    a.remove(removed);
    int ex = removed + 1;
    var array = a.stream().mapToInt(Integer::intValue).toArray();
    int actual = arraySolution(array);
    System.out.println((ex == actual ? "🟢" : "🔴") + " Result " + actual + " Expected " + ex);
  }
}
