/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (48.06%)
 * Likes:    1464
 * Dislikes: 0
 * Total Accepted:    139.7K
 * Total Submissions: 287.7K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        //方法2：DP
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;

        // 方法1：贪心
        // int current = nums[0];
        // int maxSum = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     current = Math.max(nums[i], current + nums[i]);
        //     maxSum = Math.max(current, maxSum);
        // }

        // return maxSum;
    }
}
// @lc code=end
