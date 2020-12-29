/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 *
 * https://leetcode-cn.com/problems/frog-jump/description/
 *
 * algorithms
 * Hard (36.98%)
 * Likes:    101
 * Dislikes: 0
 * Total Accepted:    8.7K
 * Total Submissions: 23.4K
 * Testcase Example:  '[0,1,3,4,5,7,9,10,12]'
 *
 * 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
 * 
 * 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时，
 * 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
 * 
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。
 * 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * 
 * 请注意：
 * 
 * 
 * 石子的数量 ≥ 2 且 < 1100；
 * 每一个石子的位置序号都是一个非负整数，且其 < 2^31；
 * 第一个石子的位置永远是0。
 * 
 * 
 * 示例 1:
 * 
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * 总共有8个石子。
 * 第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置,
 * 第三个石子在序号为3的单元格的位置， 以此定义整个数组...
 * 最后一个石子处于序号为17的单元格的位置。
 * 
 * 返回 true。即青蛙可以成功过河，按照如下方案跳跃： 
 * 跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着 
 * 跳2个单位到第4块石子, 然后跳3个单位到第6块石子, 
 * 跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。
 * 
 * 
 * 示例 2:
 * 
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * 返回 false。青蛙没有办法过河。 
 * 这是因为第5和第6个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {

        // // 解法1：
        // // https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations
        // if (stones.length == 0)
        //     return true;

        // HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        // map.put(0, new HashSet<Integer>());
        // map.get(0).add(1);
        // for (int i = 1; i < stones.length; i++) {
        //     map.put(stones[i], new HashSet<Integer>());
        // }

        // for (int i = 0; i < stones.length - 1; i++) {
        //     int stone = stones[i];
        //     for (int step : map.get(stone)) {
        //         int reach = step + stone;
        //         if (reach == stones[stones.length - 1]) {
        //             return true;
        //         }
        //         HashSet<Integer> set = map.get(reach);
        //         if (set != null) {
        //             set.add(step);
        //             if (step - 1 > 0)
        //                 set.add(step - 1);
        //             set.add(step + 1);
        //         }
        //     }
        // }

        // return false;

        // 解法2：dp
        if (stones[1] != 1)
            return false;

        int len = stones.length;

        boolean[][] dp = new boolean[len][len + 1];
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= j + 1) {
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                    //提前结束循环直接返回结果
                    if (i == len - 1 && dp[i][k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
// @lc code=end
