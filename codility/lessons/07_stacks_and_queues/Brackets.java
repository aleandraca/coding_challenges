import java.util.*;

// ### 🟢 Easy — Codility > Lessons > 7 Stacks and Queues > [Brackets](https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/)
public class Brackets {
  public static int solution(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> map = Map.of('[', ']', '(', ')', '{', '}');
    for (char bracket : s.toCharArray()) {
      if (map.containsKey(bracket)) {
        stack.push(map.get(bracket));
      } else if (stack.isEmpty() || stack.pop() != bracket) {
        return 0;
      }
    }
    return stack.isEmpty() ? 1 : 0;
  }

  public static void main(String[] args) {
    var inputs = Map.of("{[()()]}", 1, "([)()]", 0, ")(", 0, "{}[[[", 0);
    for (var entry : inputs.entrySet()) {
      var actual = solution(entry.getKey());
      System.out.println((entry.getValue() == actual ? "🟢" : "🔴")
          + " In -> " + entry.getKey() + " -> "
          + " Out " + actual
          + " Expected " + entry.getValue());
    }
  }
}
