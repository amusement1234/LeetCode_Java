/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        List<String> list = new ArrayList();
        backTrack(s, res, list, 0);
        return res;
    }

    private void backTrack(String s, List<List<String>> res, List<String> list, int index) {
        if (index == s.length()) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (!valid(s, index, i)) {
                continue;
            }

            list.add(s.substring(index, i + 1));
            backTrack(s, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean valid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
// @lc code=end
