import static java.lang.Character.isLetterOrDigit;

public class _125ValidPalindrome {

  // O(1) space complexity
  public static boolean solution1(String s) {
    int left = 0;
    int right = s.length() - 1;
    String str = s.toLowerCase();
    while (left < right) {
      while (left < right && !isLetterOrDigit(str.charAt(left))) {
        left++;
      }
      while (left < right && !isLetterOrDigit(str.charAt(right))) {
        right--;
      }
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  // O(n) space time complecity
  public static boolean solution2(String s) {
    var sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (isLetterOrDigit(c)) {
        sb.append(Character.toLowerCase(c));
      }
    }
    String clean = sb.toString();
    int n = clean.length();
    for (int i = 0; i < n / 2; i++) {
      if (clean.charAt(i) != clean.charAt(n - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    var isPalindome = solution2("A man, a plan, a canal: Panama.");
    System.out.println((isPalindome ? "🟢" : "🔴") + " Result " + isPalindome);
  }
}
