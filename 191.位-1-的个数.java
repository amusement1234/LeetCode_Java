/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 *
 * https://leetcode-cn.com/problems/number-of-1-bits/description/
 *
 * algorithms
 * Easy (60.18%)
 * Likes:    109
 * Dislikes: 0
 * Total Accepted:    37.4K
 * Total Submissions: 60.6K
 * Testcase Example:  '00000000000000000000000000001011'
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 
 * 
 * 示例 2：
 * 
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 
 * 
 * 示例 3：
 * 
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 请注意，在某些语言（如
 * Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 * 
 * 
 * 
 * 
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 * 
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            n=n&(n-1); 
            res++;             
        }
        return res;




        // // //解法1：循环和位移动
        // // int count = 0;
        // // int mask = 1;
        // // for (int i = 0; i < 32; i++) {
        // //     if ((mask & n) != 0)
        // //         count++;
        // //     mask <<= 1;//mask乘以2
        // // }
        // // return count;

        // //解法2：位操作的小技巧
        // int count = 0;
        // while (n != 0) {
        //     n = n & (n - 1);//消除最低位的1
        //     count++;
        // }
        // return count;

        // // //解法3：类库
        // // return Integer.bitCount(n);
    }
}
// @lc code=end
