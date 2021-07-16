import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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
        // // 解法1：柱状图优化
        // if (matrix.length == 0) {
        //     return 0;
        // }

        // int m = matrix.length, n = matrix[0].length;
        // int[][] left = new int[m][n];

        // int res = 0;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == '0') {
        //             continue;
        //         }
        //         left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;

        //         int width = left[i][j];
        //         for (int k = i; k >= 0; k--) {
        //             width = Math.min(width, left[k][j]);
        //             res = Math.max(res, width * (i - k + 1));
        //         }
        //     }
        // }
        // return res;

        // 解法2：单调栈 
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }

        int res = 0;

        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();

            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[i][j] <= left[stack.peek()][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = (down[i] - up[i] - 1);
                int area = height * left[i][j];
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
// @lc code=end
