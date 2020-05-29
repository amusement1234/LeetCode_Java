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

        // // 方法一：回溯
        // if (digits.length() == 0)
        //     return output;
        // backtrack("", digits);
        // return output;

        // 方法二：回溯
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

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
        List<String> res = new LinkedList<>();

        search("", 0, digits, res, map);
        return res;
    }

    private void search(String thisStr, int thisIndex, String digits, List<String> res, Map<Character, String> map) {
        if (thisIndex == digits.length()) {
            res.add(thisStr);
            return;
        }

        String letters = map.get(digits.charAt(thisIndex));
        for (int j = 0; j < letters.length(); j++) {
            search(thisStr + letters.charAt(j), thisIndex + 1, digits, res, map);
        }
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

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
            return;
        }

        String digit = next_digits.substring(0, 1);//2
        String letters = phone.get(digit);//abc
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);
            backtrack(combination + letter, next_digits.substring(1));
        }

    }

}
// @lc code=end
