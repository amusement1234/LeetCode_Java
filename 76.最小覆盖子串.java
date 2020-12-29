import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (37.77%)
 * Likes:    565
 * Dislikes: 0
 * Total Accepted:    53.5K
 * Total Submissions: 141.8K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {

        //// 解法2：滑动窗口 https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
        // int[] map = new int[128];
        // for (char c : t.toCharArray()) {
        //     map[c]++;
        // }
        // int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        // while (end < s.length()) {
        //     final char c1 = s.charAt(end);
        //     if (map[c1] > 0)
        //         counter--;
        //     map[c1]--;
        //     end++;
        //     while (counter == 0) {
        //         if (minLen > end - start) {
        //             minLen = end - start;
        //             minStart = start;
        //         }
        //         final char c2 = s.charAt(start);
        //         map[c2]++;
        //         if (map[c2] > 0)
        //             counter++;
        //         start++;
        //     }
        // }

        // return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

        // 解法1：滑动窗口
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, start = 0, end = 0;
        int match = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).compareTo(needs.get(c)) == 0)
                    match++;
            }

            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    end = right;
                    minLen = end - start;
                }

                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.getOrDefault(c2, 1) - 1);
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }

                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end);

    }
}
// @lc code=end
