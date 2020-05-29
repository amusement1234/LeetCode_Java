/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (46.53%)
 * Likes:    631
 * Dislikes: 0
 * Total Accepted:    32.7K
 * Total Submissions: 70K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // //解法1
        // int a=0;
        // int b=height.length-1;
        // int max=0;
        // int leftmax=0;
        // int rightmax=0;
        // while(a<=b){
        //     leftmax=Math.max(leftmax,height[a]);
        //     rightmax=Math.max(rightmax,height[b]);
        //     if(leftmax<rightmax){
        //         max+=(leftmax-height[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
        //         a++;
        //     }
        //     else{
        //         max+=(rightmax-height[b]);
        //         b--;
        //     }
        // }
        // return max;

        // //解法2
        // if (height == null)
        //     return 0;
        // Stack<Integer> s = new Stack<Integer>();
        // int i = 0, maxWater = 0, maxBotWater = 0;
        // while (i < height.length) {
        //     if (s.isEmpty() || height[i] <= height[s.peek()]) {
        //         s.push(i++);
        //     } else {
        //         int bot = s.pop();
        //         maxBotWater = s.isEmpty() ? // empty means no il
        //                 0 : (Math.min(height[s.peek()], height[i]) - height[bot]) * (i - s.peek() - 1);
        //         maxWater += maxBotWater;
        //     }
        // }
        // return maxWater;

        // //方法 1：暴力
        // int ans = 0;
        // int size = height.length;
        // for (int i = 1; i < size - 1; i++) {
        //     int max_left = 0, max_right = 0;
        //     for (int j = i; j >= 0; j--) { //Search the left part for max bar size
        //         max_left = Math.max(max_left, height[j]);
        //     }
        //     for (int j = i; j < size; j++) { //Search the right part for max bar size
        //         max_right = Math.max(max_right, height[j]);
        //     }
        //     ans += Math.min(max_left, max_right) - height[i];
        // }
        // return ans;

        // //方法 2：动态编程
        // if (height == null)
        //     return 0;
        // int ans = 0;
        // int size = height.length;
        // int[] left_max = new int[size];
        // int[] right_max = new int[size];
        // left_max[0] = height[0];
        // for (int i = 1; i < size; i++) {
        //     left_max[i] = Math.max(height[i], left_max[i - 1]);
        // }
        // right_max[size - 1] = height[size - 1];
        // for (int i = size - 2; i >= 0; i--) {
        //     right_max[i] = Math.max(height[i], right_max[i + 1]);
        // }
        // for (int i = 1; i < size - 1; i++) {
        //     ans += Math.min(left_max[i], right_max[i]) - height[i];
        // }
        // return ans;

        // //方法 3：栈的应用
        // int ans = 0, current = 0;
        // Stack<Integer> st = new Stack<Integer>();
        // while (current < height.length) {
        //     while (!st.empty() && height[current] > height[st.peek()]) {
        //         int top = st.peek();
        //         st.pop();
        //         if (st.empty())
        //             break;
        //         int distance = current - st.peek() - 1;
        //         int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
        //         ans += distance * bounded_height;
        //     }
        //     st.push(current++);
        // }
        // return ans;

        //方法 4：使用双指针
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    ans += (left_max - height[left]);
                ++left;
            } else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else
                    ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;

    }
}
// @lc code=end
