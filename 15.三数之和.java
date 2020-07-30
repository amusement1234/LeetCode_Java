import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.20%)
 * Likes:    1523
 * Dislikes: 0
 * Total Accepted:    118.2K
 * Total Submissions: 483.6K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums = [-1, 0, 1, 2, -1, -4]，

        // 3、用指针 set
        Set<List<Integer>> set = new HashSet<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(set);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        return new ArrayList<>(set);

        // // 2.双指针法
        // List<List<Integer>> arr = new ArrayList<>();
        // if (nums == null || nums.length < 3)
        //     return arr;

        // Arrays.sort(nums);// 排序

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > 0)
        //         break;

        //     if (i > 0 && nums[i] == nums[i - 1])
        //         continue; // 去重

        //     int start = i + 1;
        //     int end = nums.length - 1;
        //     while (start < end) {
        //         int sum = nums[i] + nums[start] + nums[end];
        //         if (sum < 0)
        //             start++;
        //         else if (sum > 0)
        //             end--;
        //         else if (sum == 0) {
        //             List<Integer> tempList = Arrays.asList(nums[i], nums[start], nums[end]);
        //             arr.add(tempList);

        //             while (start < end && nums[start] == nums[start + 1])
        //                 start++; // 去重
        //             while (start < end && nums[end] == nums[end - 1])
        //                 end--; // 去重

        //             start++;
        //             end--;
        //         }
        //     }
        // }

        // return arr;

        // // 1.暴力法
        // List<List<Integer>> arr = new ArrayList<>();
        // Set<Set<Integer>> set = new HashSet<>();
        // if (nums == null || nums.length < 3)
        //     return arr;

        // for (int i = 0; i < nums.length - 2; i++) {
        //     for (int j = i + 1; j < nums.length - 1; j++) {
        //         for (int k = j + 1; k < nums.length; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 set.add(new HashSet(Arrays.asList(nums[i], nums[j], nums[k])));
        //             }
        //         }
        //     }
        // }

        // // 去重
        // for (Set<Integer> item : set) {
        //     Integer[] aaa = item.toArray(new Integer[3]);
        //     if (aaa[2] == null) {
        //         if (aaa[1] == null)
        //             aaa[1] = 0;
        //         aaa[2] = 0 - aaa[0] - aaa[1];
        //     }
        //     List<Integer> listt = Arrays.asList(aaa);
        //     arr.add(listt);
        // }
        // return arr;

       

    }
}
// @lc code=end
