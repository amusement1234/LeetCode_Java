/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (43.32%)
 * Likes:    359
 * Dislikes: 0
 * Total Accepted:    38.4K
 * Total Submissions: 88.3K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 
 * 说明:
 * 
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 
 * 
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {

        // 解法一：递归
        // int memo[][] = new int[nums.length + 1][nums.length];
        // for (int[] l : memo) {
        //     Arrays.fill(l, -1);
        // }
        // return lengthofLIS(nums, -1, 0, memo);

        // // 解法二：dp
        // if (nums.length == 0)
        //     return 0;
        // int[] dp = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     dp[i] = 1;
        // }
        // int res = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] > nums[j])
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //     }
        //     res = Math.max(res, dp[i]);
        // }
        // return res;

        // 解法三：dp+二分
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                ++size;
        }
        return size;
    }

    public int lengthofLIS(int[] nums, int pre, int cur, int[][] memo) {
        if (cur == nums.length)
            return 0;

        if (memo[pre + 1][cur] >= 0)
            return memo[pre + 1][cur];

        int taken = 0;
        if (pre < 0 || nums[cur] > nums[pre])
            taken = 1 + lengthofLIS(nums, cur, cur + 1, memo);

        int nottaken = lengthofLIS(nums, pre, cur + 1, memo);
        memo[pre + 1][cur] = Math.max(taken, nottaken);
        return memo[pre + 1][cur];
    }
}
// @lc code=end
