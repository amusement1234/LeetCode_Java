/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (64.58%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    50.8K
 * Total Submissions: 78.5K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用队列实现栈的下列操作：
 * 
 * 
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 
 * 
 * 注意:
 * 
 * 
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 
 * 
 */

// @lc code=start
class MyStack {

    /** Initialize your data structure here. */
    public MyStack() {

    }

    private Queue<Integer> q1 = new LinkedList<>();
    //private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    /** Push element x onto stack. */
    public void push(int x) {

        //方法一 （两个队列，压入 -O(1)O(1)， 弹出 -O(n)O(n)）
        // q1.add(x);
        // top = x;

        // //方法二 （两个队列， 压入 - O(n)O(n)， 弹出 - O(1)O(1)）
        // q2.add(x);
        // top = x;
        // while (!q1.isEmpty()) {
        //     q2.add(q1.remove());
        // }
        // Queue<Integer> temp = q1;
        // q1 = q2;
        // q2 = temp;

        //方法三 （一个队列， 压入 - O(n)O(n)， 弹出 - O(1)O(1)）
        q1.add(x);
        top = x;
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        //方法一 （两个队列，压入 -O(1)O(1)， 弹出 -O(n)O(n)）
        // int t = top;
        // while (q1.size() > 1) {
        //     top = q1.remove();
        //     q2.add(top);
        // }
        // q1.remove();
        // Queue<Integer> temp = q1;
        // q1 = q2;
        // q2 = temp;
        // return t;

        //方法二、方法三
        q1.remove();
        int res = top;
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        return res;

    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
