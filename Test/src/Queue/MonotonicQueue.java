package queue;

import java.util.Deque;
import java.util.LinkedList;

//单调队列：从大到小。队首大，队尾小
public class MonotonicQueue {
    private Deque<Integer> data = new LinkedList<Integer>();

    public void push(Integer n) {
        //移除比当前小的元素
        while (!data.isEmpty() && data.peekLast() < n) //peek 获取队首元素
            data.pollLast();//移除队尾
        data.add(n);//队尾添加
    }

    public int max() {

        return data.peek();
    }

    public void pop(int n) {
        if (!data.isEmpty() && data.peek() == n)
            data.pop();//移除队首
    }
}