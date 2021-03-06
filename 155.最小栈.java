/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (50.42%)
 * Likes:    340
 * Dislikes: 0
 * Total Accepted:    61K
 * Total Submissions: 120.3K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */

// @lc code=start
class MinStack {

    // 解法3： https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x,null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    // 解法2：一个栈
    // int min;
    // Stack<Integer> stack;

    // /** initialize your data structure here. */
    // public MinStack() {
    //     min = Integer.MAX_VALUE;
    //     stack = new Stack();
    // }

    // public void push(int x) {
    //     if (x <= min) {
    //         stack.push(min);
    //         min = x;
    //     }
    //     stack.push(x);
    // }

    // public void pop() {
    //     if (stack.pop() == min)
    //         min = stack.pop();
    // }

    // public int top() {
    //     return stack.peek();
    // }

    // public int getMin() {
    //     return min;
    // }

    // 解法1：2个栈

    // private Stack<Integer> data;// 数据栈
    // private Stack<Integer> helper;// 最小栈

    // /**
    //  * initialize your data structure here.
    //  */
    // public MinStack() {
    //     data = new Stack<>();
    //     helper = new Stack<>();
    // }

    // public void push(int x) {
    //     // 数据栈和辅助栈一定会增加元素
    //     data.add(x);
    //     if (helper.isEmpty() || helper.peek() >= x) {
    //         helper.add(x);
    //     }
    // }

    // public void pop() {
    //     if (!data.isEmpty()) {
    //         int pop = data.pop();
    //         if (pop == helper.peek())
    //             helper.pop();
    //     }
    // }

    // public int top() {
    //     return data.peek();
    // }

    // public int getMin() {
    //     return helper.peek();
    // }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
