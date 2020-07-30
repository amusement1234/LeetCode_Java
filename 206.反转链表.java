import java.util.ArrayList;
import java.util.List;

import app.ListNode;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (64.82%)
 * Likes:    645
 * Dislikes: 0
 * Total Accepted:    119.8K
 * Total Submissions: 182.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        // 解法3：迭代 时间复杂度：O(n)，空间复杂度：O(1)
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;//指向前一个结点
            pre = curr;
            curr = next;
        }
        return pre;

        // // 解法2：递归（当前方法）时间复杂度：O(n)，空间复杂度：O(n)
        // if (head == null || head.next == null) {
        //     return head;
        // }

        // ListNode list = reverseList(head.next);

        // head.next.next = head;// 下一个结点，指向自己
        // head.next = null;// 清空
        // return list;

        // // 解法1：递归
        // return reverseListInt(head, null);

    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
// @lc code=end
