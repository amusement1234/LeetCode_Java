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
        // this.n = n;
        // rows = new int[n];
        // hills = new int[4 * n - 1];
        // dales = new int[2 * n - 1];
        // queens = new int[n];

        // backtrack(0);
        // return output;

        //解法2
        if (n <= 0)
            return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board)
            Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }

    List<List<String>> res;

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 可选择列表: 第row行的所有列都是放置Q的选择
     * 结束条件: row超过board的最后一行
     *
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col))
                continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        // check is valid in col
        for (char[] chars : board)
            if (chars[col] == 'Q')
                return false;
        // check is valide upright
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // check is valide upleft
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }
    // int rows[];
    // // "hill" diagonals
    // int hills[];
    // // "dale" diagonals
    // int dales[];
    // int n;
    // // output
    // List<List<String>> output = new ArrayList();
    // // queens positions
    // int queens[];
    // public void backtrack(int row) {
    //     for (int col = 0; col < n; col++) {
    //         if (isNotUnderAttack(row, col)) {
    //             placeQueen(row, col);
    //             // if n queens are already placed
    //             if (row + 1 == n)
    //                 addSolution();
    //             // if not proceed to place the rest
    //             else
    //                 backtrack(row + 1);
    //             // backtrack
    //             removeQueen(row, col);
    //         }
    //     }
    // }

    // public boolean isNotUnderAttack(int row, int col) {
    //     int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
    //     return (res == 0) ? true : false;
    // }

    // public void placeQueen(int row, int col) {
    //     queens[row] = col;
    //     rows[col] = 1;
    //     hills[row - col + 2 * n] = 1; // "hill" diagonals
    //     dales[row + col] = 1; //"dale" diagonals
    // }

    // public void addSolution() {
    //     List<String> solution = new ArrayList<String>();
    //     for (int i = 0; i < n; ++i) {
    //         int col = queens[i];
    //         StringBuilder sb = new StringBuilder();
    //         for (int j = 0; j < col; ++j)
    //             sb.append(".");
    //         sb.append("Q");
    //         for (int j = 0; j < n - col - 1; ++j)
    //             sb.append(".");
    //         solution.add(sb.toString());
    //     }
    //     output.add(solution);
    // }

    // public void removeQueen(int row, int col) {
    //     queens[row] = 0;
    //     rows[col] = 0;
    //     hills[row - col + 2 * n] = 0;
    //     dales[row + col] = 0;
    // }

}

// @lc code=end
