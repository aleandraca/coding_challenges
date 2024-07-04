import java.util.*;

/**
 * Leetcode 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams
 */
public class Solution {
  public static void main(String[] args) {
    var strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
    var result = groupAnagrams(strs);
    System.out.println(result);
  }

  // Runtime: 6ms beats 97.96% O(n * m log m)
  // Memory: 47.33MB | Beats 90.55% O(n*m)
  public static List<List<String>> groupAnagrams(String[] strs) {
    var map = new HashMap<String, List<String>>();
    for (var str : strs) {
      var arr = str.toCharArray();
      Arrays.sort(arr);
      map.computeIfAbsent(new String(arr), k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
  }

}
