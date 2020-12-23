import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (71.96%)
 * Likes:    287
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 23.6K
 * Testcase Example:  '"2-1-1"'
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及
 * * 。
 * 
 * 示例 1:
 * 
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * 示例 2:
 * 
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 */

// @lc code=start
class Solution {
    HashMap<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (memo.containsKey(input))
            return memo.get(input);

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '+' && c != '-' && c != '*')
                continue;

            //分。以运算符为中心，分割成两个字符串，分别递归计算
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));

            //治。通过子问题的结果，合成原问题的结果
            for (int a : left)
                for (int b : right) {
                    if (c == '+')
                        res.add(a + b);
                    if (c == '-')
                        res.add(a - b);
                    if (c == '*')
                        res.add(a * b);
                }
        }

        if (res.isEmpty())
            res.add(Integer.parseInt(input));
        memo.put(input, res);
        return res;
    }
}
// @lc code=end
