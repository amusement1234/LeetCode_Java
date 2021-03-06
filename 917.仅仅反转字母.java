import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 *
 * https://leetcode-cn.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (55.03%)
 * Likes:    52
 * Dislikes: 0
 * Total Accepted:    14.6K
 * Total Submissions: 26.3K
 * Testcase Example:  '"ab-cd"'
 *
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 
 * 
 * 示例 2：
 * 
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 
 * 
 * 示例 3：
 * 
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        // 解法1：
        StringBuilder sb = new StringBuilder();
        int end = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (!Character.isLetter(S.charAt(i))) {
                sb.append(S.charAt(i));
                continue;
            }

            while (!Character.isLetter(S.charAt(end)))
                end--;
            sb.append(S.charAt(end--));
        }
        return sb.toString();

    }
}
// @lc code=end
