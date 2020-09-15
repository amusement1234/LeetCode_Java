import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.64%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    32.6K
 * Total Submissions: 55.5K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // 解法2：字符数组计数
        if (strs == null || strs.length == 0)
            return null;
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray())
                ca[c - 'a']++;
            String key = String.valueOf(ca);
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());

        // // 解法1：字符串排序
        // if (strs == null || strs.length == 0)
        //     return null;

        // Map<String, List> map = new HashMap();
        // for (int i = 0; i < strs.length; i++) {
        //     char[] ca = strs[i].toCharArray();
        //     Arrays.sort(ca);
        //     String key = String.valueOf(ca);
        //     if (!map.containsKey(key))
        //         map.put(key, new ArrayList());
        //     map.get(key).add(strs[i]);
        // }
        // return new ArrayList(map.values());
    }
}
// @lc code=end
