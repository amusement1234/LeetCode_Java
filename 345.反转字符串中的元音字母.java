import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (50.08%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    41.3K
 * Total Submissions: 82K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> hashSet = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        char[] res = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!hashSet.contains(c1)) {
                res[left++] = c1;
            } else if (!hashSet.contains(c2)) {
                res[right--] = c2;
            } else {
                res[left++] = c2;
                res[right--] = c1;
            }
        }
        return new String(res);
    }
}
// @lc code=end
