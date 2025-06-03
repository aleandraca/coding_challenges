import java.util.*;

class Shrooms {
  public static void main(String[] args) {
    int[] a = { 2, 3, 7, 5, 1, 3, 9 };
    assertThat(solution(a, 4, 6), 25);
  }

  public static int solution(int[] a, int k, int m) {
    System.out.println("a = " + Arrays.toString(a) + " k:" + k + " m = " + m);
    for (int i = 0; i < a.length; i++) {

    }
    return 0;
  }

  private static void assertThat(int actual, int expected) {
    System.out.println((actual == expected ? "🟢" : "🔴")
        + " Result " + actual
        + " Expected " + expected);
  }

}
