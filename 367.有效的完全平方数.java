/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (43.36%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    33.7K
 * Total Submissions: 77.7K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid * mid == num)
                return true;
            if ((long) mid * mid > num)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (long) right * right == num;
    }
}
// @lc code=end
