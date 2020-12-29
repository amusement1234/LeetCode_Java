/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 *
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 *
 * algorithms
 * Hard (38.08%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    5K
 * Total Submissions: 12.9K
 * Testcase Example:  '[[1,0,1],[0,-2,3]]\n2'
 *
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * 
 * 示例:
 * 
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2 
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 
 * 
 * 说明：
 * 
 * 
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < matrix[0].length; l++) {
            int[] column = new int[matrix.length];
            for (int r = l; r < matrix[0].length; r++) {
                for (int i = 0; i < matrix.length; i++) {
                    column[i] += matrix[i][r];
                }
                res = Math.max(res, getMaxSum(column, k));
            }
        }
        return res;
    }

    /**
    * 获取一列小于k的最大和
    *
    * @param column
    * @param k
    * @return
    */
    private int getMaxSum(int[] column, int k) {
        // 优化求最大值
        int prev = column[0];
        int max = prev;
        for (int i = 1; i < column.length; i++) {
            prev = Math.max(column[i], prev + column[i]);
            max = Math.max(max, prev);
        }
        if (max <= k)
            return max;
        max = Integer.MIN_VALUE;
        for (int s = 0; s < column.length; s++) {
            int sum = 0;
            for (int t = s; t < column.length; t++) {
                sum += column[t];
                if (sum <= k && sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
// @lc code=end
