/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //加上自己，向后移位一次，看看是否包含
        String str=s+s;
        return str.substring(1,str.length()-1).contains(s);
    }
}
// @lc code=end

