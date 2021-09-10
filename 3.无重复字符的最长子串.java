/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 解法1：滑动窗口
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;

        // // 解法2：官方题解
        // Map<Character, Integer> needs = new HashMap();
        // Map<Character, Integer> window = new HashMap();
        // int left = 0;
        // int right = 0;
        // int res = Integer.MIN_VALUE;
        // while (right < s.length()) {
        //     char temp = s.charAt(right);
        //     window.put(temp, window.getOrDefault(temp, 0) + 1);
        //     right++;

        //     while (window.get(temp) > 1) {
        //         char c = s.charAt(left);
        //         window.put(c, window.getOrDefault(c, 1) - 1);
        //         left++;
        //     }
        //     res = Math.max(res, right - left);
        // }

        // return res == Integer.MIN_VALUE ? 0 : res;
    }
}
// @lc code=end
