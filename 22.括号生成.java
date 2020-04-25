import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.47%)
 * Likes:    662
 * Dislikes: 0
 * Total Accepted:    61.1K
 * Total Submissions: 84.2K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        geneHelper(0, 0, n, "");
        return list;
    }

    public void geneHelper(int left, int right, int n, String s) {
        //teminator
        if (left >= n && right >= n) {
            list.add(s);
            return;
        }
        //process result

        //drill down 
        if (left < n)
            geneHelper(left + 1, right, n, s + "(");

        if (right < left)
            geneHelper(left, right + 1, n, s + ")");

        //restore current status

    }
}
// @lc code=end
