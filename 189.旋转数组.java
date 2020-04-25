/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (41.01%)
 * Likes:    540
 * Dislikes: 0
 * Total Accepted:    114K
 * Total Submissions: 278K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // //方法1：暴力
        // int thisVal;
        // int prev;
        // for (int j = 0; j < k; j++) {
        //     prev = nums[nums.length - 1];
        //     for (int i = 0; i < nums.length; i++) {
        //         thisVal = nums[i];
        //         nums[i] = prev;
        //         prev = thisVal;

        //     }
        // }

        // //方法 2：使用额外的数组
        // int[] arr = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     arr[(k + i) % nums.length] = nums[i];
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = arr[i];

        // }

        //方法 3：使用环状替换

        //方法 4：使用反转
        if (nums == null || nums.length <= 1)
            return;
        if (nums.length == 2 && k == 1) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        k = k % nums.length;
        rev(nums, 0, nums.length - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, nums.length - 1);

    }

    public void rev(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
// @lc code=end
