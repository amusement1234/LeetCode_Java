/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (46.25%)
 * Likes:    514
 * Dislikes: 0
 * Total Accepted:    34.3K
 * Total Submissions: 72.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int maxarea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    continue;

                // compute the maximum width and update dp with it
                dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                int width = dp[i][j];

                // compute the maximum area rectangle with a lower right corner at [i, j]
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    maxarea = Math.max(maxarea, width * (i - k + 1));
                }

            }
        }
        return maxarea;

    }
}
// @lc code=end
