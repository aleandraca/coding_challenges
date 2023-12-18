public class SearchRotatedSortedArray{
  public static void main(String[] args) {
    int[][] test={
      {0,1,2,3,4,5,7,8,9},
      {9,0,1,2,3,4,5,7,8},
      {8,9,0,1,2,3,4,5,7},
      {7,8,9,0,1,2,3,4,5},
      {5,7,8,9,0,1,2,3,4},
      {4,5,7,8,9,0,1,2,3},
      {3,4,5,7,8,9,0,1,2},
      {2,3,4,5,7,8,9,0,1},
      {1,2,3,4,5,7,8,9,0}
    };
    var target = 3;
    for (var nums: test) {
      var k = findPivot(nums);
      if(target >= nums[k] && target <= nums[nums.length - 1])
        System.out.println(search(nums, k, nums.length - 1, target));
      else
        System.out.println(search(nums, 0, k, target));
    }
  }

  public static int findPivot(int[] nums){
    var left = 0;
    var right = nums.length - 1;
    var mid = 0;
    if(nums[left]<nums[right])
      return 0;
    while(left <= right){
      mid = (left + right) / 2;
      if(nums[mid] > nums[mid + 1])
        return mid + 1;
      if(nums[left] > nums[mid])
        right = mid - 1;
      else
        left = mid + 1;
    }
    return -1;
  }

  public static int search(int[] nums, int left, int right, int target) {
    while(left <= right){
      var mid = (left + right) / 2;
      if(nums[mid] == target)
        return mid;
      if(nums[mid] > target)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return -1;
  }
}
