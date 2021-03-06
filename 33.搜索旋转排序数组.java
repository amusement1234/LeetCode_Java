/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.19%)
 * Likes:    457
 * Dislikes: 0
 * Total Accepted:    62.8K
 * Total Submissions: 173.3K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 *
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */

// @lc code=start
class Solution {

  public int search(int[] nums, int target) {
    // // 解法1：
    // int lo = 0;
    // int hi = nums.length - 1;

    // while (lo < hi) {
    //   int mid = (lo + hi) / 2;
    //   // 当[0,mid]有序时,向后规约条件
    //   if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
    //     lo = mid + 1;
    //     // 当[0,mid]发生旋转时，向后规约条件
    //   } else if (target > nums[mid] && target < nums[0]) {
    //     lo = mid + 1;
    //   } else {
    //     hi = mid;
    //   }
    // }
    // return lo == hi && nums[lo] == target ? lo : -1;

    // 解法2：二分查找
    int n = nums.length;
    int left = 0, right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[0] <= nums[mid]) {
        if (nums[0] <= target && target <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}
// @lc code=end
