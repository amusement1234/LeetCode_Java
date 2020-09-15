/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.70%)
 * Likes:    396
 * Dislikes: 0
 * Total Accepted:    50.7K
 * Total Submissions: 213.7K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        //dp
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9)
                dp[i] += dp[i - 1];
            if (second >= 10 && second <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];

        // 方法一
        // if (s.charAt(0) == '0')
        //     return 0;
        // int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        // for (int i = 1; i < s.length(); i++) {
        //     int tmp = curr;
        //     if (s.charAt(i) == '0')
        //         if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
        //             curr = pre;
        //         else
        //             return 0;
        //     else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
        //         curr = curr + pre;
        //     pre = tmp;
        // }
        // return curr;

        // //方法二
        // return helper(s, 0);

    }

    private int helper(String s, int start) {
        if (start == s.length())
            return 1;
        if (s.charAt(start) == '0')
            return 0;
        int aa = helper(s, start + 1);
        int bb = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26)
                bb = helper(s, start + 2);
        }
        return aa + bb;

    }
}
// @lc code=end
