/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(m>1){
            prev=prev.next;
            m--;
            n--;
        }
        head=prev.next;

        while(n>1){
            ListNode next=head.next;

            head.next=head.next.next;
            next.next=prev.next;
            prev.next=next;
            n--;
        }
        return dummy.next;
    }
}
// @lc code=end

