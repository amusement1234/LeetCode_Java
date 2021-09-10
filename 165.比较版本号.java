/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        for (int i = 0; i < s1.length || i < s2.length; i++) {
            int x = 0;
            int y = 0;
            if (i < s1.length) {
                x = Integer.parseInt(s1[i]);
            }
            if (i < s2.length) {
                y = Integer.parseInt(s2[i]);
            }

            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;

    }
}
// @lc code=end
