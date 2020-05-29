import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (46.95%)
 * Likes:    692
 * Dislikes: 0
 * Total Accepted:    98.6K
 * Total Submissions: 209.2K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {

    public int climbStairs(int n) {
        // // 方法一：暴力法
        // return climb_Stairs(0, n);

        // // 方法二：记忆化递归
        // int memo[] = new int[n + 1];
        // return climb_Stairs(0, n, memo);

        // // 方法三：动态规划
        // if (n == 1) {
        //     return 1;
        // }
        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        //方法四：斐波那契数
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;

        // //1.暴力法，设置map存储
        // if (n < 3) {
        //     return n;
        // }

        // Map<Integer, Integer> map = new HashMap();
        // int result1 = 0;
        // if (map.containsKey(n - 1)) {
        //     result1 = map.get(n - 1);
        // } else {
        //     result1 = climbStairs(n - 1);
        //     map.put(n - 1, result1);
        // }

        // int result2 = 0;
        // if (map.containsKey(n - 2)) {
        //     result2 = map.get(n - 2);
        // } else {
        //     result2 = climbStairs(n - 2);
        //     map.put(n - 2, result2);
        // }

        // return result1 + result2;
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public int climb_Stairs(int i, int n, int[] memo) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
// @lc code=end
