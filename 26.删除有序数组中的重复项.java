/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {

  public int removeDuplicates(int[] nums) {
    // // 解法1：慢指针
    // int n = nums.length;
    // if (n < 2) {
    //   return n;
    // }
    // int index = 1;
    // for (int i = 1; i < n; i++) {
    //   if (nums[i] != nums[i - 1]) {
    //     nums[index++] = nums[i];
    //   }
    // }
    // return index;

    // 解法2：快慢指针
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    int slow = 1, fast = 1;
    while (fast < n) {
      if (nums[fast] != nums[fast - 1]) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }
}
// @lc code=end
