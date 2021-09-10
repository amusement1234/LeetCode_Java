/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 *
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/description/
 *
 * algorithms
 * Medium (33.00%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    8.9K
 * Total Submissions: 26.2K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * 
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * 
 * 
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 
 * 
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[0,1],[1,0]]
 * 
 * 输出：2
 * 
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 * 
 * 输出：4
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 解法1：bfs
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1 ||grid[m-1][n-1]==1){
            return -1;
        }

        boolean[][] visited=new boolean[m][n];
        visited[0][0]=true;

        Queue<int[]> queue=new LinkedList();
        queue.offer(new int[]{0,0});

        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        int res=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur=queue.poll();
                if(cur[0]==m-1 && cur[1]==n-1){
                    return res+1;
                }

                for (int k = 0; k < 8; k++) {
                    int x=cur[0]+dir[k][0];
                    int y=cur[1]+dir[k][1];
                    
                    if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && grid[x][y]==0){
                        queue.offer(new int[]{x,y});
                        visited[x][y]=true;
                    }
                }
            }
            res++;
        }
        return -1;

    }
}
// @lc code=end
