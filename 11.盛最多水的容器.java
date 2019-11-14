/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (58.53%)
 * Likes:    849
 * Dislikes: 0
 * Total Accepted:    90.8K
 * Total Submissions: 155.2K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // [1,8,6,2,5,4,8,3,7]

        //2.双指针法
        int maxarea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int thisArea = (end - start) * Math.min(height[start], height[end]);
            maxarea = Math.max(maxarea, thisArea);

            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return maxarea;

        //1.暴力法
        // int maxarea = 0;
        // for (int i = 0; i < height.length; i++) {
        //     for (int j = i + 1; j < height.length; j++) {
        //         int thisArea = (j - i) * Math.min(height[i], height[j]);
        //         maxarea = Math.max(maxarea, thisArea);
        //     }
        // }
        // return maxarea;

    }
}
// @lc code=end
