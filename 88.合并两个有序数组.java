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

        // 解法2：双指针,从后往前 https://leetcode.com/problems/merge-sorted-array/discuss/29522/This-is-my-AC-code-may-help-you
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];

        // // 解法1：双指针,从后往前
        // int index1 = m - 1;
        // int index2 = n - 1;
        // int mergeIndex = m + n - 1;
        // while (index1 >= 0 || index2 >= 0) {
        //     if (index1 < 0)
        //         nums1[mergeIndex--] = nums2[index2--];
        //     else if (index2 < 0)
        //         nums1[mergeIndex--] = nums1[index1--];
        //     else if (nums1[index1] > nums2[index2])
        //         nums1[mergeIndex--] = nums1[index1--];
        //     else
        //         nums1[mergeIndex--] = nums2[index2--];
        // }

    }
}
// @lc code=end
