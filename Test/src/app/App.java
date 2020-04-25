package app;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import graph.Graph2;
import sort.HeapSort;
import sort.MergeSort;
import sort.QuickSort;
import tree.Heap;

public class App {
    public static void main(String[] args) throws Exception {
        int[] fun = { 0, 1, 2, 3, 4, 5, 6 };
        System.arraycopy(fun, 0, fun, 3, 3);

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

        // int[] arr = new int[] { 1, 3, 2, 4, 5 };
        // int result = new MergeSort().count(arr, 5);
        // System.out.println(result);

        // ListNode node = new ListNode(1);
        // node.next = new ListNode(2);

        // node.next.next = new ListNode(3);
        // node.next.next.next = new ListNode(4);
        // node.next.next.next.next = new ListNode(5);

        // //ListNode nodeResult = new App().swapPairs(node);
        // ListNode nre = new App().reverseKGroup(node, 3);

        //boolean b=new App().isValid("()[]");

        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);

        // List<Integer> result333=new App().inorderTraversal(root);

        // TreeNode root2 = new TreeNode(4);
        // root2.left = new TreeNode(2);
        // root2.left.left = new TreeNode(13);
        // root2.left.right = new TreeNode(3);

        // boolean bll = new App().helper2(root2, null, null);

        // double mypow = new App().myPow(1.1, 3);

        // int[] nums = new int[] { 1, 2, 3 };
        // List<List<Integer>> list2 = new App().subsets(nums);

        // int greatestCommonDivisor = getGreatestCommonDivisor2(10, 25);

        // int n = 5;
        // int w = 10;
        // int[] g = new int[] { 500, 400, 350, 300, 200 };
        // int[] p = new int[] { 5, 5, 3, 4, 3 };
        // int result = getMostGold(n, w, g, p);

        // int x = 1;
        // boolean ddd = (x & 1) == 1;//奇数
        // boolean ddd2 = (x & 1) == 0;//偶数

        // int bb = x >> 1;// x/2

        // x <<= 1;

        // int n = 26;
        // int reverse = 0;
        // for (int i = 0; i < 5; i++) {
        //     reverse = reverse << 1;
        //     System.out.println(reverse);
        //     reverse = reverse + (n & 1);//n&1 = 取n的最后一位
        //     n >>= 1;
        // }

        // int[] arr = new int[] { 1, 4, 3, 6 };
        // int left = 0;
        // int right = arr.length - 1;
        // //QuickSort.quickSort(arr, left, right);
        // //MergeSort.mergeSort(arr, left, right);
        // HeapSort.heapSort(arr);

        // System.out.println(7);

        // final App multiThread1 = new App();
        // final App multiThread2 = new App();

        // new Thread(new Runnable() {
        //     public void run() {
        //         multiThread1.printNum("thread1", "a");
        //     }
        // }).start();

        // Thread.sleep(5000);
        // System.out.println("等待5秒，确保thread1已经执行完毕！");

        // new Thread(new Runnable() {
        //     public void run() {
        //         multiThread2.printNum("thread2", "b");
        //     }
        // }).start();

        // int[] nums = { 1, 1, 2 };
        // App.removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            arr.add(++a);
            arr2.add(b++);
        }

        return 1 + 1;

    }

    private static int num = 200;

    public static synchronized void printNum(String threadName, String tag) {
        if (tag.equals("a")) {
            num = num - 100;
            System.out.println(threadName + " tag a,set num over!");
        } else {
            num = num - 200;
            System.out.println(threadName + " tag b,set num over!");
        }
        System.out.println(threadName + " tag " + tag + ", num = " + num);
    }

    public static int getMostGold(int n, int w, int[] g, int[] p) {
        int[] preResults = new int[w];
        int[] results = new int[w];
        for (int i = 0; i < w; i++) {
            if (i < p[0])
                preResults[i] = 0;
            else
                preResults[i] = g[0];

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (j < p[i])
                    results[j] = preResults[j];
                else
                    results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
            }
            preResults = results;
        }
        return results[n];
    }

    public static int getGreatestCommonDivisor(int numberA, int numberB) {
        int smallNumber = numberA < numberB ? numberA : numberB;
        int bigNumber = numberA >= numberB ? numberA : numberB;
        if (bigNumber % smallNumber == 0)
            return smallNumber;
        for (int i = 2; i <= smallNumber / 2; i++) {
            if (numberA % i == 0 && numberB % i == 0)
                return i;
        }
        return 1;
    }

    public static int getGreatestCommonDivisor2(int numberA, int numberB) {

        int result = 1;
        if (numberA > numberB)
            result = gcd(numberA, numberB);
        else
            result = gcd(numberB, numberA);
        return result;
    }

    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null)
            return list;

        dfs(list, nums, new ArrayList<Integer>(), 0);
        return list;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> thisList, int index) {
        if (nums.length == index) {
            result.add(new ArrayList<>(thisList));
            return;
        }

        dfs(result, nums, thisList, index + 1);
        thisList.add(nums[index]);
        dfs(result, nums, thisList, index + 1);

        thisList.remove(thisList.size() - 1);//去掉最后一个数
    }

    private double fastPow(double x, long n) {
        System.out.println("x=" + x + ", n=" + n + ", x/2=" + (n / 2));
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        System.out.println("half=" + half);
        if (n % 2 == 0) {
            System.out.println("half * half=" + (half * half));
            return half * half;
        } else {
            System.out.println("half * half * x=" + (half * half * x));
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    public boolean helper2(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        int val = node.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        if (!helper2(node.right, val, upper))
            return false;
        if (!helper2(node.left, lower, val))
            return false;
        return true;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.empty()) {
            ColorNode cn = stack.pop();

            if (cn.color.equals("white")) {
                if (cn.node.right != null)
                    stack.push(new ColorNode(cn.node.right, "white"));
                stack.push(new ColorNode(cn.node, "gray"));
                if (cn.node.left != null)
                    stack.push(new ColorNode(cn.node.left, "white"));
            } else {
                res.add(cn.node.val);
            }
        }

        return res;
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;

    }

}
