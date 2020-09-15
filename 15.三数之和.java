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

        // 解法2：双指针法
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;

        // // 解法1：暴力法
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
