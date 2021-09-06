/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        String number = "([+-]?(\\d+(\\.\\d*)?|(\\.\\d+)))";
        Pattern base = Pattern.compile(number + "([eE][+-]?\\d+)?");
        return base.matcher(s).matches();
    }
}
// @lc code=end

