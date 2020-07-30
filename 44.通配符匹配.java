/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 *
 * https://leetcode-cn.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (27.69%)
 * Likes:    476
 * Dislikes: 0
 * Total Accepted:    47.6K
 * Total Submissions: 153.4K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 
 * 
 * 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {

        //解法2：dp
        // int len1 = p.length(), len2 = s.length();
        // boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        // dp[0][0] = true;
        // for (int i = 1; i <= len1; i++) {
        //     if (p.charAt(i - 1) != '*') {
        //         break;
        //     }
        //     dp[i][0] = true;
        // }

        // for (int i = 1; i <= len1; i++) {
        //     for (int j = 1; j <= len2; j++) {
        //         if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
        //             dp[i][j] = dp[i - 1][j - 1];
        //         } else if (p.charAt(i - 1) == '*') {
        //             dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        //         }
        //     }
        // }
        // return dp[len1][len2];

        // 解法一：
        String pattern = p;
        int s1 = 0, p1 = 0, match = 0, starIdx = -1;
        while (s1 < s.length()) {
            // advancing both pointers
            if (p1 < pattern.length() && (pattern.charAt(p1) == '?' || s.charAt(s1) == pattern.charAt(p1))) {
                s1++;
                p1++;
            }
            // * found, only advancing pattern pointer
            else if (p1 < pattern.length() && pattern.charAt(p1) == '*') {
                starIdx = p1;
                match = s1;
                p1++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p1 = starIdx + 1;
                match++;
                s1 = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else
                return false;
        }

        //check for remaining characters in pattern
        while (p1 < pattern.length() && pattern.charAt(p1) == '*')
            p1++;

        return p1 == pattern.length();
    }
}
// @lc code=end
