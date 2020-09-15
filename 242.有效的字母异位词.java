/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (56.14%)
 * Likes:    116
 * Dislikes: 0
 * Total Accepted:    51.4K
 * Total Submissions: 91.3K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start

class Solution {
    public boolean isAnagram(String s, String t) {

        // 解法3：hash
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap();

        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();

        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : chars2) {
            if (map.get(c) == null || map.get(c) == 0)
                return false;
            map.put(c, map.get(c) - 1);
        }
        return true;

        // // 解法2：字符数组计数
        // if (s.length() != t.length()) {
        //     return false;
        // }

        // int[] conter = new int[26];// 字母出现的次数，从0开始
        // for (int i = 0; i < s.length(); i++) {
        //     conter[s.charAt(i) - 'a']++;
        //     conter[t.charAt(i) - 'a']--;
        // }
        // for (int count : conter) {
        //     if (count != 0) {
        //         return false;
        //     }
        // }
        // return true;

        // // 解法1：排序
        // if (s.length() != t.length()) {
        //     return false;
        // }
        // char[] str1 = s.toCharArray();
        // char[] str2 = t.toCharArray();
        // Arrays.sort(str1);//array的排序用的是快排，快排的时间复杂度是O(nlogn)
        // Arrays.sort(str2);
        // return Arrays.equals(str1, str2);
    }
}

// @lc code=end