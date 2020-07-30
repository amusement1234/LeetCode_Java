/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (54.99%)
 * Likes:    323
 * Dislikes: 0
 * Total Accepted:    30.7K
 * Total Submissions: 55.6K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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

    public ListNode reverseKGroup(ListNode head, int k) {
        //1. test weather we have more then k node left, if less then k node left we just return head 
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if (node == null)
                return head;
            node = node.next;
            count++;
        }
        // 2.reverse k node at current level    
             
        //pre=k到end反转之后的节点
        ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem 

        //pre 添加0-k的反转节点
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count--;
        }
        return pre;

        // // 解法3
        // Deque<ListNode> stack = new ArrayDeque<ListNode>();
        // ListNode dummy = new ListNode(0);
        // ListNode p = dummy;
        // while (true) {
        //     int count = 0;
        //     ListNode tmp = head;
        //     while (tmp != null && count < k) {
        //         stack.add(tmp);
        //         tmp = tmp.next;
        //         count++;
        //     }
        //     if (count != k) {
        //         p.next = head;
        //         break;
        //     }
        //     while (!stack.isEmpty()){
        //         p.next = stack.pollLast();
        //         p = p.next;
        //     }
        //     p.next = tmp;
        //     head = tmp;
        // }
        // return dummy.next;

        // 解法2
        // if (head == null)
        //     return null;
        // // 区间 [a, b) 包含 k 个待反转元素
        // ListNode a, b;
        // a = b = head;
        // for (int i = 0; i < k; i++) {
        //     // 不足 k 个，不需要反转，base case
        //     if (b == null)
        //         return head;
        //     b = b.next;
        // }
        // // 反转前 k 个元素
        // ListNode newHead = reverse(a, b);
        // // 递归反转后续链表并连接起来
        // a.next = reverseKGroup(b, k);
        // return newHead;

    }

    // /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    // ListNode reverse(ListNode a, ListNode b) {
    //     ListNode pre, cur, nxt;
    //     pre = null;
    //     cur = a;
    //     nxt = a;
    //     // while 终止的条件改一下就行了
    //     while (cur != b) {
    //         nxt = cur.next;
    //         cur.next = pre;// 逐个结点反转
    //         pre = cur;// 更新指针位置
    //         cur = nxt;
    //     }
    //     // 返回反转后的头结点
    //     return pre;
    // }
}
// @lc code=end
