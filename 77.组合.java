import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (73.59%)
 * Likes:    266
 * Dislikes: 0
 * Total Accepted:    50.3K
 * Total Submissions: 68.4K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        //// 解法1：回溯
        // List<List<Integer>> res = new ArrayList();
        // helper(n, k, 1, new ArrayList<Integer>(), res);
        // return res;

        // 解法2：
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = 0;
        int[] p = new int[k];
        while (i >= 0) {
            p[i]++;
            if (p[i] > n) --i;
            else if (i == k - 1) result.add(Arrays.stream(p).boxed().collect(Collectors.toList()));
            else {
                ++i;
                p[i] = p[i - 1];
            }
        }
        return result;
    }

    public void helper(int n, int k, int start, List<Integer> val, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(val));
            return;
        }

        for (int i = start; i <= n; i++) {
            val.add(i);
            helper(n, k - 1, i + 1, val, res);
            val.remove(val.size() - 1);
        }
    }
}
// @lc code=end
