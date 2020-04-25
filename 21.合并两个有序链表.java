/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (60.90%)
 * Likes:    965
 * Dislikes: 0
 * Total Accepted:    236.3K
 * Total Submissions: 386.1K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //方法 2：迭代
        // ListNode temp = new ListNode(-1);
        // ListNode list = temp;
        // while (l1 != null && l2 != null) {
        //     if (l1.val > l2.val) {
        //         list.next = new ListNode(l2.val);
        //         l2 = l2.next;
        //     } else {
        //         list.next = new ListNode(l1.val);
        //         l1 = l1.next;
        //     }
        //     list = list.next;

        // }
        // list.next = l1 == null ? l2 : l1;
        // return temp.next;

        //方法 1：递归
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //我们要判断 l1 和 l2 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
