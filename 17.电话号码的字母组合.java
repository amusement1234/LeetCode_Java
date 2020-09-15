import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.48%)
 * Likes:    522
 * Dislikes: 0
 * Total Accepted:    64.9K
 * Total Submissions: 125.5K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {

    public List<String> letterCombinations(String digits) {
        // // 解法1：回溯
        // List<String> res = new ArrayList();
        // if (digits.length() == 0)
        //     return res;
        // backtrack("", digits, res);
        // return res;

        // // 解法2：回溯
        if (digits.length() == 0)
            return new ArrayList<String>();
        List<String> res = new ArrayList();
        backtrack2("", digits, 0, res);
        return res;
    }

    Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public void backtrack(String combination, String next, List<String> res) {
        if (next.length() == 0) {
            res.add(combination);
            return;
        }
        String letters = phone.get(next.substring(0, 1));
        for (int i = 0; i < letters.length(); i++) {
            backtrack(combination + letters.substring(i, i + 1), next.substring(1, next.length()), res);
        }
    }

    Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public void backtrack2(String combition, String digits, int thisIndex, List<String> res) {
        if (thisIndex == digits.length()) {
            res.add(combition);
            return;
        }
        String letters = map.get(digits.charAt(thisIndex));
        for (int i = 0; i < letters.length(); i++) {
            backtrack2(combition + letters.charAt(i), digits, thisIndex + 1, res);
        }
    }
}
// @lc code=end
