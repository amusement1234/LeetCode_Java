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

    List<List<Integer>> output = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {

        // // 方法一：递归
        // List<List<Integer>> output = new ArrayList<>();
        // output.add(new ArrayList<Integer>());

        // for (int num : nums) {
        //     List<List<Integer>> newSubsets = new ArrayList<>();
        //     for (List<Integer> list : output) {
        //         List<Integer> curr = new ArrayList<Integer>(list);
        //         curr.add(num);
        //         newSubsets.add(curr);
        //     }

        //     output.addAll(newSubsets);
        // }
        // return output;

        // 方法二：回溯
        for (int k = 0; k < nums.length + 1; ++k) {
            backtrack(k, 0, new ArrayList<Integer>(), nums);
        }
        return output;

        // 方法三：回溯
        // List<List<Integer>> list = new ArrayList<>();
        // if (nums == null)
        //     return list;

        // dfs(list, nums, new ArrayList<Integer>(), 0);
        // return list;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> thisList, int index) {
        if (nums.length == index) {
            result.add(new ArrayList<>(thisList));
            return;
        }

        dfs(result, nums, thisList, index + 1);//不取
        thisList.add(nums[index]);
        dfs(result, nums, thisList, index + 1);//取

        thisList.remove(thisList.size() - 1);//去掉最后一个数
    }

    public void backtrack(int k, int start, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(k, i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }

    }

}
// @lc code=end
