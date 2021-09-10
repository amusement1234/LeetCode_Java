import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n < 1) {
            return res;
        }
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
            res.add(arrToString(board));
            return;
        }
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (!valid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            dfs(board, row + 1, res);
            board[row][i] = '.';
        }
    }

    public boolean valid(char[][] board, int i, int j) {
        for (char[] chars : board) {
            if (chars[j] == 'Q') {
                return false;
            }
        }

        for (int a = i - 1, b = j - 1; a >= 0 && b >= 0; a--, b--) {
            if (board[a][b] == 'Q') {
                return false;
            }
        }
        int n = board.length;
        for (int a = i - 1, b = j + 1; a >= 0 && b <= n - 1; a--, b++) {
            if (board[a][b] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> arrToString(char[][] board) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
// @lc code=end
