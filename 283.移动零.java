/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (56.98%)
 * Likes:    414
 * Dislikes: 0
 * Total Accepted:    76K
 * Total Submissions: 132.8K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // [0,1,0,3,12]

        // 4.不为0
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroIndex] = nums[i];
                notZeroIndex++;
            }
        }

        for (int i = notZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        // // 3.单指针 是0的
        // int zeroindex = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         zeroindex++;
        //     } else {
        //         int temp = nums[i];
        //         nums[i] = nums[i - zeroindex];
        //         nums[i - zeroindex] = temp;
        //     }
        // }

        // // 2.单指针 不是0的
        // int notZeroIndex = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         if (i > notZeroIndex) {
        //             nums[notZeroIndex] = nums[i];
        //             nums[i] = 0;
        //         }
        //         notZeroIndex++;
        //     }
        // }

        // //1.暴力法
        // int endZero = nums.length - 1;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0 && i < endZero) {
        //         for (int j = i; j < endZero; j++) {
        //             nums[j] = nums[j + 1];
        //         }
        //         nums[endZero] = 0;
        //         --endZero;
        //         i = -1;
        //     }

        // }

    }
}
// @lc code=end
