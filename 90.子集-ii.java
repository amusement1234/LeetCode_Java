/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // 解法1：回溯
    List<Integer> list = new ArrayList();
    List<List<Integer>> res = new ArrayList();
    Arrays.sort(nums);
    backtrace(nums, list, res, 0, false);
    return res;
  }

  public void backtrace(int[] nums, List<Integer> list, List<List<Integer>> res, int level, boolean b) {
    if (level == nums.length) {
      res.add(new ArrayList<Integer>(list));
      return;
    }

    //不选
    backtrace(nums, list, res, level + 1, false);

    if (!b && level > 0 && nums[level - 1] == nums[level]) {
      return;
    }

    //选
    list.add(nums[level]);
    backtrace(nums, list, res, level + 1, true);
    list.remove(list.size() - 1);
  }
}
// @lc code=end
