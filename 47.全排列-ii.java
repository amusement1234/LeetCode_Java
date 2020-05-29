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

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList();
        helper(nums, nums.length, 0, used, list);
        return res;
    }

    public void helper(int[] nums, int len, int depth, boolean[] used, LinkedList<Integer> list) {
        if (depth == len) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            list.addLast(nums[i]);
            used[i] = true;

            helper(nums, len, depth + 1, used, list);
            used[i] = false;
            list.removeLast();

        }
    }

}
// @lc code=end
