/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (33.42%)
 * Likes:    231
 * Dislikes: 0
 * Total Accepted:    43.1K
 * Total Submissions: 128.7K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        // 解法2：
        if (n == 0)
            return 1.0;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);

        // // 解法1：递归 
        // if (n < 0) {
        //     n = -n;
        //     x = 1 / x;
        // }
        // return fastPow(x, n);

    }

    private double fastPow(double x, int n) {
        //分治
        //x^n ---> 2^10 -> 2^5 ->(2^2)*2

        //1、terminator 终止条件
        if (n == 0) {
            return 1.0;
        }

        //2、process. split problem

        //3. drill down, merge
        double half = fastPow(x, n / 2);
        //merge
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

        //4.reverse status
    }

}
// @lc code=end
