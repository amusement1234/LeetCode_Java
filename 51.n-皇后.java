/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
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
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> charToString(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;

    }
}
// @lc code=end
