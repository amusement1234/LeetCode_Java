import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (70.64%)
 * Likes:    203
 * Dislikes: 0
 * Total Accepted:    65.1K
 * Total Submissions: 91.5K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 
 * 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == ' ')
                continue;
            int j = i;
            while (j + 1 < ca.length && ca[j + 1] != ' ')
                j++; // move j to the end of the word
            reverse(ca, i, j);
            i = j;

        }
        return new String(ca);

        // 解法一
        // StringBuilder sb = new StringBuilder();
        // int i = 0;
        // int j = 0;
        // while (i < s.length()) {
        //     while (i < s.length() && s.charAt(i) != ' ')
        //         i++;
        //     sb.append(swap(s.substring(j, i)) + " ");

        //     while (i < s.length() && s.charAt(i) == ' ')
        //         i++;
        //     j = i;
        // }
        // return sb.toString().trim();
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    private String swap(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
// @lc code=end
