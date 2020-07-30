/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (46.90%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    37.5K
 * Total Submissions: 79.7K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // // 解法一：迭代
        // if(n<=0)return false;
        // while(n%2==0){
        //     n=n/2;
        // }
        // return n==1;

        // // 解法二：递归 
        // if (n <= 0)
        //     return false;
        // if (n == 1)
        //     return true;
        // if (n % 2 != 0)
        //     return false;
        // return isPowerOfTwo(n / 2);
        // // return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo(n/2)));

        //解法三：位运算
        return n > 0 && (n & (n - 1)) == 0;

        // // 解法四：
        // return n > 0 && Integer.bitCount(n) == 1;
    }
}
// @lc code=end
