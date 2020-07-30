import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (44.27%)
 * Likes:    319
 * Dislikes: 0
 * Total Accepted:    32.2K
 * Total Submissions: 71.1K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 
 * 说明：
 * 
 * 
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 
 * 输出:
 * [0, 6]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * s: "abab" p: "ab"
 * 
 * 输出:
 * [0, 1, 2]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++)
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0) + 1);

        List<Integer> res = new ArrayList();
        int right = 0;
        int match = 0;
        int left = 0;
        while (right < s.length()) {
            char temp = s.charAt(right);
            if (needs.containsKey(temp)) {
                window.put(temp, window.getOrDefault(temp, 0) + 1);
                if (window.get(temp).compareTo(needs.get(temp)) == 0)
                    match++;
            }
            right++;

            while (match == needs.size()) {
                if (right - left == p.length())
                    res.add(left);
                char c = s.charAt(left);
                if (needs.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 1) - 1);
                    if (window.get(c) < needs.get(c))
                        match--;
                }
                left++;
            }
        }
        return res;
    }
}
// @lc code=end
