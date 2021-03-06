import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (42.66%)
 * Likes:    497
 * Dislikes: 0
 * Total Accepted:    115.7K
 * Total Submissions: 271K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // // 解法1：
        // if (intervals.length == 0) {
        //     return new int[0][2];
        // }
        // Arrays.sort(intervals,new Comparator<int[]>(){
        //     public int compare(int[] r1, int[] r2) {
        //         return r1[0] - r2[0];
        //     }
        // });

        // List<int[]> merged = new ArrayList<>();
        // for (int i = 0; i < intervals.length; i++) {
        //     int left = intervals[i][0];
        //     int right = intervals[i][1];
        //     if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
        //         merged.add(new int[] { left, right });
        //     } else {
        //         merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
        //     }

        // }
        // return merged.toArray(new int[merged.size()][]);

        // 解法2：
        int n = intervals.length;
        if (n == 0) {
            return intervals;
        }
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex = 0;
        int endIndex = 0;
        List<int[]> res = new ArrayList<>();
        while (endIndex < n) {
            if (endIndex == n - 1 || start[endIndex + 1] > end[endIndex]) {
                res.add(new int[] { start[startIndex], end[endIndex] });
                startIndex = endIndex + 1;
            }
            endIndex++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
