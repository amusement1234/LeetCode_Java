/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (62.54%)
 * Likes:    337
 * Dislikes: 0
 * Total Accepted:    52.1K
 * Total Submissions: 82.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // 解法2：迭代。替换指针。偶数的值，与下一个换。
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if (index % 2 == 0 && temp.next != null) {
                int val = temp.val;
                temp.val = temp.next.val;//同步更改head
                temp.next.val = val;//同步更改head
            }
            temp = temp.next;//不会同步更改head
            index++;
        }
        return head;

        // // 解法1：递归 a.next=b.next; b.next=a
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode next = head.next;
        // head.next = swapPairs(next.next);//a.next=b.next
        // next.next = head;//b.next=a
        // return next;

    }
}
// @lc code=end
