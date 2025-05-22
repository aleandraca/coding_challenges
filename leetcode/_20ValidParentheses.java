import java.util.*;

// ### 🟢 Easy —  [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
public class _20ValidParentheses {
  public static boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char bracket : s.toCharArray()) {
      switch (bracket) {
        case '[' -> stack.push(']');
        case '(' -> stack.push(')');
        case '{' -> stack.push('}');
        case ']', ')', '}' -> {
          if (stack.isEmpty() || stack.pop() != bracket) {
            return false;
          }
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    var inputs = Map.of("{[()()]}", true, "([)()]", false, ")(", false, "{}[[[", false);
    for (var entry : inputs.entrySet()) {
      var actual = isValid(entry.getKey());
      System.out.println((entry.getValue() == actual ? "🟢" : "🔴")
          + " In -> " + entry.getKey() + " -> "
          + " Out " + actual
          + " | Expected " + entry.getValue());
    }
  }
}
