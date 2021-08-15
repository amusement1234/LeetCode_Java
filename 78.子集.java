import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.30%)
 * Likes:    418
 * Dislikes: 0
 * Total Accepted:    50.7K
 * Total Submissions: 67K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<Integer> t = new ArrayList();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 解法1：回溯
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(t));
            return;
        }

        //不选
        dfs(nums, cur + 1);

        //选
        t.add(nums[cur]);
        dfs(nums, cur + 1);
        t.remove(t.size() - 1);

    }
}
// @lc code=end
