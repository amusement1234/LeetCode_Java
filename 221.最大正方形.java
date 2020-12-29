/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (42.37%)
 * Likes:    453
 * Dislikes: 0
 * Total Accepted:    55.9K
 * Total Submissions: 131.5K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        // // 方法一：暴力法
        // int max = 0;
        // if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        //     return max;
        // }
        // int m = matrix.length, n = matrix[0].length;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == '1') {
        //             // 遇到一个 1 作为正方形的左上角
        //             max = Math.max(max, 1);
        //             // 计算可能的最大正方形边长
        //             int currentMaxSide = Math.min(m - i, n - j);
        //             for (int k = 1; k < currentMaxSide; k++) {
        //                 // 判断新增的一行一列是否均为 1
        //                 boolean flag = true;
        //                 if (matrix[i + k][j + k] == '0') {
        //                     break;
        //                 }
        //                 for (int m = 0; m < k; m++) {
        //                     if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
        //                         flag = false;
        //                         break;
        //                     }
        //                 }
        //                 if (flag) {
        //                     max = Math.max(max, k + 1);
        //                 } else {
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        // }
        // int maxSquare = max * max;
        // return maxSquare;

        // 方法二：动态规划
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;

    }
}
// @lc code=end
