/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {

        // // 解法1：
        // if (n == 0 || n == 1)
        // return 1;
        // int ans = 0;
        // for (int i = 1; i <= n; i++) {
        // ans += numTrees(i - 1) * numTrees(n - i);
        // }
        // return ans;

        // 解法2：
        int[] memo = new int[n + 1];
        memo[0] = 1;
        return helper(n, memo);

        // // 解法3：dp 不懂
        // int[] dp = new int[n + 1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     for (int j = 1; j <= i; j++) {
        //         dp[i] += dp[j - 1] * dp[i - j];
        //     }
        // }
        // return dp[n];
    }

    public int helper(int n, int[] memo) {
        if (n <= 1)
            return 1;
        if (memo[n] > 0)
            return memo[n];
        for (int i = 1; i <= n; i++) {
            memo[n] += helper(i - 1, memo) * helper(n - i, memo);
        }
        return memo[n];
    }

}
// @lc code=end
