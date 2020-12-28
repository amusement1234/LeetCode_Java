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

        // // 解法2：排序
        // if(nums.length==0) return 0;
        // Arrays.sort(nums);
        // return nums[nums.length/2];

        // 解法1：hash
        Map<Integer, Integer> map = new HashMap();
        int maxCount = 0;
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            if (count > maxCount) {
                maxCount = count;
                val = nums[i];
            }
        }
        return val;

        // //方法四：栈
        // Stack<Integer> stack = new Stack<>();
        // for (int i : nums) {
        //     if (stack.empty() || i == stack.peek())
        //         stack.push(i);
        //     else
        //         stack.pop();

        // }
        // return stack.peek();

    }

}
// @lc code=end
