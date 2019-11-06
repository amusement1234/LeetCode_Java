import app.Stack;

package app;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayStack stack = new ArrayStack(3);
        stack.push("10");
        stack.push("11");
        stack.push("12");

        stack.pop();

        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.dequeue();
        queue.enqueue("4");
        queue.dequeue();

    }
}
