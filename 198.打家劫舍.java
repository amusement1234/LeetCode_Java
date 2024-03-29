/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 *
 * https://leetcode-cn.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (42.13%)
 * Likes:    584
 * Dislikes: 0
 * Total Accepted:    64.4K
 * Total Submissions: 151.9K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 2:
 * 
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        //不偷 dp[i][0]=Max(dp[i-1][0],dp[i-1][1])
        //偷 dp[i][1]=dp[i-1][0]+nums[i];
       
        // //解法1：DP方程 用二维数组
        // if (nums == null || nums.length == 0)
        //     return 0;
        // int count = nums.length;
        // int[][] arr = new int[count][2];
        // arr[0][0] = 0;//二维数组，0：不偷
        // arr[0][1] = nums[0];//1:偷

        // for (int i = 1; i < count; i++) {
        //     arr[i][0] = Math.max(arr[i - 1][0], arr[i - 1][1]);
        //     arr[i][1] = arr[i - 1][0] + nums[i];
        // }
        // return Math.max(arr[count - 1][0], arr[count - 1][1]);

        //  //解法2：
        //dp方程：0...i天 且nums[i]必偷的最大值 dp[i]=max(dp[i-1]+0,dp[i-2]+nums[i]);

        // if (nums == null || nums.length == 0)
        //     return 0;
        // if (nums.length == 1)
        //     return nums[0];

        // int n = nums.length;
        // int[] arr = new int[n];
        // arr[0] = nums[0];
        // arr[1] = Math.max(nums[0], nums[1]);
        // int res = arr[1];
        // for (int i = 2; i < nums.length; i++) {
        //     arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
        //     res = Math.max(res, arr[i]);
        // }
        // return res;

        
    }
}
// @lc code=end
