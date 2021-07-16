/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // // 解法1：单指针
        // int n = nums.length;
        // int ptr = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == 0) {
        //         int temp = nums[i];
        //         nums[i] = nums[ptr];
        //         nums[ptr] = temp;
        //         ptr++;
        //     }
        // }
        // for (int i = ptr; i < n; i++) {
        //     if (nums[i] == 1) {
        //         int temp = nums[i];
        //         nums[i] = nums[ptr];
        //         nums[ptr] = temp;
        //         ptr++;
        //     }
        // }

        // // 解法2：双指针
        // int n = nums.length;
        // int p0 = 0, p1 = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == 0) {
        //         swap(nums, i, p0);
        //         if (p0 < p1) {
        //             swap(nums, i, p1);
        //         }
        //         p0++;
        //         p1++;
        //     } else if (nums[i] == 1) {
        //         swap(nums, i, p1);
        //         p1++;
        //     }
        // }

        // 解法3：双指针
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

