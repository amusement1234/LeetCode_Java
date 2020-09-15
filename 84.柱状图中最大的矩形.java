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

        // 解法3：stack 来自：https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int pop = stack.pop();
                int width = stack.isEmpty() ? i : (i - 1 - stack.peek());
                int thisArea = heights[pop] * width;
                maxArea = Math.max(maxArea, thisArea);
                i--;
            }
        }
        return maxArea;

        // // 解法2：stack 难
        // Stack<Integer> stack = new Stack<>();
        // stack.push(-1);
        // int maxArea = 0;
        // for (int i = 0; i < heights.length; ++i) {
        //     while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
        //         maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
        //     stack.push(i);
        // }
        // while (stack.peek() != -1)
        //     maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        // return maxArea;

        // 解法1：优化的暴力法
        // int maxArea = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     int minheight = Integer.MAX_VALUE;
        //     for (int j = i; j < heights.length; j++) {
        //         minheight = Math.min(minheight, heights[j]);
        //         maxArea = Math.max(maxArea, minheight * (j - i + 1));
        //     }
        // }
        // return maxArea;
    }
}
// @lc code=end
