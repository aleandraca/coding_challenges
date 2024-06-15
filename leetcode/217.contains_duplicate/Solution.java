import java.util.*;

public class Solution {
    public static void main(String[] args) {
      int[] nums = {1,1,1,3,3,4,3,2,4,2};
      var solution = hasDuplicate(nums);
      System.out.println(solution);
    }

    public static boolean hasDuplicate(int[] nums) {
      var set = new HashSet<Integer>();
      for (int num : nums) {
        if (!set.add(num)) {
          return true;
        }
      }
      return false;
    } 
}
