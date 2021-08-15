/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {

  List<List<Integer>> res = new ArrayList<List<Integer>>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    dfs(candidates, target, new ArrayList<Integer>(), 0);
    return res;
  }

  private void dfs(int[] candidates, int target, List<Integer> combine, int index) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      res.add(new ArrayList<Integer>(combine));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      combine.add(candidates[i]);
      dfs(candidates, target - candidates[i], combine, i);
      combine.remove(combine.size() - 1);
    }
  }
}
// @lc code=end
