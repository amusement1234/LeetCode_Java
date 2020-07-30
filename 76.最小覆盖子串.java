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
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character character = t.charAt(i);
            int thisVal = needs.getOrDefault(character, 0) + 1;
            needs.put(character, thisVal);
        }

        int left = 0;
        int right = 0;
        int match = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char temp = s.charAt(right);
            if (needs.containsKey(temp)) {
                window.put(temp, window.getOrDefault(temp, 0) + 1);
                if (window.get(temp).compareTo(needs.get(temp)) == 0) {
                    match++;
                }
            }

            right++;

            while (match == needs.size()) {
                if (right-left < minLen) {
                    start = left;
                    end = right;
                    minLen = end - start;
                }

                char c = s.charAt(left);
                if (needs.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 1) - 1);
                    if (window.get(c) < needs.get(c))
                        match--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end);

    }
}
// @lc code=end
