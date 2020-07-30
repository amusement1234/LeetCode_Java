/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (37.23%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    81.4K
 * Total Submissions: 218.3K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {

        // 方法一
        if (x == 0 || x == 1)
            return x;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return right;

        //方法2
        // // 注意：针对特殊测试用例，例如 2147395599
        // // 要把搜索的范围设置成长整型
        // // 为了照顾到 0 把左边界设置为 0
        // long left = 0;
        // // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        // long right = x / 2 + 1;
        // while (left < right) {
        //     // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
        //     // long mid = left + (right - left + 1) / 2;
        //     long mid = (left + right + 1) >>> 1;
        //     long square = mid * mid;
        //     if (square > x) {
        //         right = mid - 1;
        //     } else {
        //         left = mid;
        //     }
        // }
        // // 因为一定存在，因此无需后处理
        // return (int) left;

    }
}
// @lc code=end
