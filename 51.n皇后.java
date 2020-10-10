/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (66.65%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    21.4K
 * Total Submissions: 31.9K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */

// @lc code=start
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0)
            return res;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
    }

    public void dfs(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!validate(board, row, i))
                continue;
            board[row][i] = 'Q';
            dfs(board, row + 1, res);
            board[row][i] = '.';
        }
    }

    public boolean validate(char[][] board, int row, int col) {
        for (char[] chars : board)
            if (chars[col] == 'Q')
                return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)//左上
            if (board[i][j] == 'Q')
                return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++)//右上
            if (board[i][j] == 'Q')
                return false;
        return true;
    }

    public List<String> charToString(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            res.add(new String(board[i]));
        return res;
    }
}

// @lc code=end
