/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (46.53%)
 * Likes:    631
 * Dislikes: 0
 * Total Accepted:    32.7K
 * Total Submissions: 70K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */

// @lc code=start
class Solution {

  public int trap(int[] height) {
    // // 解法1：暴力
    // int res = 0;
    // int n = height.length;
    // for (int i = 1; i < n - 1; i++) {
    //   int max_left = 0, max_right = 0;
    //   for (int j = i; j < n; j++) {
    //     max_right = Math.max(max_right, height[j]);
    //   }
    //   for (int j = i; j >= 0; j--) {
    //     max_left = Math.max(max_left, height[j]);
    //   }
    //   res += Math.min(max_left, max_right) - height[i];
    // }
    // return res;

    // 解法2：双指针
    int left = 0, right = height.length - 1;
    int res = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= left_max) {
          left_max = height[left];
        } else {
          res += left_max - height[left];
        }
        left++;
      } else {
        if (height[right] >= right_max) {
          right_max = height[right];
        } else {
          res += right_max - height[right];
        }
        right--;
      }
    }
    return res;
  }
}
// @lc code=end
