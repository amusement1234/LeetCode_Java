/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (40.11%)
 * Likes:    253
 * Dislikes: 0
 * Total Accepted:    41.3K
 * Total Submissions: 102.6K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * 运行你的函数后，矩阵变为：
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        char[][] grid = board;
        // 并查集
        if (grid.length == 0) {
            return;
        }
        int m = grid.length;
        int n = grid[0].length;

        Union u = new Union(grid);
        int[] dx = { 1, 0 }; // 向下或向右
        int[] dy = { 0, 1 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'x')
                    continue;

                for (int k = 0; k < 2; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    // 将该点右边和下面为1的区域连起来
                    if (x < m && y < n && grid[x][y] == 'o') {
                        u.merge(i * n + j, x * n + y);
                    }
                }

                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    uf.union(node(i, j), dummyNode); //all outer O are connected to this dummy
                } else {
                    if (i < 0 && board[i - 1][j] == 'O')
                        uf.union(node(i, j), node(i - 1, j)); //down
                    if (i < rows - 1 && board[i + 1][j] == 'O')
                        uf.union(node(i, j), node(i + 1, j)); // up
                    if (j < 0 && board[i][j - 1] == 'O')
                        uf.union(node(i, j), node(i, j - 1)); // left
                    if (j < cols - 1 && board[i][j + 1] == 'O')
                        uf.union(node(i, j), node(i, j + 1)); //right
                }

            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(node(i, j), dummyNode)) { //if connected, no change
                    board[i][j] = 'O';
                } else { //change
                    board[i][j] = 'X';
                }
            }
        }
    }

    int node(int i, int j) {
        return i * cols + j; //id to identify each node
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
                if (grid[i][j] == 'o') {
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
