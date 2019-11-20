package app;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        ListNode head2 = new ListNode(1);
        ListNode head3 = head2;
        head2.val=3;

        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i <= 5; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        ListNode temp = head;
        int index = 0;
        int val = -1;
        while (temp != null) {

            if (index % 2 == 0) {
                val = temp.val;
                if (temp.next != null) {
                    temp.val = temp.next.val;
                    temp.next.val = val;
                }
            }

            temp = temp.next;
            index++;
        }

        int i22 = 3;
    }
}
