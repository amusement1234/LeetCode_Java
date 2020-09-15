import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (47.16%)
 * Likes:    345
 * Dislikes: 0
 * Total Accepted:    44.9K
 * Total Submissions: 95.2K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * 
 * 
 * 进阶：
 * 
 * 你能在线性时间复杂度内解决此题吗？
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7] 
 * 解释: 
 * 
 * ⁠ 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        // 解法2：queue https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
        if (nums == null || k <= 0)
            return null;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque();//store index
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            //i=4 k=3
            while (!queue.isEmpty() && queue.peek() < i - k + 1)
                queue.poll();
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            // q contains index... r contains content
            queue.offer(i);
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[queue.peek()];
        }
        return res;

        // // 解法2：queue 忽略
        // MonotonicQueue window = new MonotonicQueue();
        // int n = nums.length;
        // List<Integer> res = new ArrayList();
        // for (int i = 0; i < nums.length; i++) {
        //     if (i < k - 1) {
        //         window.push(nums[i]);
        //     } else {
        //         window.push(nums[i]);
        //         res.add(window.max());
        //         window.pop(nums[i - k + 1]);
        //     }
        // }
        // return res.stream().mapToInt(s -> s).toArray();

        // 解法1：暴力法
        // int[] arr = new int[nums.length - k + 1];
        // for (int i = 0; i < nums.length - k + 1; i++) {
        //     int thisMax = nums[i];
        //     for (int j = i; j < i + k; j++) {
        //         thisMax = Math.max(thisMax, nums[j]);
        //     }
        //     arr[i] = thisMax;
        // }
        // return arr;
    }

}

//单调队列：从大到小。队首大，队尾小
public class MonotonicQueue {
    private Deque<Integer> data = new LinkedList<Integer>();

    public void push(Integer n) {
        //移除比当前小的元素
        while (!data.isEmpty() && data.peekLast() < n) //peek 获取队首元素
            data.pollLast();//移除队尾
        data.add(n);//队尾添加
    }

    public int max() {
        return data.peek();
    }

    public void pop(int n) {
        if (!data.isEmpty() && data.peek() == n)
            data.poll();//移除队首
    }
}
// @lc code=end
