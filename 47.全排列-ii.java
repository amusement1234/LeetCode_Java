import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (58.31%)
 * Likes:    296
 * Dislikes: 0
 * Total Accepted:    59K
 * Total Submissions: 100.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList();
        boolean[] visited = new boolean[nums.length];

        helper(nums, 0, visited, new ArrayList(), res);
        return res;
    }

    public void helper(int[] nums, int level, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (level == nums.length) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            visited[i] = true;

            helper(nums, level + 1, visited, list, res);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
// @lc code=end
