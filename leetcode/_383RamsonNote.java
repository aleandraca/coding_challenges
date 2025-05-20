import java.util.*;

public class _383RamsonNote {
  public static boolean canConstruct(String ramsonNote, String magazine) {
    var magMap = new HashMap<Character, Integer>();
    for (char c : magazine.toCharArray()) {
      magMap.merge(c, 1, Integer::sum);
    }
    for (char c : ramsonNote.toCharArray()) {
      int count = magMap.getOrDefault(c, 0);
      if (count > 0) {
        magMap.put(c, count - 1);
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    test(new Inputs("a", "b"), false);
    test(new Inputs("aa", "ab"), false);
    test(new Inputs("aa", "aab"), true);
  }

  public static void test(Inputs in, boolean expected) {
    var actual = canConstruct(in.ransomNote, in.magazine);
    System.out.println((expected == actual ? "🟢" : "🔴")
    + in + "\n  ↪️"
    + " Out " + actual + " | Expected " + expected);
  }

  private record Inputs(String ransomNote, String magazine) {}
}
