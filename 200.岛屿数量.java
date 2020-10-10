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

    public int numIslands(char[][] grid) {
        // 解法1：dfs
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;

        // // // 解法2：并查集
        // if (grid.length == 0) {
        //     return 0;
        // }
        // int m = grid.length;
        // int n = grid[0].length;

        // Union u = new Union(grid);
        // int[] dx = { 1, 0 }; // 向下或向右
        // int[] dy = { 0, 1 };
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (grid[i][j] != '1')
        //             continue;

        //         for (int k = 0; k < 2; k++) {
        //             int x = i + dx[k];
        //             int y = j + dy[k];
        //             // 将该点右边和下面为1的区域连起来
        //             if (x < m && y < n && grid[x][y] == '1') {
        //                 u.merge(i * n + j, x * n + y);
        //             }
        //         }

        //     }
        // }
        // return u.getCount();

    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}

class Union {
    int[] parent; // 每个点的祖先
    int count;

    // 1.初始化，每个人的祖先就是它自己，自己自成一派
    public Union(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    count++;
                }
            }
        }
    }

    // 2.find，查找该点的祖先，并路径压缩一下
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 路径压缩，都直接指向祖先
        }
        return parent[x];
    }

    // 3.merge，祖先相同的不用merge，祖先不同的才merge
    public void merge(int x, int y) {
        if (find(x) != find(y)) {
            parent[find(x)] = find(y);
            count--;
        }
    }

    // 4.返回不同派系
    public int getCount() {
        return count;
    }
}
// @lc code=end
