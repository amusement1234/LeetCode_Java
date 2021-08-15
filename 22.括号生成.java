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
    public List<String> generateParenthesis(int n) {
        // 解法1：递归
        List<String> res = new ArrayList();
        helper(0, 0, n, "", res);
        return res;

        // 解法2：dp
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (String first : lists.get(j)) {
                    for (String second : lists.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(list);
        }

        return lists.get(lists.size() - 1);

    }

    public void helper(int left, int right, int n, String str, List<String> res) {
        //teminator
        if (left >= n && right >= n) {
            res.add(str);
            return;
        }
        //process result

        //drill down 
        if (left < n) {
            helper(left + 1, right, n, str + "(", res);
        }
        if (right < left) {
            helper(left, right + 1, n, str + ")", res);
        }
        //restore current status

    }

}
// @lc code=end
