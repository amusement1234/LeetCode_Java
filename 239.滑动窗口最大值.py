#
# @lc app=leetcode.cn id=239 lang=python3
#
# [239] 滑动窗口最大值
#
# https://leetcode-cn.com/problems/sliding-window-maximum/description/
#
# algorithms
# Hard (46.92%)
# Likes:    347
# Dislikes: 0
# Total Accepted:    45.6K
# Total Submissions: 96.3K
# Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
#
# 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
# 个数字。滑动窗口每次只向右移动一位。
# 
# 返回滑动窗口中的最大值。
# 
# 
# 
# 进阶：
# 
# 你能在线性时间复杂度内解决此题吗？
# 
# 
# 
# 示例:
# 
# 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
# 输出: [3,3,5,5,6,7] 
# 解释: 
# 
# ⁠ 滑动窗口的位置                最大值
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
# ⁠1 [3  -1  -3] 5  3  6  7       3
# ⁠1  3 [-1  -3  5] 3  6  7       5
# ⁠1  3  -1 [-3  5  3] 6  7       5
# ⁠1  3  -1  -3 [5  3  6] 7       6
# ⁠1  3  -1  -3  5 [3  6  7]      7
# 
# 
# 
# 提示：
# 
# 
# 1 <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# 1 <= k <= nums.length
# 
# 
#

# @lc code=start
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # 方法一：暴力法
        # aaa=[]
        # for i in range(len(nums)-k+1):
        #     aaa.append(max(nums[i:i+k]))
        # return aaa

        # aaa=[max(nums[i:i + k]) for i in range(len(nums) - k + 1)]
        # return aaa

        # #方法二：双向队列
        # # base cases
        # n = len(nums)
        # if n * k == 0:
        #     return []
        # if k == 1:
        #     return nums
        
        # def clean_deque(i):
        #     # remove indexes of elements not from sliding window
        #     if deq and deq[0] == i - k:
        #         deq.popleft()
                
        #     # remove from deq indexes of all elements 
        #     # which are smaller than current element nums[i]
        #     while deq and nums[i] > nums[deq[-1]]:
        #         deq.pop()
        
        # # init deque and output
        # deq = deque()
        # max_idx = 0
        # for i in range(k):
        #     clean_deque(i)
        #     deq.append(i)
        #     # compute max in nums[:k]
        #     if nums[i] > nums[max_idx]:
        #         max_idx = i
        # output = [nums[max_idx]]
        
        # # build output
        # for i in range(k, len(nums)):
        #     clean_deque(i)          
        #     deq.append(i)
        #     output.append(nums[deq[0]])
        # return output
 

        # 方法三: 动态规划
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums
        
        left = [0] * n
        left[0] = nums[0]
        right = [0] * n
        right[n - 1] = nums[n - 1]
        for i in range(1, n):
            # from left to right
            if i % k == 0:
                # block start
                left[i] = nums[i]
            else:
                left[i] = max(left[i - 1], nums[i])
            # from right to left
            j = n - i - 1
            if (j + 1) % k == 0:
                # block end
                right[j] = nums[j]
            else:
                right[j] = max(right[j + 1], nums[j])
        
        output = []
        for i in range(n - k + 1):
            output.append(max(left[i + k - 1], right[i]))
            
        return output
 

# @lc code=end

