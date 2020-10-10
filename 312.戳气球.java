/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 *
 * https://leetcode-cn.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (60.08%)
 * Likes:    335
 * Dislikes: 0
 * Total Accepted:    14.3K
 * Total Submissions: 23.4K
 * Testcase Example:  '[3,1,5,8]'
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的
 * left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 
 * 求所能获得硬币的最大数量。
 * 
 * 说明:
 * 
 * 
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * 示例:
 * 
 * 输入: [3,1,5,8]
 * 输出: 167 
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 * 
 */

// @lc code=start
class Solution {

    public int maxCoins(int[] nums) {
        // 解法1：递归
        int[] arr = new int[nums.length + 2];//arr:nums首尾加上1
        int n = 1;
        for (int x : nums)
            if (x > 0)
                arr[n++] = x;
        arr[0] = arr[n++] = 1;

        int[][] memo = new int[n][n];
        return helper(memo, arr, 0, n - 1);

        // 解法2：dp
        // int[] arr = new int[nums.length + 2];
        // int n = 1;
        // for (int x : nums)
        //     if (x > 0)
        //         arr[n++] = x;
        // arr[0] = arr[n++] = 1;

        // int[][] dp = new int[n][n];
        // for (int k = 2; k < n; k++)//k[2,n)
        //     for (int left = 0; left < n - k; left++) {//left[0,n-k)
        //         int right = left + k;
        //         for (int i = left + 1; i < right; i++)//i[left+1,left + k]
        //             dp[left][right] = Math.max(dp[left][right],
        //                     arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]);
        //     }

        // return dp[0][n - 1];
    }

    public int helper(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right)
            return 0;
        if (memo[left][right] > 0)
            return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans,
                    nums[left] * nums[i] * nums[right] + helper(memo, nums, left, i) + helper(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

}
// @lc code=end
