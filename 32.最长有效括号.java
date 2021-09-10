import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.38%)
 * Likes:    386
 * Dislikes: 0
 * Total Accepted:    27.6K
 * Total Submissions: 96.4K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {

        // // 解法1：
        // int max = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     int leftCount = 0;
        //     for (int j = i; j < s.length(); j++) {
        //         if (s.charAt(j) == '(') {
        //             leftCount++;
        //         } else {
        //             leftCount--;
        //         }
        //         if (leftCount < 0) {
        //             break;
        //         }
        //         if (leftCount == 0 && j - i + 1 > max) {
        //             max = j - i + 1;
        //         }
        //     }
        // }
        // return max;

        // 解法2：stack
        int max = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;

        // //方法3：dp
        // int[] dp = new int[s.length()];
        // int max = 0;
        // int leftCount = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(')
        //         leftCount++;
        //     else if (leftCount > 0) {
        //         dp[i] = dp[i - 1] + 2;
        //         dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
        //         max = Math.max(max, dp[i]);
        //         leftCount--;
        //     }
        // }
        // return max;

    }
}
// @lc code=end
