import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        for (String str : path.split("/")) {
            if (str.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else if (!str.isEmpty() && !str.equals(".")) {
                deque.push(str);
            }
        }

        String res = "";
        while (!deque.isEmpty()) {
            res = "/" + deque.pop() + res;
        }

        return res.isEmpty() ? "/" : res;

    }
}
// @lc code=end
