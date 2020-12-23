package app;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.net.InetAddress;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import graph.Graph2;
import huihui.MyQueue;
import huihui.PriorityQueue2;
import huihui.sort.bucketSort;
import huihui.sort.countSort;
import huihui.sort.quickSort;
import labuladong.kmp;
import labuladong.feibolaqie;
import queue.MonotonicQueue;
import huihui.MyBinaryTree;
import huihui.MyLinkedList;
import sort.HeapSort;
import sort.MergeSort;
import sort.QuickSort;
import tree.Heap;
import tree.UF;
import tree.wordTrie;
import java.util.Map.Entry;

public class App {

    public static void main(String[] args) throws Exception {

        new csNote.Sort.SelectionSort().sort(new Integer[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        new csNote.Sort.BubbleSort().sort(new Integer[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        new csNote.Sort.InsertionSort().sort(new Integer[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        new csNote.Sort.ShellSort().sort(new Integer[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        new csNote.Sort.Up2DownMergeSort().sort(new Integer[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        new csNote.Sort.QuickSort().sort(new Integer[] { 10, 9, 2, 5, 3, 7, 101, 18 });

        String s33 = reverseWords("Let's take LeetCode contest");
        String s22 = "abcdefg";
        String temp33 = reverseStr(s22, 2);

        int t_6 = longestValidParentheses2("()");

        // 解法1：递归
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int[][] memo = new int[nums.length + 1][nums.length];
        for (int[] item : memo) {
            Arrays.fill(item, -1);
        }
        int t_5 = lengthOfLIS(nums, -1, 0, memo);

        int[] t_4 = relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, new int[] { 2, 1, 4, 3, 9, 6 });
        int t_3 = reverseBits(43261596);
        sss2();

        int t_23 = 1 / 3;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int box = (i / 3) * 3 + j / 3;
                System.out.println("i:" + i + ",j:" + j + ",box:" + box);
            }
        }
        TrieNode trie2 = buildTrie(new String[] { "oath", "pea", "eat", "rain" });

        int r_4 = leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2);
        int r_3 = numDecodings("12");

        String word1 = "horse", word2 = "ros";
        int ttt2 = minDistance(word1, word2);
        int r_1 = largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 });
        int[] r_2 = maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);

        List<String> r388 = generateParenthesis(3);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode r4 = mergeTwoLists(head1, head2);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode r3 = reverseKGroup2(head, 2);

        ListNode temp = head;
        temp.val = 3;
        temp = temp.next;

        // //解法2：迭代 
        // ListNode temp=head;
        // int index=0;
        // while(temp!=null){
        //     if(index%2==0 && temp.next!=null){
        //         int val=temp.val;
        //         temp.val=temp.next.val;
        //         temp.next.val=val;
        //     }
        //     temp=temp.next;
        //     index++;
        // }

        int tdd = findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);

        String s1 = "abc";
        String s2 = "bac";
        char[] c11 = s1.toCharArray();
        char[] c12 = s2.toCharArray();
        Arrays.sort(c11);
        Arrays.sort(c12);
        boolean s34 = String.valueOf(c11).equals(String.valueOf(c12));
        String s_1 = "abab";
        String s_2 = "ab";
        List<Integer> i233 = findAnagrams(s_1, s_2);

        int ssfs = longestValidParentheses("()");

        Map<Integer, Integer> map222 = new TreeMap();
        map222.put(1, 2);
        map222.put(0, 0);
        Set<Entry<Integer, Integer>> dd = map222.entrySet();
        Set<Integer> keyset = map222.keySet();
        for (int n : map222.keySet()) {

        }
        String aaa2 = "abc";
        String baaa = change(aaa2, 1, 2);

        char[][] board = new char[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        App.isValidSudoku(board);

        UF uf = new UF(3);
        uf.union(0, 0);
        uf.union(0, 1);
        uf.union(2, 2);

        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(1);
        list3.add(2);
        list3.add(1);

        Integer ddd3 = list3.remove(1);

        wordTrie trie = new wordTrie();
        trie.insert("oath");
        trie.insert("pea");
        trie.insert("eat");
        trie.insert("rain");

        MonotonicQueue monotonicQueue = new MonotonicQueue();
        monotonicQueue.push(1);
        monotonicQueue.push(2);
        monotonicQueue.push(3);
        monotonicQueue.push(4);
        monotonicQueue.push(4);
        monotonicQueue.push(3);
        monotonicQueue.push(2);
        monotonicQueue.push(1);

        int m1 = monotonicQueue.max();
        monotonicQueue.pop(4);

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);

        ListNode lll = reverseBetween(l, 2, 4);
        int[] nums2 = new int[] { 3, 0, 1, 4, 5 };
        int rrr = MissNumber(nums2);
        int aaa = 27 % 10;
        int bbb = 15 / 10;
        int ccc = 4 ^ 4 ^ 4 ^ 4;

        Character c2 = ('b' | ' ');
        Character c3 = ('B' | ' ');

        Character c4 = ('b' & '_');
        Character c5 = ('B' & '_');

        Arrays.asList("Hello", "Java8", "Java7").stream().map(s -> s.toUpperCase());

        int[] commands = new int[] { 4, -1, 3 };
        int[][] obstacles = new int[0][0];
        int rob = App.robotSim(commands, obstacles);

        int sum = new feibolaqie().feb(10);
        int sum2 = new feibolaqie().feb2(10);
        int sum3 = new feibolaqie().feb3(10);
        int sum4 = new feibolaqie().feb4(10);

        int searIndex = new kmp("cab").search("abcabc");

        double[] tte2 = bucketSort.bucketSort2(new double[] { 1.3, 23, 55, 2.4, 3 });
        int[] ttt = countSort.countSort2(new int[] { 1, 23, 55, 2, 3 });

        // char[][] board = new char[4][4];
        // for (char[] chars : board)
        //     Arrays.fill(chars, '.');

        // boolean b = new App().isValid(board, 0, 0);

        // String next_digits = "DV";
        // String digit = next_digits.substring(0, 1);
        // String digit2 = next_digits.substring(0);

        // List<List<Integer>> output = new ArrayList();
        // for (int k = 0; k < nums.length + 1; ++k) {
        //     backtrack(k, 0, new ArrayList<Integer>(), nums, output);
        // }

        // int[] preorder = new int[] { 3, 9, 20, 15, 7 };
        // int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        // TreeNode r = new App().buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);

        // MyBinaryTree binaryTree = new MyBinaryTree();
        // int[] arr = new int[] { 1, 3, 2, 6, 5, 7, 8, 9, 10, 0 };
        // binaryTree.upAdjust(arr);

        // int[] arr2 = new int[] { 7, 1, 3, 10, 5, 2, 8, 9, 6 };
        // binaryTree.buildHeap(arr2);

        // PriorityQueue priorityQueue = new PriorityQueue();
        // priorityQueue.enQueue(10);
        // priorityQueue.enQueue(5);
        // priorityQueue.enQueue(3);
        // priorityQueue.enQueue(2);
        // priorityQueue.enQueue(7);

        // priorityQueue.deQueue();
        // priorityQueue.deQueue();

        // MyLinkedList list = new MyLinkedList();
        // list.insert(1, 0);
        // list.insert(2, 1);
        // list.insert(3, 2);
        // list.oupPut();

        // MyQueue myQueue = new MyQueue(5);
        // myQueue.enQueue(1);
        // myQueue.enQueue(2);
        // myQueue.enQueue(3);
        // myQueue.enQueue(4);
        // myQueue.deQueue();
        // myQueue.deQueue();
        // myQueue.outPut();

        // Integer[] arrTemp = new Integer[] { 3, 2, 9, null, null, 10, null, null, 8, null, 4 };
        // LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(arrTemp));
        // MyBinaryTree myBinaryTree = new MyBinaryTree();
        // TreeNode treenode = myBinaryTree.createBinaryTree(linkedList);
        // System.out.println("前序遍历：");
        // MyBinaryTree.preOrderTraversal(treenode);

        // StringBuilder cur=new StringBuilder();
        // cur.append("1234");
        // cur.deleteCharAt(cur.length() - 1);

        // LinkedList<Integer> queue = new LinkedList<>();//双端队列

        // queue.push(11);
        // queue.push(22);
        // queue.pop();

        // queue.add(1);
        // queue.add(2);
        // int ttt = queue.peek();//获取下标=0的值

        // queue.add(11);
        // boolean b23 = queue.add(22);//尾部添加
        // boolean b33 = queue.offer(44);//尾部添加
        // queue.push(33);//头部添加

        // queue.pop();
        // queue.remove();//移除头部
        // queue.poll();//移除头部

        // int t2 = queue.poll();

        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);

        // List<Integer> listsss = new App().preorderTraversal(root);

        // App app = new App();
        // app.push(1);
        // app.push(2);
        // app.push(3);

        // App app2 = new App();
        // app2.push2(1);
        // app2.push2(2);
        // app2.push2(3);

        // boolean bb = new App().isValid2("(]");

        // int[] fun = { 0, 1, 2, 3, 4, 5, 6 };
        // System.arraycopy(fun, 0, fun, 2, 4);

        int a = (~5);
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

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public App() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                if (stack.isEmpty())
                    return false;

                Character cc = stack.pop();
                if (this.mappings.get(c) != cc)
                    return false;

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;

    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);

        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

    }

