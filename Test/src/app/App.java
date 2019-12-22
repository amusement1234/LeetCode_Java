package app;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import graph.Graph2;
import sort.MergeSort;
import tree.Heap;

public class App {
    public static void main(String[] args) throws Exception {

        // int a = (~5);
        // int b = (456 >> 1) & 1;
        // boolean b1 = (12 & 1) == 1;

        // int c = 12 & 12;

        // Heap heap = new Heap(10);
        // heap.insert(2);
        // heap.insert(1);
        // heap.insert(6);
        // heap.insert(9);
        // heap.removeMax();

        // Graph2 graph2 = new Graph2(8);
        // graph2.addEdge(0, 1);
        // graph2.addEdge(0, 3);

        // graph2.addEdge(1, 2);
        // graph2.addEdge(1, 4);

        // graph2.addEdge(2, 5);

        // graph2.addEdge(3, 4);

        // graph2.addEdge(4, 5);
        // graph2.addEdge(4, 6);

        // graph2.addEdge(5, 7);

        // graph2.addEdge(6, 7);

        // // graph2.bfs(0, 6);

        // graph2.dfs(0,6);

        int[] arr = new int[] { 1, 3, 2, 4, 5 };
        int result = new MergeSort().count(arr, 5);
        System.out.println(result);

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        // node.next.next = new ListNode(3);
        // node.next.next.next = new ListNode(4);
        // node.next.next.next.next = new ListNode(5);

        // ListNode nodeResult = new App().swapPairs(node);
        //  ListNode nre = new App().reverseKGroup(node, 3);

        boolean b=new App().isValid("()[]");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public ListNode swapPairs(ListNode head) {

        // 2、递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    // public ListNode swapPairs(ListNode head) {
    //     ListNode pre = new ListNode(0);
    //     pre.next = head;
    //     ListNode temp = pre;
    //     while (temp.next != null && temp.next.next != null) {
    //         ListNode start = temp.next;
    //         ListNode end = temp.next.next;
    //         temp.next = end;
    //         start.next = end.next;
    //         end.next = start;
    //         temp = start;
    //     }
    //     return pre.next;
    // }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null)
                break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
