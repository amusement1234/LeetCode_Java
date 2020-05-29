import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (63.02%)
 * Likes:    597
 * Dislikes: 0
 * Total Accepted:    167.5K
 * Total Submissions: 264.8K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // //方法一：哈希表
        // Map<Integer, Integer> map = new HashMap<>();
        // int maxNum = 0;
        // int maxCount = 0;
        // for (int num : nums) {
        //     int count = map.getOrDefault(num, 0) + 1;
        //     map.put(num, count);
        //     if (count > maxCount) {
        //         maxCount = count;
        //         maxNum = num;
        //     }
        // }
        // return maxNum;

        // // 方法二：排序
        //         Arrays.sort(nums);
        //         return nums[nums.length / 2];

        // // 方法三：摩尔投票法
        // int thisVal = nums[0];
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (count == 0) {
        //         thisVal = nums[i];
        //     }

        //     if (thisVal == nums[i])
        //         count++;
        //     else
        //         count--;
        // }
        // return thisVal;

        //方法四：栈
        Stack<Integer> stack = new Stack<>();
        for (int i : nums) {
            if (stack.empty() || i == stack.peek()) {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        return stack.peek();

    }

}
// @lc code=end