    public void push2(int x) {

        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        q1.remove();
        int res = top;
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        return res;
    }

    public int pop2() {

        int t = top;
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return t;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int d = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                d++;
                if (d == 4)
                    d = 0;

            } else if (c == -2) {
                d--;
                if (d == -1) {
                    d = 3;
                }
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }

    public static int MissNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res ^= n;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1)
            return reverseN(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;

    }

    static ListNode successor = null;

    private static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static boolean isValidSudoku(char[][] board) {
        char[][][] arr = new char[10][10][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int box = (i / 3) * 3 + j / 3;
                int val = (int) board[i][j];
                arr[i][val][0] += 1;
                arr[j][val][1] += 1;
                arr[box][val][2] += 1;

                if (arr[i][val][0] > 1 || arr[j][val][1] > 1 || arr[box][val][2] > 1)
                    return false;
            }
        }
        return true;
    }

    public static String change(String s, int a, int b) {
        char[] chars = s.toCharArray();
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
        return Arrays.toString(chars).replaceAll("[\\[\\]\\s,]", "");
    }

    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] chars_s = s.toCharArray();
        char[] chars_p = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars_s.length - chars_p.length + 1; i++) {
            if (isContain(chars_s, chars_p, i))
                res.add(i);
        }
        return res;
    }

    public static boolean isContain(char[] c1, char[] c2, int index) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < c2.length; i++) {
            map.put(c2[i], map.getOrDefault(c2[i], 0) + 1);
        }

        for (int i = index; i < index + c2.length; i++) {
            if (!map.containsKey(c1[i]))
                return false;
            map.remove(c1[i]);
        }

        return map.isEmpty();
    }

    public static int findKthLargest(int[] nums, int k) {
        // 解法2：
        PriorityQueue<Integer> queue = new PriorityQueue<>();//小顶堆
        for (int val : nums) {
            queue.offer(val);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();

    }
    //  public class ListNode {
    //          int val;
    //          ListNode next;
    //          ListNode(int x) { val = x; }
    //     }    

    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (arr[j] == ' ') {
                j++;
            }
            while (j < n && arr[j] != ' ')
                j++;
            reverse(arr, i, j);
            i = j;
        }
        return String.valueOf(arr);
    }

    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 解法1：递归
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
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
        ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem 
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count--;
        }
        return pre;
    }

    public static List<String> generateParenthesis(int n) {
        // 解法2：dp
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (String first : lists.get(j)) {
                    for (String second : lists.get(i - 1 - j)) {
                        System.out.println("(" + first + ")" + second + "—————first:" + first + ",second:" + second
                                + ",i:" + i + ",j:" + j);
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }

    public static int largestRectangleArea(int[] heights) {

        // 解法3：stack 来自：https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int pop = stack.pop();
                int width = stack.isEmpty() ? i : (i - 1 - stack.peek());
                int thisArea = heights[pop] * width;
                maxArea = Math.max(maxArea, thisArea);
                i--;
            }
        }
        return maxArea;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        // 解法3：queue https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
        if (nums == null || k <= 0)
            return null;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque();//store index
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            //i=4 k=3
            while (!queue.isEmpty() && queue.peek() < i - k + 1)
                queue.poll();
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            // q contains index... r contains content
            queue.offer(i);
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[queue.peek()];
        }
        return res;
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int i = 1; i <= n; i++)
            dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }

    public static int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9)
                dp[i] += dp[i - 1];
            if (second >= 10 && second <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static int leastInterval(char[] tasks, int n) {
        // 解法1：排序
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;

    }

    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode p = root;
            for (int j = 0; j < words[i].length(); j++) {
                if (p.children[words[i].charAt(j) - 'a'] == null)
                    p.children[words[i].charAt(j) - 'a'] = new TrieNode();
                p = p.children[words[i].charAt(j) - 'a'];
            }
            p.word = words[i];
        }
        return root;
    }

    public static void sss2() {
        int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { -1, 1 }, { -1, -1 },
                { 1, 1 } };
        for (int k = 0; k < 8; k++) {
            int x = dir[k][0] + 0;
            int y = dir[k][1] + 0;
            System.out.println("k:" + k + ",x:" + x + ",y:" + y);
        }
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int digit = n & 1;
            res += digit;
            n >>= 1;
            if (i < 31)
                res <<= 1;
        }
        return res;
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap();
        for (int n : arr1)
            map.put(n, map.getOrDefault(n, 0) + 1);

        int i = 0;
        for (int n : arr2) {
            for (int j = 0; j < map.get(n); j++)
                arr1[i++] = n;
            map.remove(n);
        }

        for (int n : map.keySet()) {
            for (int j = 0; j < map.get(n); j++)
                arr1[i++] = n;
        }
        return arr1;
    }

    public static int lengthOfLIS(int[] nums, int pre, int cur, int[][] memo) {
        if (cur == nums.length)
            return 0;

        if (memo[pre + 1][cur] >= 0)
            return memo[pre + 1][cur];

        int taken = 0;
        if (pre < 0 || nums[cur] > nums[pre])
            taken = 1 + lengthOfLIS(nums, cur, cur + 1, memo);

        int nottaken = lengthOfLIS(nums, pre, cur + 1, memo);
        memo[pre + 1][cur] = Math.max(taken, nottaken);
        return memo[pre + 1][cur];
    }

    public static int longestValidParentheses2(String s) {
        // 解法2：stack
        int max = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            System.out.println("i:" + i + ",k:" + k);
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += k;
        }
        return String.valueOf(arr);
    }

    public static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static String reverseWords2(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            sb.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i;
        }
        return sb.toString().trim();
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;

    TrieNode() {
    }
}