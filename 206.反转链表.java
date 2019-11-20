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

        // 3、递归。
        if (head == null || head.next == null) {
            return head;
        }

        ListNode list = reverseList(head.next);
        head.next.next = head;// 下一个结点，指向自己
        head.next = null;// 清空
        return list;

        // // 2、双指针迭代
        // ListNode curr = head;
        // ListNode pre = null;
        // ListNode temp = null;
        // while (curr != null) {
        //     temp = curr.next;
        //     curr.next = pre;
        //     pre = curr;
        //     curr = temp;
        // }
        // return pre;

        // // 1 暴力法
        // if (head == null || head.next == null)
        //     return head;

        // ListNode head2 = head;
        // ListNode tmp2 = head2;

        // // 获取结点列表
        // List<Integer> list = new ArrayList<>();
        // while (head != null) {
        //     list.add(head.val);
        //     head = head.next;

        // }
        // // 反过来赋值
        // int index = list.size() - 1;
        // while (tmp2 != null) {
        //     tmp2.val = list.get(index--);
        //     tmp2 = tmp2.next;
        // }

        // return head2;

    }
}
// @lc code=end
