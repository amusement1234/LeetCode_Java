/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {

  public int searchInsert(int[] nums, int target) {
    // // 解法1：慢指针
    // int index = 0;
    // for (int i = 0; i < nums.length; i++) {
    //   if (nums[i] == target) {
    //     return i;
    //   }
    //   if (nums[i] > target) {
    //     break;
    //   }
    //   index++;
    // }
    // return index;

    // 解法2：二分搜索
    int n = nums.length;
    int left = 0, right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
// @lc code=end
