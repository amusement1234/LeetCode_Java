import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (62.50%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 53.3K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        // // 解法1：记忆化递归 
        // int n = triangle.size();
        // memo = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(memo[i], -1);
        // }
        // return dfs(triangle, 0, 0);

        // 解法2：dp
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    
    }

    public int dfs(List<List<Integer>> triangle, int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == triangle.size() - 1) {
            memo[i][j] = triangle.get(i).get(j);
            return memo[i][j];
        }
        int left = dfs(triangle, i + 1, j);
        int right = dfs(triangle, i + 1, j + 1);
        memo[i][j] = Math.min(left, right) + triangle.get(i).get(j);
        return memo[i][j];
    }
     

}
// @lc code=end
