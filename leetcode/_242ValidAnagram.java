import java.util.*;

class _242ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    var freqs = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      freqs.merge(s.charAt(i), 1, Integer::sum);
      freqs.merge(t.charAt(i), -1, Integer::sum);
    }
    for (var count : freqs.values()) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    test(new TestCase("anagram", "nagaram", true));
    test(new TestCase("rat", "car", false));
    test(new TestCase("december", "dec", false));
    test(new TestCase("", "", true));
  }

  private record TestCase(String s, String t, boolean expected) {
  }

  public static void test(TestCase tc) {
    var app = new _242ValidAnagram();
    var actual = app.isAnagram(tc.s, tc.t);
    System.out.print(actual == tc.expected ? "🟢 " : "🔴 ");
    System.out.println(tc + " actual: " + actual);
  }
}
