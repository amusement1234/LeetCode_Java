/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (37.51%)
 * Likes:    351
 * Dislikes: 0
 * Total Accepted:    21.6K
 * Total Submissions: 57.2K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {

        //栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;

        // //2.优化的暴力法
        // int maxarea = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     int minheight = Integer.MAX_VALUE;
        //     for (int j = i; j < heights.length; j++) {
        //         minheight = Math.min(minheight, heights[j]);
        //         maxarea = Math.max(maxarea, minheight * (j - i + 1));
        //     }
        // }
        // return maxarea;

        // //1.暴力法
        // int maxarea = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     for (int j = i; j < heights.length; j++) {
        //         int minheight = Integer.MAX_VALUE;
        //         for (int k = i; k <= j; k++)
        //             minheight = Math.min(minheight, heights[k]);
        //         maxarea = Math.max(maxarea, minheight * (j - i + 1));
        //     }
        // }
        // return maxarea;

    }
}
// @lc code=end
