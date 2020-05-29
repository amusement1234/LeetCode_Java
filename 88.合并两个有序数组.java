import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (47.25%)
 * Likes:    482
 * Dislikes: 0
 * Total Accepted:    139K
 * Total Submissions: 293.6K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // //方法二 : 双指针 / 从前往后
        // int[] nums1_copy = new int[m];
        // System.arraycopy(nums1, 0, nums1_copy, 0, m);
        // int nums1_index = 0;
        // int nums2_index = 0;
        // int nums1_copy_index = 0;
        // while (nums1_copy_index < m && nums2_index < n) {
        //     nums1[nums1_index++] = nums1_copy[nums1_copy_index] > nums2[nums2_index] ? nums2[nums2_index++]
        //             : nums1_copy[nums1_copy_index++];
        // }
        // if (nums1_copy_index < m) {
        //     System.arraycopy(nums1_copy, nums1_copy_index, nums1, nums1_copy_index + nums2_index,
        //             m + n - (nums1_copy_index + nums2_index));
        // }
        // if (nums2_index < n) {
        //     System.arraycopy(nums2, nums2_index, nums1, nums1_copy_index + nums2_index,
        //             m + n - (nums1_copy_index + nums2_index));

        // }
        
        //方法三 : 双指针 / 从后往前
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2 
            // and add the largest one in nums1 
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }
}
// @lc code=end
