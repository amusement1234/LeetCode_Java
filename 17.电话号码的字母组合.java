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
    // 解法1：回溯
    if (digits == null || digits.length == 0) {
      return new ArrayList();
    }

    Map<Character, String> map = new HashMap<Character, String>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    List<String> res = new LinkedList<String>();
    search("", digits, 0, res, map);
    return res;
  }

  private void search(String s, String digits, int i, List<String> res, Map<Character, String> map) {
    //terminator
    if (i == digits.length()) {
      res.add(s);
      return;
    }
    //process
    String letters = map.get(digits.charAt(i));
    for (int j = 0; j < letter.length(); j++) {
      //drill down
      search(s + letter.charAt(j), digits, i + 1, res, map);
    }
  }
}
// @lc code=end
