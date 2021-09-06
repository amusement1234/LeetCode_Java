import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (62.50%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 53.3K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 *
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 */

// @lc code=start
class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    // // 解法1：递归 从顶到下
    // row=triangle.size();
    // memo=new Integer[row][row];
    // return helper(0,0,triangle);

    // 解法2：dp 自底向上
    int row=triangle.size();
    int[] minLen=new int[row+1];
    for(int level=row-1;level>=0;level--){
      for(int i=0;i<=level;i++){
        minLen[i]=Math.min(minLen[i],minLen[i+1])+triangle.get(level).get(i);
      }
    }
    return minLen[0];
  }

  int row;
  Integer[][] memo;

  private int helper(int level,int c,List<List<Integer>> triangle){
    if(memo[level][c]!=null){
      return memo[level][c];
    }
    if(level==row-1){
      return memo[level][c]=triangle.get(level).get(c);
    }
    int left=helper(level+1,c,triangle);
    int right=helper(level+1,c+1,triangle);
    return memo[level][c]=Math.min(left,right)+triangle.get(level).get(c);
  }

}
// @lc code=end
