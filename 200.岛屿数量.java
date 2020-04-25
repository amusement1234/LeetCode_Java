/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.63%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    36K
 * Total Submissions: 78.8K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] dx = { -1, 1, 0, 0 };//下钻，横向的向量
    int[] dy = { 0, 0, -1, 1 };//下钻，纵向的向量
    char[][] g;//全局变量，方便调用

    public int numIslands(char[][] grid) {

        //方法2.
        g = grid;
        if (g == null || g.length == 0)
            return 0;
        int gridCount = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '1')
                    gridCount += helper(i, j);
            }

        }
        return gridCount;

        //方法1
        // if (grid == null || grid.length == 0) {
        //     return 0;
        // }

        // int nr = grid.length;
        // int nc = grid[0].length;
        // int num_islands = 0;
        // for (int r = 0; r < nr; ++r) {
        //     for (int c = 0; c < nc; ++c) {
        //         if (grid[r][c] == '1') {
        //             ++num_islands;
        //             dfs(grid, r, c);
        //         }
        //     }
        // }

        // return num_islands;
    }

    private int helper(int i, int j) {
        if (g[i][j] == '0')
            return 0;
        g[i][j] = '0';
        for (int k = 0; i < dx.length; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= g.length || y >= g[i].length)
                continue;
            if (g[x][y] == '0')
                continue;
            helper(x, y);
        }
        return 1;
    }

    // void dfs(char[][] grid, int r, int c) {
    //     int nr = grid.length;
    //     int nc = grid[0].length;

    //     if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
    //         return;
    //     }

    //     //遇到岛，就夷为平地
    //     grid[r][c] = '0';
    //     dfs(grid, r - 1, c);
    //     dfs(grid, r + 1, c);
    //     dfs(grid, r, c - 1);
    //     dfs(grid, r, c + 1);
    // }
}
// @lc code=end
